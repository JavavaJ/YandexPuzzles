package codewars;

import java.util.stream.Stream;

public class OddTriangle {

    private static int getSumInclusive(int n) {
        int sum = Stream.iterate(1, i -> i + 2)
                .limit(n)
                .mapToInt(i -> i)
                .sum();
        return sum;
    }

    private static int getOrdinalNumInRow(int rowNum) {
        return (rowNum + 1) * rowNum / 2;
    }

    public static int rowSumOddNumbers(int n) {
        return getSumInclusive(getOrdinalNumInRow(n)) - getSumInclusive(getOrdinalNumInRow(n-1));

    }

    public static void main(String[] args) {
        System.out.println(rowSumOddNumbers(1) + " expected: 1");
        System.out.println(rowSumOddNumbers(2) + " expected: 8");
        System.out.println(rowSumOddNumbers(42) + " expected: 74088");

    }

}
