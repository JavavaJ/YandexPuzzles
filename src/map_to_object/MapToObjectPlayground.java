package map_to_object;

import java.util.stream.IntStream;

public class MapToObjectPlayground {

    public static void main(String[] args) {
//        Integer nine = new Integer(9);
//        System.out.println(StringNumberFactory.get(nine));
        IntStream.range(1, 7).mapToObj(i -> StringNumberFactory.get(i)).forEach(System.out::println);

    }

}
