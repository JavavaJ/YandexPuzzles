package codewars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeTwoUniqueArrays {

    public static int[] mergeArrays(int[] first, int[] second) {
        Set<Integer> intSet = new HashSet<>();
        List<Integer> firstInts = Arrays.stream(first)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> secondInts = Arrays.stream(second)
                .boxed()
                .collect(Collectors.toList());
        intSet.addAll(firstInts);
        intSet.addAll(secondInts);
        List<Integer> sortedMergedList = intSet.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        int[] ints = sortedMergedList.stream()
                .mapToInt(i -> i)
                .toArray();

        return ints;
    }

//    Write a function that merges two sorted arrays into a single one.
//    The arrays only contain integers.
//    Also, the final outcome must be sorted and not have any duplicate.
    public static int[] mergeArraysBetterWay(int[] first, int[] second) {
        int[] ints = IntStream.concat(IntStream.of(first), IntStream.of(second))
                .distinct()
                .sorted()
                .toArray();

        return ints;
    }

    public static void main(String[] args) {
        int[] first = new int[] {1, 2, 5, 5, 3, 7, 8, 9};
        int[] second = new int[] {11, 4, 7, 22, 4, 6, 2, 8};
        int[] result = mergeArrays(first, second);

        String resultStr = Arrays.toString(result);
        System.out.println(resultStr);

    }

}
