package codewars;

import java.util.Arrays;
import java.util.Comparator;

public class SortAndStar {

    // You will be given an vector of string(s). You must sort it
    // alphabetically (case-sensitive!!) and then return the first value
    //The returned value must be a string, and have "***" between each of
    // its letters. You should not remove or add elements from/to the array
    public static String twoSort(String[] s) {
        s = Arrays.stream(s)
                .sorted(Comparator.naturalOrder())
                .toArray(String[]::new);
        String firstStr = s[0];
        String outputStr = "";
        for (int i = 0; i < firstStr.length(); i++) {
            if (i != (firstStr.length()-1)) {
                outputStr = outputStr + firstStr.charAt(i) + "***";
            } else {
                outputStr += firstStr.charAt(i);
            }
        }
        return outputStr;
    }

    public static String twoSortMoreConcise(String[] s) {
        return String.join("***", Arrays.stream(s)
                .sorted()
                .findFirst()
                .orElse("")
                .split(""));
    }

    public static void main(String[] args) {
        String[] strings = {"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"};
        System.out.println(twoSort(strings));
    }

}
