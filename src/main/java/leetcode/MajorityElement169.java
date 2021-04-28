package leetcode;

import java.util.*;


public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        Map<Integer, Integer> num2count = new HashMap<>();

        for (Integer currNum : nums) {
            if (num2count.containsKey(currNum)) {
                Integer val = num2count.get(currNum);
                num2count.put(currNum, ++val);
            } else {
                num2count.put(currNum, 1);
            }
        }

        Optional<Map.Entry<Integer, Integer>> maxEntry = num2count.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get().getKey();
    }
}
