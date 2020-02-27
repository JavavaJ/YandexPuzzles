package codewars;

import java.util.Arrays;


public class ShortestWord {

    public static int findShort(String s) {
        return Arrays.stream(s.split(" "))
            .mapToInt(word -> word.length())
            .min()
            .getAsInt();
    }

    public static void main(String[] args) {
        String text = "This configuration will resolve dependencies using the match-by-name execution path. The bean namedFile must be defined in the ApplicationContextTestResourceNameType application context.";
        System.out.println(findShort(text));
    }

}
