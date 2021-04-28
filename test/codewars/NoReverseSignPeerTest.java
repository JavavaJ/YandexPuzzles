package codewars;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class NoReverseSignPeerTest {

    @Test
    public void solve() {
        int[] ints1 = {1, -1, 2, -2, 3};
        assertThat(NoReverseSignPeer.solve(ints1)).isEqualTo(3);

        int[] ints2 = {-3, 1, 2, 3, -1, -4, -2};
        assertThat(NoReverseSignPeer.solve(ints2)).isEqualTo(-4);

        int[] ints3 = {-3, 1, 2, 3, -1, -4, -2, -4};
        assertThat(NoReverseSignPeer.solve(ints3)).isEqualTo(-4);

        int[] emptyArr = {};
        assertThat(NoReverseSignPeer.solve(emptyArr)).isEqualTo(0);

    }

    @Test
    public void test() {
        Stream<String> words = Stream.of("house", "cat", "ant");
        Optional<String> firstWord = words.collect(Collectors.maxBy(String::compareTo));
        // is the same as = words.max(String::compareTo);
        System.out.println(firstWord.get()); // house - the longest word

    }

}