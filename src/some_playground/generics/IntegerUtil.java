package some_playground.generics;

public class IntegerUtil {

    public static <T> Integer print(T[] numbers) {
        for (T elem : numbers) {
            System.out.print(elem + " ");
        }
        return numbers.length;
    }

    public static <N extends Number> Integer printNumbers(N[] numbers) {
        for (N num : numbers) {
            System.out.print(num + " ");
        }
        return numbers.length;
    }

    public static void main(String[] args) {
        Integer [] nums = {1, 2, 3, 4};
        System.out.print("Print : ");
        Integer returnValue = print(nums);
        System.out.print("Return : " + returnValue);
        System.out.println(" return type: " + returnValue.getClass());

        String [] strNums = {"1", "2", "7", "99"};
        System.out.print("Print : ");
        Integer printStr = print(strNums);

        printNumbers(nums);
//        printNumbers(strNums); // doesn't compile

    }

}
