package codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SantaList {

    public static List<String> findChildren(List<String> santasList, List<String> children) {
        return children.stream()
                .filter(santasList::contains)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] children1 = {"Jason", "Jackson", "Jordan", "Johnny"};
        List<String> listChildren = Arrays.asList(children1);
        List<String> santasList = Arrays.asList("Jason", "Jordan");
        System.out.println(findChildren(santasList, listChildren));

        List<String> list3 = Arrays.asList("jASon", "JAsoN", "JaSON", "jasON");
        List<String> list4 = Arrays.asList("JasoN", "jASOn", "JAsoN", "jASon", "JASON");

        System.out.println(findChildren(list3, list4));

    }

}
