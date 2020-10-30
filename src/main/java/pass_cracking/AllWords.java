package pass_cracking;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllWords {

    public static final String filePath = "src/main/resources/all_eng_words.txt";
    private final List<String> words;

    public AllWords() {
        words = read();
        System.out.println("Num of words: " + words.size());
    }

    @SneakyThrows
    public List<String> read() {
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("File exists!");
        } else {
            System.out.println("File doesn't exist!");
        }

        List<String> list = Files.lines(Paths.get(filePath))
            .map(String::toLowerCase)
            .collect(Collectors.toList());
        return list;
    }

    public List<String> getListOfMatchingWords(HashMap<Character, Boolean> letters) {
        List<String> matchWords = new ArrayList<>();
        List<Character> mustChars = new ArrayList<>();

        for (Map.Entry<Character, Boolean> entry : letters.entrySet()) {
            if (entry.getValue()) {
                mustChars.add(entry.getKey());
            }
        }

        for (String word : words) {
            boolean isCurrWordGood = true;
            letterLoop:for (int i = 0; i < word.length(); i++) {
                Boolean isAllowedLetter = letters.get(word.charAt(i));
                if (isAllowedLetter != null && !isAllowedLetter) {
                    isCurrWordGood = false;
                    break;
                }
            }
            if (isCurrWordGood) {
                for (Character mustChar : mustChars) {
                    if (!word.contains(Character.toString(mustChar))) {
                        break;
                    }
                }
                matchWords.add(word);
            }
        }
        return matchWords;
    }

    public List<String> getWords() {
        return words;
    }
}
