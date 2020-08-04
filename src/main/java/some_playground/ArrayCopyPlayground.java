package some_playground;

import java.util.Arrays;

public class ArrayCopyPlayground {

    public static void main(String[] args) {

        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[3];

        System.arraycopy(arr1, 0, arr2, 0, 3);
        printIntsArray(arr2); // 123

        MockBook[] books1 = initMockBooks();

        for (int i = 0; i < books1.length; i++) {
            doNothing();
        }

        MockBook[] books2 = new MockBook[3];
        System.arraycopy(books1, 0, books2, 0, 3);



        System.out.println("\nBefore transformations: ");
        printMockBooksArray(books1);
        System.out.println();
        System.out.println("books2: " + Arrays.toString(books2));

        MockBook pythonMockBook = getPythonMockBook();

        books1[1] = pythonMockBook;


        System.out.println("After transformations: ");
        System.out.println("books1: " + Arrays.toString(books1));
        System.out.println();
        System.out.println("books2: " + Arrays.toString(books2));

    }

    private static MockBook getPythonMockBook() {
        return new MockBook("Python", "Italian Guy");
    }

    private static void printMockBooksArray(MockBook[] books1) {
        Arrays.stream(books1).forEach(System.out::print);
    }

    private static void printIntsArray(int[] arr2) {
        Arrays.stream(arr2).forEach(System.out::print);
    }

    private static MockBook[] initMockBooks() {
        return new MockBook[] {new MockBook("Bible", "Jesus"),
                                                new MockBook("Peace", "Tolstoy"),
                                                new MockBook("Java", "Horstmann")};
    }

    private static void doNothing() {
        // do nothing
    }

}
