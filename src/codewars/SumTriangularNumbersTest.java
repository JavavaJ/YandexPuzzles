package codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SumTriangularNumbersTest {

    @Test
    public void testsumTriangularNumbers() {
        assertEquals(20, SumTriangularNumbers.sumTriangularNumbers(4));
        assertEquals(56, SumTriangularNumbers.sumTriangularNumbers(6));
        assertEquals(10, SumTriangularNumbers.sumTriangularNumbers(3));
        assertEquals(7140, SumTriangularNumbers.sumTriangularNumbers(34));

    }

}