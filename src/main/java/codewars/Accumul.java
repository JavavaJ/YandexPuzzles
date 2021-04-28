package codewars;

public class Accumul {

    public static String accum(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String letter = Character.toString(s.charAt(i));
            String fragment = letter.toUpperCase() + repeat(letter.toLowerCase(), i);
            result += fragment;
            if (i != s.length() - 1) {
                result += "-";
            }
        }
        return result;
    }

    public static String repeat(String str, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}
