package codewars;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinProductsSumTest {

    @Test
    public void testMinSum() {
        assertEquals(MinProductsSum.minSum(new int[]{5, 4, 3, 2}), 22);
        assertEquals(MinProductsSum.minSum(new int[]{12,6,10,26,3,24}), 342);
        assertEquals(MinProductsSum.minSum(new int[]{9,2,8,7,5,4,0,6}), 74);
    }

}