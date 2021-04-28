package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SumArray {

    public static double sum(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
