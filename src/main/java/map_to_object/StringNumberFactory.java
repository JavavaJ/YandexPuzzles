package map_to_object;

import java.util.HashMap;
import java.util.Map;

public class StringNumberFactory {

    static Map<Integer, String> numsMap = new HashMap<>();

    static {
        numsMap.put(0, "zero");
        numsMap.put(1, "one");
        numsMap.put(2, "two");
        numsMap.put(3, "three");
        numsMap.put(4, "four");
        numsMap.put(5, "five");
        numsMap.put(6, "six");
        numsMap.put(7, "seven");
        numsMap.put(8, "eight");
        numsMap.put(9, "nine");
    }


    public static String get(Integer i) {
        return numsMap.get(i);
    }

}
