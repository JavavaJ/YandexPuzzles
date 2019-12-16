package some_playground;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamToIntStream {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 3, 5, 7, 9);
        IntStream intStream = integerStream.mapToInt(i -> i);

    }

}
