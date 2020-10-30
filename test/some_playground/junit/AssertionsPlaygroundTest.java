package some_playground.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Some assertions")
class AssertionsPlaygroundTest {

    @Test
    @DisplayName("Compare arrays")
    public void testArrays() {
        char[] expected = {'h', 'o', 'm', 'e'};
        char[] actual = "home".toCharArray();
        assertArrayEquals(expected, actual);

        assertNull(null);
        assertNotNull(new Object());

        String lang1 = "Java";
        String lang2 = "Java";
        assertSame(lang1, lang2);

        String lang3 = new String("Java");
        String lang4 = new String("Java");
        assertNotSame(lang4, lang3);

    }
    @Test
    @DisplayName("Compare iterables")
    public void testIterables() {
        ArrayList<String> list1 =
            new ArrayList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> list2 =
            new LinkedList<>(Arrays.asList("A", "B", "C"));
        assertIterableEquals(list1, list2);
    }

}