package codewars;

import java.util.stream.IntStream;

public class HalvingSum {

    public int halvingSum(int n) {
        int result = 0;
        int count = 0;

        boolean condition = false;
        while (true) {
            int addend = n / (int) Math.pow(2, count);
            condition = addend > 0;
            if (!condition) {
                break;
            }
            result += addend;
            count++;
        }

        return result;
    }

    int halvingSum2(int n) {
        return IntStream.iterate(n, x -> x != 0, x -> x / 2).sum();
    }

}
