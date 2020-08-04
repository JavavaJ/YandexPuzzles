package codewars.paperfold_misunderstood;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PaperFoldTest {

    public static void main(String[] args) {
        PaperFold paperFold = new PaperFold();
        for (int i = 0; i < 2000; i++) {
            System.out.print(paperFold.getAsInt() + " ");
        }
    }

    public static void testPrivateChangePaddingNumMethod() {
        PaperFold paperFold = new PaperFold();

        // some reflection to get to private method
        Method changePaddingNumMethod = null;
        try {
            changePaddingNumMethod = PaperFold.class.getDeclaredMethod("changePaddingNum");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        changePaddingNumMethod.setAccessible(true);

        for (int i = 0; i < 10; i++) {
            try {
                changePaddingNumMethod.invoke(paperFold);
                System.out.println(paperFold.getPaddingNum());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
