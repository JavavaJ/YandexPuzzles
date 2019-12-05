package codewars;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class SumTriangularNumbers {

//    // before java 8 way
//    public static int sumTriangularNumbers(int n) {
//        if (n < 0) {
//            return 0;
//        }
//
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            int currentTriangNum = 0;
//            int initialNum = 1;
//            for (int j = 0; j < i; j++) {
//                currentTriangNum += initialNum;
//                initialNum++;
//            }
//            sum += currentTriangNum;
//        }
//
//        return sum;
//    }

    public static int sumTriangularNumbers(int n) {
        if (n < 0) {
            return 0;
        }

        Integer sum = IntStream
                .rangeClosed(1, n)
                .flatMap(i -> sumConsecutiveNumbers(i))
                .reduce(0, (a, b) -> a + b);

        return sum;
    }

    public static IntStream sumConsecutiveNumbers(int num) {
        return IntStream
                .iterate(1, el -> el + 1)
                .limit(num);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            Integer total = Stream
                    .iterate(1, num -> num + 1)
                    .limit(i)
                    .reduce(0, (a, b) -> a + b);
            System.out.println(total);

        }
    }

}
