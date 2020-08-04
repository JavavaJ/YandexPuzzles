package predicates_playground;

import java.util.function.BiConsumer;

public class BiConsumerPlayground {

    public static void main(String[] args) {

        BiConsumer<String, String> isSameLength = (str1, str2) -> {
                    if (str1.length() == str2.length()) {
                        System.out.println("The strings are of the same length.");
                    } else {
                        System.out.println("The strings are NOT of the same length.");
                    }
                };

        String word1 = "home";
        String word2 = "went";

        isSameLength.accept(word1, word2);

    }

}
