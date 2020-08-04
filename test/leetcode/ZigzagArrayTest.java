package leetcode;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ZigzagArrayTest {

    private ZigzagArray obj;

    @Before
    public void initObject() {
        obj = new ZigzagArray();
    }

//    @Test
//    public void movesToMakeZigzag() {
//
//        // [1,2,3] -> 2
//        // [9,6,1,6,2] -> 4
//        int[] arr1 = {1, 2, 3};
//        int[] arr2 = {9, 6, 1, 6, 2};
//
//        assertEquals(2, obj.movesToMakeZigzag(arr1));
//        assertEquals(4, obj.movesToMakeZigzag(arr2));
//    }

    @Test
    public void getOrderDirection() {
        int[] arr1 = {1, 2, 3};
        boolean[] expected1 = {true, true};
//        assertEquals(expected1, obj.getOrderDirection(arr1));
        assertThat(obj.getOrderDirection(arr1), is(expected1));
    }

//    @Test
//    public void getZigzagDirectionArrays() {
//        boolean[] arr1 = {false, true, false};
//        boolean[] arr2 = {true, false, true};
//        List<boolean[]> arrays = Arrays.asList(arr1, arr2);
////        assertEquals(arrays, obj.getZigzagDirectionArrays(3));
////        assertThat(arrays, is(obj.getZigzagDirectionArrays(3)));
//
//        List<boolean[]> zzArrays = obj.getZigzagDirectionArrays(3);
////        zzArrays.stream().forEach(el -> System.out.println(Arrays.toString(el)));
////        assertThat(zzArrays, is(arrays));
////        assertEquals(arrays, zzArrays);
//        assertThat(arrays.size(), is(zzArrays.size()));
//    }

    @Test
    public void compareListsPlayground() {
        List<String> list1 = Arrays.asList("one", "two", "three");
        List<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");

//        list1.add(0, "numberOne");
//        list1.set(0, "numberOne");

//        assertEquals(list1, list2);
        System.out.println("list1 hashcode: " + list1.hashCode());
        System.out.println("list2 hashcode: " + list2.hashCode());
    }

}