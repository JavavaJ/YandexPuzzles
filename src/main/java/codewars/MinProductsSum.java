package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinProductsSum {

    public static int minSum(int[] ints) {
        Arrays.sort(ints);
        int len = ints.length;
        return IntStream.range(0, ints.length / 2)
            .map(i -> ints[i] * ints[len - i - 1])
            .sum();
    }

}
