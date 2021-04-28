package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CountDigTest {

    @Test
    public void nbDig() {
        assertThat(CountDig.nbDig(25, 1)).isEqualTo(11);
        assertThat(CountDig.nbDig(10, 1)).isEqualTo(4);
        assertThat(CountDig.nbDig(5750, 0)).isEqualTo(4700);
    }

}