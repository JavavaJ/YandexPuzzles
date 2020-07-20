package codingbat.hard_loops;

import java.util.Arrays;

public class MaxMirror {

    public int maxMirror(int[] nums) {
        // loop to check fragments from size = len to 1
        for (int fragSize = nums.length; fragSize >= 1; fragSize--) {
            for (int i = 0; i < nums.length - fragSize + 1; i++) {
                int[] subArr = Arrays.copyOfRange(nums, i, i + fragSize);
                int [] reversed = reverseArray(subArr);
                // find reversed subArr from the end of nums
                for (int traverseFromEndIndex = nums.length - fragSize; traverseFromEndIndex >= 0; traverseFromEndIndex--) {
                    int[] arrayFragmentToCompare = Arrays.copyOfRange(nums, traverseFromEndIndex, traverseFromEndIndex + fragSize);
                    boolean areArraysSame = compareArrays(arrayFragmentToCompare, reversed);
                    if (areArraysSame) {
                        return fragSize;
                    }
                }
            }
        }
        return 0;
    }

    public int[] reverseArray(int[] arr) {
        int length = arr.length;
        int [] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[length - i - 1] = arr[i];
        }
        return reversed;
    }

    // both arrays should be of the same length
    public boolean compareArrays(int[] arr1, int[] arr2) {
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
