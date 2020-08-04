package codewars;

public class DivisibleByTwoNumbers {

    public static boolean isDivisible(long n, long x, long y) {
        return (n % x== 0 && n % y == 0);
    }

    public static void main(String[] args) {
        boolean divisible = isDivisible(3, 1, 3);
        System.out.println("1, true : " + divisible);

        boolean divisible2 = isDivisible(12, 2, 6);
        System.out.println("2, true : " + divisible2);

        boolean divisible3 = isDivisible(100, 5, 3);
        System.out.println("3, false : " + divisible3);

        boolean divisible4 = isDivisible(12, 7, 5);
        System.out.println("4, false : " + divisible4);
    }

}

