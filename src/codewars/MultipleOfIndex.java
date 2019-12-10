package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MultipleOfIndex {

    public static int[] multipleOfIndex(int[] array) {
        IntStream range = IntStream.range(0, array.length);
        int[] ints = range.filter(i -> array[i] % i == 0)
                .peek(System.out::println)
                .toArray();
        return ints;
//        return IntStream.range(0, array.length)
//                .filter(i -> array[i] % i == 0)
//                .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {};
        int[] arr2 = new int[] {22, -6, 32, 82, 9, 25};
        int[] arr3 = new int[] {};
        int[] arr4 = new int[] {};

        Arrays.stream(arr2).forEach(System.out::println);

        boolean zeroModulo = 7 % 0 == 0;
        System.out.println(zeroModulo);
    }

}
