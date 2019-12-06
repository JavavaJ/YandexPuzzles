package some_playground;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetPlayground {

    public static void main(String[] args) {

        int [] arr = new int[] {1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5};
        Set<Integer> intSet = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(intSet); // [1, 2, 3, 4, 5]

        HashSet<String> set = new HashSet<>();
        set.add("dog");
        set.add("cat");
        set.add("pig");
        set.add("cock");

        String[] strArrayFromSet = new String[set.size()];
        strArrayFromSet = set.toArray(strArrayFromSet);
        System.out.println("Array: " + Arrays.toString( strArrayFromSet));

    }

}
