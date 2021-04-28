package codewars;

/*
John wants to give a total bonus of $851 to his three employees taking fairly as possible into account their number of days of absence during the period under consideration. Employee A was absent 18 days, B 15 days, and C 12 days.

The more absences, the lower the bonus ...

How much should each employee receive? John thinks A should receive $230, B $276, C $345 since 230 * 18 = 276 * 15 = 345 * 12 and 230 + 276 + 345 = 851.

Task:
Given an array arr (numbers of days of absence for each employee) and a number s (total bonus) the function bonus(arr, s) will follow John's way and return an array of the fair bonuses of all employees in the same order as their numbers of days of absences.

s and all elements of arr are positive integers.

Examples:
bonus([18, 15, 12], 851) -> [230, 276, 345]

bonus([30, 27, 8, 14, 7], 34067) -> [2772, 3080, 10395, 5940, 11880]
 */


public class Bonuses {

    public static long[] bonus(int[] arr, long s) {

        if (arr.length == 0) {
            return new long[]{s};
        }

        long numerator = calcNumerator(arr, s);
        long denominator = calcDenominator(arr, s);
        long firstValue = numerator / denominator;

        long[] bonuses = new long[arr.length];
        bonuses[0] = firstValue;


        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            }
            int elem = arr[i];
            long val = (firstValue * arr[0]) / (long) elem;
            bonuses[i] = val;
        }

        return bonuses;
    }

    public static long calcNumerator(int[] arr, long s) {
        long numerator = s;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            }
            long elem = (long) arr[i];
            numerator = numerator * elem;
        }
        return numerator;
    }

    public static long calcDenominator(int[] arr, long s) {
        long denominator = 0;

        for (int i = 0; i < arr.length; i++) {
            denominator = denominator + calcProduct(arr, i);
        }
        return denominator;
    }

    public static long calcProduct(int[] arr, int exceptIndex) {
        if (arr.length == 1) {
            return arr[0];
        }
        long product = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == exceptIndex) {
                continue;
            }
            long elem = (long) arr[i];
            product = product * elem;
        }
        return product;
    }


}
