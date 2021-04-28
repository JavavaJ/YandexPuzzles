package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class CountAndSay38Test {

    @Test
    public void say() {
        CountAndSay38 obj = new CountAndSay38();

        assertThat(obj.say("123")).isEqualTo("111213");
        assertThat(obj.say("177")).isEqualTo("1127");
        assertThat(obj.say("1")).isEqualTo("11");
        assertThat(obj.say("11")).isEqualTo("21");
        assertThat(obj.say("21")).isEqualTo("1211");
        assertThat(obj.say("3322251")).isEqualTo("23321511");
    }

    @Test
    public void countAndSay() {
        CountAndSay38 obj = new CountAndSay38();

        assertThat(obj.countAndSay(4)).isEqualTo("1211");
        assertThat(obj.countAndSay(5)).isEqualTo("111221");
        assertThat(obj.countAndSay(6)).isEqualTo("312211");
        assertThat(obj.countAndSay(7)).isEqualTo("13112221");
        assertThat(obj.countAndSay(8)).isEqualTo("1113213211");
        assertThat(obj.countAndSay(9)).isEqualTo("31131211131221");
        assertThat(obj.countAndSay(10)).isEqualTo("13211311123113112211");
    }
}