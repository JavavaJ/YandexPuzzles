package wordbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordbookParser {

    private static final String workBookPath = "src/wordbook/word_rus.txt";
    private static final String workingDir = "src/wordbook/";

    public static void main(String[] args) throws IOException {
        WordbookParser obj = new WordbookParser();
        Stream<String> allWords = obj.readStreamFromFile();
        String ending = "дон";
        List<String> wordsWithEnding = allWords.filter(word -> hasEnding(word, ending))
            .collect(Collectors.toList());

        String content = wordsWithEnding.stream().collect(Collectors.joining(" \n"));
        String fileName = "Words with " + ending;

        WordbookParser.writeFile(fileName, content);

    }

    public Stream<String> readStreamFromFile() {
        try {
            Stream<String> stream = Files.lines(Paths.get(workBookPath));
            return stream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean hasEnding(String word, String ending) {
        StringBuilder wordSB = new StringBuilder(word);
        StringBuilder endingSB = new StringBuilder(ending);

        int endingLen = ending.length();
        boolean hasEnding;
        if (word.length() >= ending.length()) {
            String fragment = wordSB.reverse()
                .substring(0, endingLen);
            hasEnding = fragment.toString()
                .equals(endingSB.reverse().toString());
        } else {
            hasEnding = false;
        }
        return hasEnding;
    }

    public static void writeFile(String fileName, String content) throws IOException {
        String fullPath = workingDir + fileName + ".txt";
        Path path = Paths.get(fullPath);

        Files.write(path, content.getBytes());
    }

}
