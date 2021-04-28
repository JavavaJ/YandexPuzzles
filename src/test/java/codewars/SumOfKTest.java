package codewars;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class SumOfKTest {

    @Test
    public void getCombinations() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> integers = Arrays.asList(3, 66, 77, 1);

        Method method = SumOfK.class.getDeclaredMethod("getCombinations", int.class, List.class);
        method.setAccessible(true);

        Set<Set<Integer>> combinations = (Set<Set<Integer>>) method.invoke(new SumOfK(), 2, integers);

        assertThat(combinations.size()).isEqualTo(6);
    }

    @Test
    public void chooseBestSum() {
        List<Integer> ls1 = Arrays.asList(50, 55, 57, 58, 60);
        int t1 = 174;
        int k1 = 3;
        int expected1 = 173;

        Integer result1 = SumOfK.chooseBestSum(t1, k1, ls1);
        assertThat(result1).isEqualTo(expected1);


        List<Integer> ls2 = Arrays.asList(50, 55, 56, 57, 58);
        int t2 = 163;
        int k2 = 3;
        int expected2 = 163;

        Integer result2 = SumOfK.chooseBestSum(t2, k2, ls2);
        assertThat(result2).isEqualTo(expected2);

    }

    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(163, n);

        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);

        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = SumOfK.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }

}