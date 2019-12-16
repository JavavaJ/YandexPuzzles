package some_playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjectPlayground {

    public static void main(String[] args) {
        String str = "home";
        Object obj = (Object) str;
        System.out.println(obj instanceof String);
        System.out.println(obj instanceof Object);
        System.out.println(obj instanceof Integer);

        System.out.println("===============");

        Object strAsObj = "dog";
        System.out.println(strAsObj instanceof String);
        System.out.println(strAsObj instanceof Object);

        List<Integer> integers = IntStream.of(2, 3, 4, 5, 6)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        List<String> words = Arrays.asList("one", "two", "three");
        printList(integers);
        printList(words);

    }

    public static void printList(List<?> list) {
        System.out.println(list.stream()
                .map(i -> ((Object) i).toString())
                .collect(Collectors.joining(" ")));
    }

}