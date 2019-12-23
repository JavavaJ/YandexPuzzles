package codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineNumbering {

    // Your team is writing a fancy new text editor and you've been
    // tasked with implementing the line numbering.
    // Write a function which takes a list of strings and returns
    // each line prepended by the correct number. The numbering starts at 1.
    // The format is n: string. Notice the colon and space in between.
    public static List<String> number(List<String> lines) {
        String[] strArray = lines.toArray(new String[lines.size()]);
        List<String> stringList = IntStream.rangeClosed(1, lines.size())
                .mapToObj(i -> "" + i + ": " + strArray[i - 1])
                .collect(Collectors.toList());
        return stringList;
    }

    public static List<String> numberShorter(List<String> lines) {
        List<String> stringList = IntStream.rangeClosed(0, lines.size())
                .mapToObj(i -> String.format("%d: %s", i+1, lines.get(i)))
                .collect(Collectors.toList());
        return stringList;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        number(strings).stream().forEach(System.out::println);


        List<String> strings2 = Arrays.asList("", "", "", "", "");
        number(strings2).stream().forEach(System.out::println);

        List<String> objects = Arrays.asList();
        number(objects).stream().forEach(System.out::println);

    }

}
