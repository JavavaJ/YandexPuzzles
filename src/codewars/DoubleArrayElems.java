package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DoubleArrayElems {

    public static int[] map(int[] arr) {
        return IntStream.of(arr).map(i -> i * 2).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        int[] arr2 = map(arr);
        System.out.println(Arrays.toString(arr2));
    }

}
