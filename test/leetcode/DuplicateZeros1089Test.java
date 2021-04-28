package leetcode;

import lombok.ToString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

class DuplicateZeros1089Test {

    private DuplicateZeros1089 obj;

    @BeforeEach
    public void init() {
        obj = new DuplicateZeros1089();
    }

    @Test
    void findEndCount() {
        int[] arr1 = {1, 2, 3};
        assertThat(obj.findEndCount(arr1)).isEqualTo(2);

        int[] arr2 = {1, 0, 3};
        assertThat(obj.findEndCount(arr2)).isEqualTo(1);

        int[] arr3 = {0, 0, 3, 4};
        assertThat(obj.findEndCount(arr3)).isEqualTo(1);

        int[] arr4 = {0, 0, 0, 0};
        assertThat(obj.findEndCount(arr4)).isEqualTo(1);

        int[] arr5 = {1,0,2,3,0,4,5,0};
        assertThat(obj.findEndCount(arr5)).isEqualTo(5);
    }

    @Test
    public void duplicateZeros() {
        int[] arr1 = {1,0,2,3,0,4,5,0};
        obj.duplicateZeros(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {8,4,5,0,0,0,0,7};
        System.out.println("End count: " + obj.findEndCount(arr2));
        obj.duplicateZeros(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {8,4,5,0,0,0,0,7,7,7};
        System.out.println("Halved? - " + obj.isOneZeroHalved(arr3, obj.findEndCount(arr3)));
        obj.duplicateZeros(arr3);
        System.out.println(Arrays.toString(arr3));

//        8,4,5,0,0,0,0,0

    }

    @Test
    public void isOneZeroHalved() {
        int[] arr1 = {1,0,2,3,0,4,5,0}; // -> false
        int endCount1 = obj.findEndCount(arr1);
        assertThat(obj.isOneZeroHalved(arr1, endCount1)).isFalse();

        int[] arr2 = {8,4,5,0,0,0,0,7}; // -> true
        int endCount2 = obj.findEndCount(arr2);
        assertThat(obj.isOneZeroHalved(arr2, endCount2)).isTrue();

    }

}