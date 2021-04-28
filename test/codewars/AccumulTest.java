package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class AccumulTest {

    @Test
    public void repeat() {
        String result = Accumul.repeat("Abc", 3);
        assertThat(result).isEqualTo("AbcAbcAbc");
    }

    @Test
    public void accum() {
        assertThat(Accumul.accum("abcd")).isEqualTo("A-Bb-Ccc-Dddd");
        assertThat(Accumul.accum("cwAt")).isEqualTo("C-Ww-Aaa-Tttt");
        assertThat(Accumul.accum("")).isEqualTo("");
    }

}