package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class MaxDiffLengthTest {

    @Test
    public void mxdiflg() {
        String[] a1 = {"home", "cat", "house"};
        String[] a2 = {"bread", "shit", "cybersquatting"};

        assertThat(MaxDiffLength.mxdiflg(a1, a2)).isEqualTo(11);

        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        assertThat(MaxDiffLength.mxdiflg(s1, s2)).isEqualTo(13);

        String[] emtpy1 = new String[]{};
        String[] emtpy2 = new String[]{};

        assertThat(MaxDiffLength.mxdiflg(emtpy1, emtpy2)).isEqualTo(-1);
        assertThat(MaxDiffLength.mxdiflg(a1, emtpy2)).isEqualTo(-1);
        assertThat(MaxDiffLength.mxdiflg(emtpy1, a2)).isEqualTo(-1);

    }

    public void play() {

        String[] words = {"home", "cat", "house"};

        Optional<String> shortestWord = Arrays.stream(words)
            .min(Comparator.comparing(String::length));

        Optional<String> longestWord = Arrays.stream(words)
            .max(Comparator.comparing(String::length));
    }

}