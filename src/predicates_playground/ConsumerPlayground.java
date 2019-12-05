package predicates_playground;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerPlayground {

    public static void main(String[] args) {
        Consumer<Integer> displayIfGreater10 = n -> {
            if (n >= 10) {
                System.out.println("The number is greater than 10");
            } else {
                System.out.println("The number is smaller than 10");
            }
        };

        displayIfGreater10.accept(17);
        displayIfGreater10.accept(8);

        Consumer<Integer> sumOfSmallerIntegers = num -> {
            int sum = 0;
            for (int i = 0; i <= num; i++) {
                sum += i;
            }
            System.out.println("Sum of the smaller elements: " + sum);
        };

        sumOfSmallerIntegers.accept(10);
        sumOfSmallerIntegers.accept(11);

        Consumer<List<Integer>> printNumOfOddIntegers = list -> {
            int numOfOddInts = 0;
            for (Integer integer : list) {
                if (integer % 2 != 0) {
                    numOfOddInts++;
                }
            }
            System.out.println("The number of odd integers in a list: " + numOfOddInts);
        };

        int[] intPrimArray = new int[] {7, 4, 9, 8, 2, 12, 4};

        List<Integer> numbers = Arrays
                .stream(intPrimArray)
                .boxed()
                .collect(Collectors.toList());

        printNumOfOddIntegers.accept(numbers);

        List<Integer> otherNumbers = Arrays
                .stream(new int[]{111, 7, 9, 5, 3, 2, 4, 5, 5})
                .boxed()
                .collect(Collectors.toList());

        printNumOfOddIntegers.accept(otherNumbers);

        List<Integer> numberList = Stream
                .of(1, 3)
                .collect(Collectors.toList());

        printNumOfOddIntegers.accept(numberList);

        Consumer<List<Integer>> printLeftOnlyEvenInts = list -> {
            List<Integer> evenNumList = list.stream()
                    .filter(num -> num % 2 == 0)
                    .collect(Collectors.toList());
            System.out.println(evenNumList);
        };

        Consumer<List<Integer>> muplitplyElemByTwo = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
        };

        Consumer<List<Integer>> printList = list -> {
            list.forEach(el -> System.out.print(el + " "));
        };

        List<Integer> integerList = Stream
                .of(1, 2, 3, 4, 5, 6, 7, 8, 9, 12)
                .collect(Collectors.toList());

        muplitplyElemByTwo.andThen(printList).accept(integerList);




    }

}
