package codewars;

import java.util.Arrays;

public class MinProductsSum {

    public static int minSum(int[] ints) {
        int[] sortedInts = Arrays.stream(ints)
            .sorted()
            .toArray();
        int len = sortedInts.length;
        int sum = 0;
        for (int i = 0; i < ints.length / 2; i++) {
            sum += sortedInts[i] * sortedInts[len - 1 - i];
        }

        return sum;
    }

}
