package codewars;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {

    static String encode(String word) {
        word = word.toLowerCase();
        // if boolean is true - duplicated letter, if false - unique letter
        Map<Character, Boolean> letters = new HashMap<>();
        StringBuilder resultSD = new StringBuilder("");

        for (Character character : word.toCharArray()) {
            letters = addCharToMap(character, letters);
        }

        for (Character character : word.toCharArray()) {
            boolean duplicated = letters.get(character);
            if (duplicated) {
                resultSD.append(")");
            } else {
                resultSD.append("(");
            }
        }

        return resultSD.toString();
    }

    private static Map<Character, Boolean> addCharToMap(Character character, Map<Character, Boolean> letters) {
        if (letters.containsKey(character)) {
            // check if boolean is true
            if (letters.get(character)) {
                // to nothing - letter is already duplicated
            } else {
                // duplicated letter - make true
                letters.put(character, Boolean.TRUE);
            }
        } else {
            // the first time letter
            letters.put(character, Boolean.FALSE);
        }

        return letters;
    }

    public static void main(String[] args) {
        System.out.println(encode("success"));
    }

}
