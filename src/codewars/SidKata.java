package codewars;

import java.util.Arrays;
import java.util.List;

public class SidKata {

    public static String howMuchILoveYou(int nb_petals) {
        List<String> phrases = Arrays.asList("I love you",
                "a little",
                "a lot",
                "passionately",
                "madly",
                "not at all");
        int wordInd = (nb_petals - 1) % phrases.size();
        return phrases.get(wordInd);
    }

    public static void main(String[] args) {
        System.out.println(howMuchILoveYou(1));
        System.out.println(howMuchILoveYou(2));
        System.out.println(howMuchILoveYou(6));
        System.out.println(oneLiner(1));
        System.out.println(oneLiner(2));
        System.out.println(oneLiner(6));
    }

    public static String oneLiner(int nb_petals) {
        return Arrays.asList("I love you",
                "a little",
                "a lot",
                "passionately",
                "madly",
                "not at all")
                .get((nb_petals - 1) % 6);
    }

}
