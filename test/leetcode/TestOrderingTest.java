package leetcode;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class TestOrderingTest {

    private StringBuilder output = new StringBuilder("");

    @Test
    public void firstTest() {
        output.append("a");
    }

    @Test
    public void secondTest() {
        output.append("b");
    }

    @Test
    public void thirdTest() {
        output.append("c");
    }

    public void assertOutput() {
        assertEquals(output.toString(), "abc");
    }

}
