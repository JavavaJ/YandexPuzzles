package some_playground.map_java8;

import java.util.HashMap;
import java.util.Map;

public class NewMethods {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");

        // will not populate value since key is present
        map.computeIfAbsent(1, k -> "also one");

        // will populate value since key is absent
        map.computeIfAbsent(3, k -> "three");

        // {1=one, 2=two, 3=three}
        System.out.println(map);

    }
}
