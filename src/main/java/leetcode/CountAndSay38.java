package leetcode;

public class CountAndSay38 {

    public String countAndSay(int n) {
        String output = "1";

        for (int i = 1; i < n; i++) {
            output = say(output);
        }
        return output;
    }

    public String say(String n) {
        String output = "";
        // iterate string
        char prevChar = 0;
        int duplicateCount = 1;
        for (int i = 0; i < n.length(); i++) {
            char currChar = n.charAt(i);
            if (n.length() == 1) {
                return "1" + n;
            }
            if (i == 0) {
                prevChar = currChar;
                continue;
            }
            // condition if currentChar equals prevChar
            if (prevChar == currChar) {
                duplicateCount++;
                prevChar = currChar;
            } else {
                output += Integer.toString(duplicateCount) + Character.toString(prevChar);
                prevChar = currChar;
                duplicateCount = 1;
            }
            if (i == n.length() - 1) {
                output += Integer.toString(duplicateCount) + Character.toString(prevChar);
            }
        }

        return output;
    }

}
