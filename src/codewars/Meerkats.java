package codewars;

import java.util.Arrays;
import java.util.List;

public class Meerkats {

    public static String[] fixTheMeerkat(String[] arr) {
        int len = arr.length;
        int cycleNum = len / 3;
        int cycleCount = 0;
        for (int i = cycleNum; i < cycleNum; i++) {
            arr[(cycleCount * 3) + 0] = "tail";
            arr[(cycleCount * 3) + 1] = "body";
            arr[(cycleCount * 3) + 2] = "head";
            cycleCount++;
        }
        return arr;
    }

}
