package some_playground;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStringGenerator {

    public static void main(String[] args) {
        System.out.println(getRandomString(7));
        System.out.println(randStringStreamWay(11));
    }

    public static String getRandomString(int len) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randomStr = "";
        for (int i = 0; i < len; i++) {
            int rand = (int) (Math.random() * ALPHABET.length());
            randomStr += ALPHABET.charAt(rand);
        }
        return randomStr;
    }

    public static String randStringStreamWay(int len) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int alphLength = ALPHABET.length();
        return IntStream.range(0, len)
                .map(x -> (int) (Math.random() * alphLength))
                .mapToObj(ALPHABET::charAt)
                .map(x -> x.toString())
                .collect(Collectors.joining(""));
    }

}
