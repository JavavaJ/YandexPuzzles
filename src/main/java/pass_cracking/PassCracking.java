package pass_cracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PassCracking {

    private Set<String> noMatchChars;
    private Set<String> matchChars;

    private HashMap<Character, Boolean> letters;

    public PassCracking() {
        initSets();
    }

    private void initSets() {
        String attempt1 = "periods"; // 0 matches
        String attempt2 = "farmers"; // 0 matches
        String attempt3 = "filters"; // 2 matches

        letters = new HashMap<>();

        noMatchChars = new HashSet<>();
        matchChars = new HashSet<>();

        for (int i = 0; i < attempt1.length(); i++) {
            letters.put(attempt1.charAt(i), false);
            noMatchChars.add(Character.toString(attempt1.charAt(i)));
        }

        for (int i = 0; i < attempt2.length(); i++) {
            letters.put(attempt2.charAt(i), false);
            noMatchChars.add(Character.toString(attempt2.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < attempt3.length(); i++) {
            String currChar = Character.toString(attempt3.charAt(i));
            if (!noMatchChars.contains(currChar)) {
                letters.put(attempt3.charAt(i), true);
                matchChars.add(currChar);
            }
        }

//        System.out.println("Mathing chars: ");
//        for (String matchChar : matchChars) {
//            System.out.println(matchChar);
//        }
//
//        System.out.println("Non-matching chars: ");
//        for (String noMatchChar : noMatchChars) {
//            System.out.println(noMatchChar);
//        }
    }

    public Set<String> getNoMatchChars() {
        return noMatchChars;
    }

    public Set<String> getMatchChars() {
        return matchChars;
    }

    public HashMap<Character, Boolean> getLetters() {
        return letters;
    }

    public void analyze(String pass) {
        int noMatchCount = 0;
        for (int i = 0; i < pass.length(); i++) {
            String currChar = Character.toString(pass.charAt(i));
            if (noMatchChars.contains(currChar)) {
                noMatchCount++;
            }
        }
        System.out.println("Pass \"" + pass + "\" contains " + noMatchCount + " prohibitive letters.");
    }
}
