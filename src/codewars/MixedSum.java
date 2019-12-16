package codewars;

import java.util.Arrays;
import java.util.List;

public class MixedSum {

    /* Given an array of integers as strings and numbers,
     * return the sum of the array values as if all were numbers.
     * Assume input will be only of Integer o String type
     */
    public int sum(List<?> mixed) {
        int sum = mixed.stream()
                .mapToInt(i -> {
                    Integer currInt = null;
                    if (i instanceof String) {
                        currInt = Integer.parseInt((String) i);
                    } else if (i instanceof Integer) {
                        currInt = (Integer) i;
                    }
                    return currInt;
                })
                .sum();
        ;
        return sum;
    }

    public static void main(String[] args) {
        MixedSum mixedSum = new MixedSum();
        int sum1 = mixedSum.sum(Arrays.asList("1", "5", "8", 8, 9, 9, 2, "3"));
        System.out.println(sum1);
        int sum2 = mixedSum.sum(Arrays.asList("3", 6, 6, 0, "5", 8, 5, "6", 2, "0"));
        System.out.println(sum2);
    }

}
