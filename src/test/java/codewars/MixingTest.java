package codewars;

import com.google.common.collect.ArrayListMultimap;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class MixingTest {

    @Test
    void case1() {
        String s1 = "A aaaa bb c";
        String s2 = "& aaa bbb c d";
        String expected = "1:aaaa/2:bbb";

        run(s1, s2, expected);
    }

    @Test
    void case2() {
        String s1 = "Are they here";
        String s2 = "yes, they are here";
        String expected = "2:eeeee/2:yy/=:hh/=:rr";

        run(s1, s2, expected);
    }

    @Test
    void case3() {
        String s1 = "looping is fun but dangerous";
        String s2 = "less dangerous than coding";
        String expected = "1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg";

        run(s1, s2, expected);
    }

    @Test
    void case4() {
        String s1 = " In many languages";
        String s2 = " there's a pair of functions";
        String expected = "1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt";

        run(s1, s2, expected);
    }

    @Test
    void case5() {
        String s1 = "A generation must confront the looming ";
        String s2 = "codewarrs";
        String expected = "1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr";

        run(s1, s2, expected);
    }

    @Test
    void case6() {
        String s1 = "codewars";
        String s2 = "codewars";
        String expected = "";

        run(s1, s2, expected);
    }

    @Test
    void case7() {
        String s1 = "Lords of the Fallen";
        String s2 = "gamekult";
        String expected = "1:ee/1:ll/1:oo";

        run(s1, s2, expected);
    }



    @Test
    public void repeat() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Mixing.class.getDeclaredMethod("repeat", Character.class, int.class);
        method.setAccessible(true);

        String dd = (String) method.invoke(new Mixing(), 'd', 2);

//        String dd = Mixing.repeat('d', 2);
        assertThat(dd).isEqualTo("dd");
    }

    private void run(String s1, String s2, String expected) {
        String output = Mixing.mix(s1, s2);
        assertThat(output).isEqualTo(expected);
    }

    @Test
    public void multiMapPlayground() {

        ArrayListMultimap<Integer, String> multimap = ArrayListMultimap.create();
        multimap.put(7, "seven");
        multimap.put(7, "семь");
        multimap.put(3, "three");

        List<String> strings = multimap.get(7); // [seven, семь]
        System.out.println(strings);

        List<String> strings1 = multimap.get(3); // [three]
        System.out.println(strings1);

    }



}