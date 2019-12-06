package some_playground;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SetPlayground {

    public static void main(String[] args) {
        int [] arr = new int[] {1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5};
        List<Integer> arrIntegers = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        HashSet<Integer> integerSet = new HashSet<>(arrIntegers);
    }

}
