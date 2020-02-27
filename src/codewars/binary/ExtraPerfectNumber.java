package codewars.binary;

import java.util.stream.IntStream;

public class ExtraPerfectNumber {

    public static int[] extraPerfect(int number) {
        return IntStream.rangeClosed(1, number)
            .filter(ExtraPerfectNumber::isPerfectNumber)
            .toArray();
    }

    public static boolean isPerfectNumber(int num) {
        String binary = Integer.toBinaryString(num);
        return (binary.charAt(0) == '1')
            && (binary.charAt(binary.length() -1) == '1');
    }

}
