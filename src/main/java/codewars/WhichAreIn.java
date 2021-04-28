package codewars;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*

    https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/java

    Given two arrays of strings a1 and a2 return a sorted array r in
    lexicographical order of the strings of a1 which are substrings of strings of a2.

    #Example 1: a1 = ["arp", "live", "strong"]

    a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

    returns ["arp", "live", "strong"]

    #Example 2: a1 = ["tarp", "mice", "bull"]

    a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

    returns []
 */
public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        List<String> outputList = new ArrayList<>();
        for (String sub : array1) {
            for (String bitStr : array2) {
                if (bitStr.contains(sub)) {
                    outputList.add(sub);
                    break;
                }
            }
        }
        outputList.sort(Comparator.naturalOrder());

        return outputList.toArray(new String[0]);
    }
}
