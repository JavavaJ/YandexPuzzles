package codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumConsequtiveDiffs {

    public static int sumOfDifferences(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }

        List<Integer> sortedInputList =
                Arrays.stream(arr)
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < sortedInputList.size()-1; i++) {
            int num1 = sortedInputList.get(i);
            int num2 = sortedInputList.get(i+1);
            sum += num1 - num2;
        }

        // this is a synonymical statement
        int sumStream = IntStream.range(0, sortedInputList.size() - 1)
                .map(i -> sortedInputList.get(i) - sortedInputList.get(i+1))
                .sum();

        System.out.println(sumStream);

        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 8, 6};
        System.out.println("Real: " + sumOfDifferences(arr1));
    }

}
