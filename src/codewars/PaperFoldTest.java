package codewars;

public class PaperFoldTest {

    public static void main(String[] args) {
        PaperFold paperFold = new PaperFold();
        for (int i = 0; i < 20; i++) {
            System.out.print(paperFold.getAsInt() + " ");
        }
    }

}
