package codewars;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WhichAreInTest {

    @Test
    public void inArray() {
        String[] arr1 = {"arp", "live", "strong", "abc"};
        String[] arr2 = {"lively", "alive", "harp", "sharp", "armstrong"};

        String[] expected = {"arp", "live", "strong"};


        String[] matched = WhichAreIn.inArray(arr1, arr2);
        System.out.println(Arrays.toString(matched));

        assertArrayEquals(expected, matched);

    }

}