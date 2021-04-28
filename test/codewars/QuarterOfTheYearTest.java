package codewars;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class QuarterOfTheYearTest {

    @Test
    public void testClass() {
        assertThat(QuarterOfTheYear.quarterOf(1)).isEqualTo(1);
        assertThat(QuarterOfTheYear.quarterOf(2)).isEqualTo(1);
        assertThat(QuarterOfTheYear.quarterOf(3)).isEqualTo(1);
        assertThat(QuarterOfTheYear.quarterOf(4)).isEqualTo(2);
        assertThat(QuarterOfTheYear.quarterOf(5)).isEqualTo(2);
        assertThat(QuarterOfTheYear.quarterOf(6)).isEqualTo(2);
        assertThat(QuarterOfTheYear.quarterOf(7)).isEqualTo(3);
        assertThat(QuarterOfTheYear.quarterOf(8)).isEqualTo(3);
        assertThat(QuarterOfTheYear.quarterOf(9)).isEqualTo(3);
        assertThat(QuarterOfTheYear.quarterOf(10)).isEqualTo(4);
        assertThat(QuarterOfTheYear.quarterOf(11)).isEqualTo(4);
        assertThat(QuarterOfTheYear.quarterOf(12)).isEqualTo(4);
    }
}
