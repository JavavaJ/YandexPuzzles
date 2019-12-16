package some_playground;

import java.util.ArrayList;
import java.util.List;

public class Class2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("do");
        list.add("did");

        String[] arr;

        arr = (String[]) list.toArray();

    }

}
