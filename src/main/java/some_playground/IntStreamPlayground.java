package some_playground;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamPlayground {

    public static void main(String[] args) {

        String result = IntStream.concat(
                IntStream.of(2, 4, 6),
                IntStream.of(2, 4, 3)
        )
                .distinct()
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result); // 2 3 4 6


        String intStr = IntStream.generate(
                () -> ThreadLocalRandom
                        .current()
                        .nextInt(0, 10)
        )
                .limit(7)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(intStr);


        String ordinals = IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(ordinals); // 0 1 2 3 4 5 6 7 8 9

        int[] arr1 = new int[] {1, 3, 5, 7, 9};
        IntStream streamArr1 = Arrays.stream(arr1);

        int[] arr2 = new int[] {1, 3, 5, 7, 9};
        IntStream streamArr2 = IntStream.of(arr1);

    }

}
