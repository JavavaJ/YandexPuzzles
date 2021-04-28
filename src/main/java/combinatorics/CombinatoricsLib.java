package combinatorics;

import org.paukov.combinatorics3.Generator;

public class CombinatoricsLib {

    public static void main(String[] args) {
//        Generator.combination("red", "black", "white", "green")
//            .simple(2)
//            .stream()
//            .forEach(System.out::println);

        String[] participants = {"Anna", "Igor", "Alexander", "Victoria", "Chris", "Maxim"};

        Generator.combination(participants)
            .simple(2)
            .stream()
            .forEach(System.out::println);

    }
}
