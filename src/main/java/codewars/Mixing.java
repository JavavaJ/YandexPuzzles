package codewars;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codewars.com/kata/5629db57620258aa9d000014/train/java

/*

    Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.

    s1 = "A aaaa bb c"

    s2 = "& aaa bbb c d"

    s1 has 4 'a', 2 'b', 1 'c'

    s2 has 3 'a', 3 'b', 1 'c', 1 'd'

    So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.

    We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.

    The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.

    In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing order of their length and when they have the same length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'. See examples and "Example Tests".

    Hopefully other examples can make this clearer.

    s1 = "my&friend&Paul has heavy hats! &"
    s2 = "my friend John has many many friends &"
    mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

    s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
    s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
    mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

    s1="Are the kids at home? aaaaa fffff"
    s2="Yes they are here! aaaaa fffff"
    mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"

 */

public class Mixing {

    private final static Set<Character> ALPHABET = IntStream.range(97, 123)
        .mapToObj(integer -> (char) integer)
        .collect(Collectors.toSet());
    private final static String DELIMITER = "/";

    public static String mix(String s1, String s2) {

        Map<Character, Integer> mapS1 = countLetters(s1);
        Map<Character, Integer> mapS2 = countLetters(s2);

//        Set<Character> allChars = new HashSet<>();
//        allChars.addAll(mapS1.keySet());
//        allChars.addAll(mapS2.keySet());

        Set<Character> allChars = s1.concat(s2)
            .chars()
            .mapToObj(i -> (char) i)
            .collect(Collectors.toSet());

        allChars.retainAll(ALPHABET);

        Map<Character, String> char2substring = new HashMap<>();
        Multimap<Integer, Character> count2char = ArrayListMultimap.create();

        for (Character character : allChars) {
            int count1 = mapS1.getOrDefault(character, 0);
            int count2 = mapS2.getOrDefault(character, 0);

            int max = Math.max(count1, count2);

            if (max > 1) {
                count2char.put(max, character);
            }

            if (count1 > count2 && count1 != 1) {
                String prefix = "1:";
                char2substring.put(character, prefix + repeat(character, count1));
            }
            if (count1 < count2 && count2 != 1) {
                String prefix = "2:";
                char2substring.put(character, prefix + repeat(character, count2));
            }
            if (count1 == count2 && count1 != 1) {
                String prefix = "=:";
                char2substring.put(character, prefix + repeat(character, count1));
            }
        }

        List<Integer> sortedKeys = count2char.keySet()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        StringBuilder outputSB = new StringBuilder();

        for (int i = 0; i < sortedKeys.size(); i++) {
            List<Character> characters = new ArrayList<>(count2char.get(sortedKeys.get(i)));

            outputSB.append(
                characters.stream()
                    .map(char2substring::get)
                    .sorted()
                    .collect(Collectors.joining(DELIMITER))
            );

            if (i != sortedKeys.size() - 1) {
                outputSB.append(DELIMITER);
            }

        }

        return outputSB.toString();
    }

    private static Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> mapS1 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (ALPHABET.contains(c)) {
                if (mapS1.containsKey(c)) {
                    Integer count = mapS1.get(c);
                    mapS1.put(c, ++count);
                } else {
                    mapS1.put(c, 1);
                }
            }
        }
        return mapS1;
    }

    private static String repeat(Character c, int times) {
        return String.join("", Collections.nCopies(times, c.toString()));
    }
}
