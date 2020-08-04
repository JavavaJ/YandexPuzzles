package predicates_playground;

import java.util.function.Predicate;

public class PredicatePlayground {

    public static void main(String[] args) {
        Predicate<Integer> predicateLess100 = n -> n < 100;
        Predicate<Integer> predMore50 = n -> n > 50;

        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(predicateLess100.and(predMore50).negate().test(75));
        System.out.println("10 is even ?: " + isEven.test(10));

        System.out.println("Is even or less 100: " + isEven.or(predicateLess100).test(500));

        Predicate<String> predLongString = str -> str.length() > 10;
        String word1 = "home";
        String word2 = "simultaneously";

        System.out.println("Home:, long string:  " + predLongString.test(word1));
        System.out.println("simultaneously long string: " + predLongString.test(word2));

        Predicate<String> hasThreeOrMoreVowels = str -> {
            int vowelCount = 0;
            for (int i = 0; i < str.length(); i++) {
                String currChar = Character.toString(str.charAt(i));
                if ("aoieu".contains(currChar)) {
                    vowelCount++;
                }
            }
            return vowelCount >= 3;
        };

        System.out.println("Home has many vowels: " + hasThreeOrMoreVowels.test(word1));
        System.out.println("simultaneously  has many vowels: " + hasThreeOrMoreVowels.test(word2));



    }

}
