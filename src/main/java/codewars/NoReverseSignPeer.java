package codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

// In this Kata, you will be given an array of integers whose elements have both a negative and a positive value,
// except for one integer that is either only negative or only positive. Your task will be to find that integer.
// [1, -1, 2, -2, 3] => 3

public class NoReverseSignPeer {

    public static int solve(int [] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(Math.abs(num))) {
                Integer value = map.get(Math.abs(num));
                // if the value is of the opposite sign - make it 2
                if ((value < 0 && num > 0) || (value > 0 && num < 0)) {
                    map.put(Math.abs(num), 2);
                }
                // if the value is of the same sign - leave it as it is
            } else {
                if (num < 0) {
                    map.put(Math.abs(num), -1);
                } else {
                    map.put(Math.abs(num), 1);
                }
            }
        }
        Integer one = 1;
        Integer minusOne = -1;

        Predicate<Map.Entry<Integer, Integer>> isOne = e -> one.equals(e.getValue());
        Predicate<Map.Entry<Integer, Integer>> isMinusOne = e -> minusOne.equals(e.getValue());

        Integer absoluteResult = map.entrySet()
            .stream()
            .filter(isOne.or(isMinusOne))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(0);
        return Arrays.stream(arr)
            .boxed()
            .filter(num -> absoluteResult.equals(Math.abs(num)))
            .findFirst().orElse(0);
    }
}
