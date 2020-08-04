package some_playground;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapHypothesisTest {

    public static void main(String[] args) {
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> emptyMap = new HashMap<>();
        map.put(10L, 100L);
        map.put(20L, 200L);
        map.put(30L, 300L);
        map.put(40L, 400L);
        map.put(50L, 500L);

        Set<Map.Entry<Long, Long>> entries = emptyMap.entrySet();
        System.out.println(entries);
    }

}
