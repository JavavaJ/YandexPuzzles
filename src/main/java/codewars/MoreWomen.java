package codewars;

public class MoreWomen {

    public static boolean inviteMoreWomen(int[] l) {

        int maleCount = 0;
        int femaleCount = 0;
        for (int curVal : l) {
            if (curVal > 0) {
                maleCount++;
            } else {
                femaleCount++;
            }
        }

        return  maleCount > femaleCount;
    }


}
