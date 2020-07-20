package codingbat.hard_loops;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxMirrorTest {

    @Test
    public void maxMirror() {
        MaxMirror obj = new MaxMirror();

        int[] arr1 = new int[] {1, 2, 3, 8, 9, 3, 2, 1};
        int[] arr2 = new int[] {1, 2, 1, 4};
        int[] arr3 = new int[] {7, 1, 2, 9, 7, 2, 1};

        assertEquals(obj.maxMirror(arr1), 3);
        assertEquals(obj.maxMirror(arr2), 3);
        assertEquals(obj.maxMirror(arr3), 2);
    }
}