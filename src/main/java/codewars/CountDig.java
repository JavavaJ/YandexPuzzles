package codewars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Take an integer n (n >= 0) and a digit d (0 <= d <= 9) as an integer.
// Square all numbers k (0 <= k <= n) between 0 and n.
// Count the numbers of digits d used in the writing of all the k**2.
// Call nb_dig (or nbDig or ...) the function taking n and d as parameters and returning this count.

public class CountDig {

    public static int nbDig(int num, int digit) {

        String allSquared = IntStream.rangeClosed(0, num)
            .map(number -> number * number)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(" "));

        char charDigit = Integer.toString(digit).charAt(0);

        return (int) allSquared.chars().filter(ch -> ch == charDigit).count();
    }
}
