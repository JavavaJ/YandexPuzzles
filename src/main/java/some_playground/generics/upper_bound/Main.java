package some_playground.generics.upper_bound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.setDuty(new Duty("fight"));
        List<Soldier> soldiers = Arrays.asList(soldier);
        triggerProfessionals(soldiers);
        upperBound(soldiers);

        Professional professional = new Professional();
        List<Professional> profs = Arrays.asList(professional);
        triggerProfessionals(profs);
        upperBound(profs);

        List<Integer> integers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        processNumbers(integers);
        processNumbers(objects);

        processNumbersRestrictive(integers);
//        processNumbersRestrictive(objects); // compile error
    }

    public static void processNumbers(List<? super Integer> superInts) {

    }

    public static void processNumbersRestrictive(List<Integer> ints) {

    }

    public static void triggerProfessionals(List<? super Soldier> soldiers) {

    }

    public static void upperBound(List<? extends Professional> list) {

    }
}
