package combinatorics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class RecursiveCombinatorTest {

    @Test
    public void generate() {
        RecursiveCombinator combinator = new RecursiveCombinator();
        List<int[]> combinations = combinator.generate(4, 2);
        printCombinations(combinations);
    }

    @Test
    public void listOfNames() {
        String[] participants = {"Anna", "Igor", "Alexander", "Victoria", "Chris", "Maxim"};
        Map<Integer, String> nameMap = IntStream.range(0, participants.length)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), i -> participants[i]));

        int len = participants.length;
        int groupsSize = 2;

        RecursiveCombinator combinator = new RecursiveCombinator();
        List<int[]> numCombinations = combinator.generate(len, groupsSize);

        printCombinationsWithMap(numCombinations, nameMap);
    }

    private void printCombinations(List<int[]> combinations) {
        for (int[] combination : combinations) {
            System.out.println();
            System.out.print("[");
            for (int i = 0; i < combination.length; i++) {
                System.out.print(combination[i]);
                if (i != combination.length-1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        }
    }

    private void printCombinationsWithMap(List<int[]> combinations, Map<Integer, String> nameMap) {
        for (int[] combination : combinations) {
            System.out.println();
            System.out.print("[");
            for (int i = 0; i < combination.length; i++) {
                int num = combination[i];
                System.out.print(nameMap.get(num));
                if (i != combination.length-1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        }
    }

}