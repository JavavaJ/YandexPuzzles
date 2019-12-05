package codewars;

public class AlphabeticalAddition {

    public static String addLetters(String... letters) {


        for (String s : letters) {
            char curChar = s.charAt(0);
        }

        return "";

    }

    public static void main(String[] args) {
        System.out.println(getLetterIndex('a'));
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('b'));
        int num = 10;
        char myChar = (char) num;
        System.out.println(myChar);

        char aChar = 'a';
        int aInt = aChar;
        System.out.println(aInt);

        int i1 = 97;
        char ch = (char) i1;
        System.out.println(ch);

    }

    private static int getLetterIndex(char c) {
        return c - 'a' + 1;
    }

}
