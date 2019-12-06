package some_playground;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetPlayground {

    public static void main(String[] args) {

        int [] arr = new int[] {1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5};
        Integer[] integerArray = Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);  // convert ints to Integers
        HashSet<Integer> intSet = new HashSet<>();
        Collections.addAll(intSet, integerArray);
        System.out.println(intSet); // [1, 2, 3, 4, 5]

        Set<String> mySet = Stream.of("A", "B", "C", "D").collect(Collectors.toCollection(HashSet::new));
        System.out.println(mySet);


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
