package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsogramTest {

    @Test
    void isIsogram() {
        assertEquals(Isogram.isIsogram("Dermatoglyphics"), true);
    }
}