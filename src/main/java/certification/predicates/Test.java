package certification.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<String> words = Stream.of("A" , "an" , "the" ,
                "when" , "what" , "Where" , "whether").collect(Collectors.toList());

        Predicate<String> predicateA = p -> true;
        Predicate<String> predicateB = p -> !!!!true;
        Predicate<String> predicateC = p -> !!false;
        Predicate<String> predicateD = p -> p.length() >= 1;
        Predicate<String> predicateE = p -> p.length() < 7;
//        Predicate<String> predicateF = (var p) -> p.length() < 100;
//        Predicate<String> predicateG = var p -> p.length() > 0;

        processStringArray(words, predicateA);
    }

    private static void processStringArray(List<String> list,
                                           Predicate<String> predicate) {
        for (String str : list) {
            if (predicate.test(str)) {
                System.out.println(str);
            }
        }
    }

}
