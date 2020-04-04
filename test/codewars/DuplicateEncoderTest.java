package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateEncoderTest {

    @Test
    void encode() {
        assertEquals(")())())", DuplicateEncoder.encode("Success"));
        assertEquals(")()())()(()()(",
            DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));

        assertEquals("()()()", DuplicateEncoder.encode("recede"));
        assertEquals("(((", DuplicateEncoder.encode("din"));
        assertEquals("))((", DuplicateEncoder.encode("(( @"));
    }
}