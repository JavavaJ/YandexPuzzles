package codewars;

import java.util.stream.IntStream;

public class SquareSums {

    public static int squareSum(int[] n) {
        return IntStream.of(n).map(i -> i*i).sum();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2};
        int[] arr2 = new int[] {1, 2};
        int[] arr3 = new int[] {5, -3, 4};
        System.out.println(squareSum(arr));
        System.out.println(squareSum(arr2));
        System.out.println(squareSum(arr3));
    }

}
