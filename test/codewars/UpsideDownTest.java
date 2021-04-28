package codewars;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class UpsideDownTest {

    UpsideDown obj;

    @BeforeEach
    void init() {
        obj = new UpsideDown();
    }

    @Test
    void hasOnlyRotatable() {
        assertThat(obj.hasOnlyRotatable("180")).isTrue();
        assertThat(obj.hasOnlyRotatable("810")).isTrue();
        assertThat(obj.hasOnlyRotatable("811")).isTrue();
        assertThat(obj.hasOnlyRotatable("12345")).isFalse();
    }

    @Test
    void solve() {
        assertThat(obj.solve(0, 10)).isEqualTo(3);
        assertThat(obj.solve(10, 100)).isEqualTo(4);
        assertThat(obj.solve(100, 1000)).isEqualTo(12);
        assertThat(obj.solve(0, 10)).isEqualTo(3);
    }

    @Test
    void isSameAfterRotation() {
        assertThat(obj.isSameAfterRotation("111")).isTrue();
        assertThat(obj.isSameAfterRotation("199")).isFalse();
        assertThat(obj.isSameAfterRotation("9116")).isTrue();
        assertThat(obj.isSameAfterRotation("6969")).isTrue();
    }
}