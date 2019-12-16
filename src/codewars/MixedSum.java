package codewars;

import java.util.List;

public class MixedSum {

    /*
     * Assume input will be only of Integer o String type
     */
    public int sum(List<?> mixed) {
        int sum = mixed.stream()
                .map(i -> {
                    Integer currInt = null;
                    if (i instanceof String) {
                        currInt = Integer.parseInt((String) i);
                    } else if (i instanceof Integer) {
                        currInt = (Integer) i;
                    }
                    return currInt;
                })
                .mapToInt(Integer::intValue)
                .sum();
        ;
        return sum;
    }



}
