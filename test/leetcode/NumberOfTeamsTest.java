package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfTeamsTest {

    @Test
    public void isValidOrderInts() {
        NumberOfTeams obj = new NumberOfTeams();
        assertTrue(obj.isValidOrder(1, 2, 3));
        assertTrue(obj.isValidOrder(3, 2, 1));
        assertFalse(obj.isValidOrder(4, 7, 2));
    }

    @Test
    public void numTeams() {
        // [2,5,3,4,1] -> 3
        // [2,1,3] -> 0
        // [1,2,3,4] -> 4

        NumberOfTeams obj = new NumberOfTeams();

        int[] arr1 = {2,5,3,4,1};
        int[] arr2 = {2,1,3};
        int[] arr3 = {1,2,3,4};

        assertEquals(3, obj.numTeams(arr1));
        assertEquals(0, obj.numTeams(arr2));
        assertEquals(4, obj.numTeams(arr3));
    }

}