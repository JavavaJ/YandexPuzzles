package leetcode;

//      Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
//    Note that elements beyond the length of the original array are not written.
//    Do the above modifications to the input array in place, do not return anything from your function.
//    Input: [1,0,2,3,0,4,5,0]
//    Output: null
//    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

public class DuplicateZeros1089 {

    public void duplicateZeros(int[] arr) {
        // [1,0,2,3,0,4,5,0]

        // count legit zeros to find slot to be written over
        int actualRightBound = findEndCount(arr);

        int pointer = arr.length - 1;
        // iterate from actualRightBound to the array's start
        for (int i = actualRightBound; i >= 0; i--) {
            // copy elem to the right of the array, keeping slot pointer, and remembering to duplicate zeros, if it is zero

            // the first iteration, if isOneZeroHalved - true and that first iteration is 0 - don't double zero
            if (i == actualRightBound && isOneZeroHalved(arr, actualRightBound) && arr[i+1] == 0) {
                arr[pointer] = 0;
                pointer--;
            }

            if (arr[i] == 0) {
                arr[pointer] = 0;
                pointer--;
                arr[pointer] = 0;
                pointer--;
            } else {
                arr[pointer] = arr[i];
                pointer--;
            }
        }

    }

    public int findEndCount(int[] arr) {
        int endCount = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i >= endCount) {
                break;
            }
            if (arr[i] == 0) {
                endCount--;
            }

        }
        return endCount - 1;
    }

    public boolean isOneZeroHalved(int[] arr, int endCount) {
        int fullArrSize = 0;
        for (int i = 0; i <= endCount; i++) {
            if (arr[i] == 0) {
                fullArrSize = fullArrSize + 2;
            } else {
                fullArrSize++;
            }
        }
        return arr.length != fullArrSize;
    }
}
