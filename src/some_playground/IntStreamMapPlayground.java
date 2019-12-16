package some_playground;

import java.util.stream.IntStream;

public class IntStreamMapPlayground {

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3);
        IntStream intStreamDoubled = intStream.map(i -> i + i);
        intStreamDoubled.forEach(System.out::print);
    }

}
