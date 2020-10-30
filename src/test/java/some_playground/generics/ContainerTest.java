package some_playground.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void testContainer() {
        Container<String> strContainer = new Container<>();
        strContainer.set("Shit");
        String s = strContainer.get();

        Container<Character> charContainer = new Container<>();
        charContainer.set('y');
        Character character = charContainer.get();

        Container<Integer> intContainer = new Container<>();
        intContainer.set(666);
        Integer integer = intContainer.get();

    }

}