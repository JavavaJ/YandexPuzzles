package codewars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Consider the numbers 6969 and 9116. When you rotate them 180 degrees (upside down),
// these numbers remain the same. To clarify, if we write them down on a paper and turn the paper upside down,
// the numbers will be the same. Try it and see! Some numbers such as 2 or 5 don't yield numbers when rotated.

// Given a range, return the count of upside down numbers within that range.
// For example, solve(0,10) = 3, because there are only 3 upside down numbers >= 0 and < 10. They are 0, 1, 8.

// https://www.codewars.com/kata/59f7597716049833200001eb/train/java

public class UpsideDown {

    private Set<Integer> rotatables = new HashSet<>(Arrays.asList(0, 1, 6, 8, 9));
    private Map<String, String> numMap = new HashMap<>();

    public UpsideDown() {
        numMap.put("0", "0");
        numMap.put("1", "1");
        numMap.put("6", "9");
        numMap.put("8", "8");
        numMap.put("9", "6");
    }

    public int solve(int x, int y) {
        List<String> upsideDowns = IntStream.range(x, y)
            .mapToObj(String::valueOf)
            .filter(this::hasOnlyRotatable)
            .filter(this::isSameAfterRotation)
            .collect(Collectors.toList());
        return upsideDowns.size();
    }

    public boolean hasOnlyRotatable(String number) {
        for (int i = 0; i < number.length(); i++) {
            char numChar = number.charAt(i);
            if (!rotatables.contains(Character.getNumericValue(numChar))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSameAfterRotation(String number) {
        StringBuilder sb = new StringBuilder();

        for (int i = number.length() - 1; i >= 0; i--) {
            String thisChar = Character.toString(number.charAt(i));
            sb.append(numMap.get(thisChar));
        }

        return number.equals(sb.toString());
    }
}
