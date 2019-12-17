package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleIntegerStringSort {

    public static Object[] dbSort(Object[] a) {

        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        Arrays.stream(a)
                .forEach(i -> {
                    if (i instanceof String) {
                        strings.add((String) i);
                    }
                    if (i instanceof Integer) {
                        integers.add((Integer) i);
                    }
                });

        List<Integer> sortedIntegers = integers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<String> sortedStrings = strings.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Object> sortedIntegersObj = new ArrayList<>();
        List<Object> sortedStringsObj = new ArrayList<>();

        for (Integer integer : sortedIntegers) {
            sortedIntegersObj.add(integer);
        }

        for (String str : sortedStrings) {
            sortedStringsObj.add(str);
        }

        List<Object> objectList = Stream.concat(sortedIntegersObj.stream(),
                sortedStringsObj.stream())
                .collect(Collectors.toList());

        Object[] objects = objectList.toArray(new Object[objectList.size()]);

        return objects;
    }

    public static void main(String[] args) {
        Object[] objArr1 = {"Banana", "Orange", "Apple", "Mango", 0, 2, 2};
        Object[] objArr2 = {"C", "W", "W", "W", 1, 2, 0};

        String strArr1 = Arrays.toString(dbSort(objArr1));
        String strArr2 = Arrays.toString(dbSort(objArr2));

        System.out.println(strArr1);
        System.out.println(strArr2);

        List<Object> objects = Stream.of("cat", "dog", "duck", "bird")
                .map(Object.class::cast)
                .collect(Collectors.toList());

        Object obj = Object.class.cast("String as object");

    }

}
