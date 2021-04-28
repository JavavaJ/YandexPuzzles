package codewars;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MaxDiffLength {

    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return -1;
        }

        IntSummaryStatistics a1Stats = Arrays.stream(a1)
            .mapToInt(String::length)
            .summaryStatistics();

        IntSummaryStatistics a2Stats = Arrays.stream(a2)
            .mapToInt(String::length)
            .summaryStatistics();

        return Math.max(a1Stats.getMax() - a2Stats.getMin(),
            a2Stats.getMax() - a1Stats.getMin());
    }
}