package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BonusesTest {

    @Test
    void calcNumerator() {
        int[] days = {15, 18, 12};
        long s = 851;

        long numerator = Bonuses.calcNumerator(days, s);
        assertThat(numerator).isEqualTo(183816);

    }

    @Test
    void calcDenominator() {
        int[] days = {18, 15, 12};
        long s = 851;

        long denominator = Bonuses.calcDenominator(days, s);
        assertThat(denominator).isEqualTo(666);
    }

    @Test
    public void bonusesFirstCase() {
        int[] days = {18, 15, 12};
        long s = 851;

        long[] bonus = Bonuses.bonus(days, s);
        long[] expected = {230L, 276L, 345L};


        assertThat(days.length).isEqualTo(bonus.length);
        assertThat(bonus.length).isEqualTo(expected.length);

        for (int i = 0; i < expected.length; i++) {
            assertThat(bonus[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    public void bonusesSecondCase() {
        int[] days = {30, 27, 8, 14, 7};
        long s = 34067;

        long[] bonus = Bonuses.bonus(days, s);
        long[] expected = {2772L, 3080L, 10395L, 5940L, 11880L};

        assertThat(days.length).isEqualTo(bonus.length);
        assertThat(bonus.length).isEqualTo(expected.length);

        for (int i = 0; i < expected.length; i++) {
            assertThat(bonus[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    public void divideByZeroCheck() {
        int[] days = {};
        long s = 851;

        long[] bonus = Bonuses.bonus(days, s);

    }

}