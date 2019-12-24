package codewars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Isogram {

    public static boolean isIsogramPlain(String str) {
        if (str.equals("")) {
            return true;
        }
        str = str.toLowerCase();
        boolean isIsogram = true;
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (i < str.length()-1 && str.substring(i+1).indexOf(currChar) != -1) {
                isIsogram = false;
                break;
            }
        }
        return isIsogram;
    }

    public static boolean isIsogram(String str) {
        return str.length() == str.chars().distinct().count();
    }

    public static void main(String[] args) {
        String str = "homecat";
        System.out.println(isIsogram(str));

        String moose = "moose";
        System.out.println("false is expected: " + isIsogram(moose));

        String dermatoglyphics = "Dermatoglyphics";
        System.out.println("True is expected: " + isIsogram(dermatoglyphics));

        String distinctNums = Stream.of(2, 3, 4, 5, 5, 5, 6, 7, 2, 3, 4)
                .distinct()
                .map(i -> i.toString())
                .collect(Collectors.joining(" "));

        System.out.println(distinctNums);


    }

}
