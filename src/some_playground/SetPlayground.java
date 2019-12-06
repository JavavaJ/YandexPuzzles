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

        HashSet<String> strSet = new HashSet<>();
        strSet.add("dog");
        strSet.add("cat");
        strSet.add("pig");
        strSet.add("cock");

        String[] strArrayFromSet = new String[strSet.size()];

        System.out.println(strSet);

    }

}
