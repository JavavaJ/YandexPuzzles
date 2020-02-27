package codewars.binary;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtraPerfectNumberTest {

    @Test
    public void testIsPerfectNumber() {
        assertTrue(ExtraPerfectNumber.isPerfectNumber(3));
        assertTrue(ExtraPerfectNumber.isPerfectNumber(7));
        assertTrue(ExtraPerfectNumber.isPerfectNumber(9));
        assertFalse(ExtraPerfectNumber.isPerfectNumber(6));
        assertFalse(ExtraPerfectNumber.isPerfectNumber(8));
    }

}