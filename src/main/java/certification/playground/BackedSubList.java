package certification.playground;

import java.util.ArrayList;
import java.util.List;

public class BackedSubList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.addAll(list.subList(0, 4));
        System.out.println(list);

        List<String> sublist = list.subList(0, 4);

        System.out.println(sublist);
        sublist.remove(0);

        System.out.println("After: ");
        System.out.println(list);
        System.out.println(sublist);

    }

}
