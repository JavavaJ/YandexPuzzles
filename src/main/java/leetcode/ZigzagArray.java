package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagArray {

    public int movesToMakeZigzag(int[] nums) {

        return 0;
    }

    // gets an array of boolean representation of ups and downs
    public boolean[] getOrderDirection(int[] nums) {
        // true represents increasing order, false - decreasing
        boolean[] directions = new boolean[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            directions[i] = nums[i] < nums[i + 1];
        }
        return directions;
    }


    public List<boolean[]> getZigzagDirectionArrays(int length) {
        List<boolean[]> arrays = new ArrayList<>();
        boolean[] startWithFalseArray = new boolean[length];
        boolean[] startWithTrueArray = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                startWithFalseArray[i] = false;
                startWithTrueArray[i] = true;
            } else {
                startWithFalseArray[i] = true;
                startWithTrueArray[i] = false;
            }
        }
        arrays.add(startWithFalseArray);
        arrays.add(startWithTrueArray);
        return arrays;
    }

}
