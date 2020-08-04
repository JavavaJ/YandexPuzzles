package leetcode;

public class NumberOfTeams {

    public int numTeams(int[] rating) {
        int count = 0;
        if (rating.length < 3) {
            return 0;
        }
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (isValidOrder(rating[i], rating[j], rating[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean isValidOrder(int num1, int num2, int num3) {
        if (num1 > num2 && num2 > num3) {
            return true;
        }
        if (num1 < num2 && num2 < num3) {
            return true;
        }
        return false;
    }

}
