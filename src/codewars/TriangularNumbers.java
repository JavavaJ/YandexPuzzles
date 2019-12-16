package codewars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangularNumbers {

    public static void main(String[] args) {
        System.out.println("Debugging... ");
        sumTriangularNumbers(2);

    }

    public static int sumTriangularNumbers(int num) {
        if (num <= 0) {
            return 0;
        }

        Stream.generate(Math::random)
                .limit(5)
                .peek(el -> System.out.println(el))
                .collect(Collectors.toList());
        return 0;
    }




}
