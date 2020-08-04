package some_playground.generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Building> buildings = Arrays.asList(new Building(), new Building(), new Building());
        paintAllBuildings(buildings);


        List<House> houses = Arrays.asList(new House(), new House(), new House());
        paintAllBuildings(houses);

        List<Integer> list = Arrays.asList(new Integer(7));
        addNumbers(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static void paintAllBuildings(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

//    public static void paintParentsOfHouse(List<? super T> buildings) {
////        buildings.forEach(Building::paint);
//    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
    }

}
