package some_playground.java_8.summingInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SummingIntExample {

    public void run() {
        List<Integer> nums = Arrays.asList(5, 3, 7, 9, 2, 4, 6, 8);

        Integer evensSum = nums.stream()
            .collect(Collectors.summingInt(num -> num % 2 == 0 ? num : 0));
        Integer oddsSum = nums.stream()
            .collect(Collectors.summingInt(num -> num % 2 != 0 ? num : 0));

        System.out.println("evensSum: " + evensSum);
        System.out.println("oddsSum: " + oddsSum);
    }
}
