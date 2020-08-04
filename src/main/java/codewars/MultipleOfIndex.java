package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultipleOfIndex {

    public static int[] multipleOfIndex(int[] array) {
        IntStream range = IntStream.range(1, array.length);
        int[] ints = range.filter(i -> array[i] % i == 0).map(i -> array[i])
                .toArray();
        return ints;
//        return IntStream.range(0, array.length)
//                .filter(i -> array[i] % i == 0)
//                .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {22, -6, 32, 82, 9, 25};

        int[] ints = multipleOfIndex(arr1);

        printIntArray(ints);
    }

    private static void printIntArray(int[] ints) {
        String strResult = Arrays.stream(ints)
                .mapToObj(i -> String.valueOf(i))
                .collect(Collectors.joining(" "));
        System.out.println(strResult);
    }

//    // old Java solution
//    public static int[] multipleOfIndex(int[] array) {
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (i != 0 && array[i] % i == 0) {
//                result.add(array[i]);
//            }
//        }
//        int[] ints = result.stream()
//                .mapToInt(i -> i)
//                .toArray();
//        return ints;
//    }

}
