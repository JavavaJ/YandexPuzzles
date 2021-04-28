package some_playground.java_8.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicExamples {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple",
            "apple", "orange",
            "melon", "orange",
            "cherry", "orange");

        Map<String, Long> result = fruits.stream()
            .collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result); // {orange=3, cherry=1, apple=2, melon=1}
    }

}
