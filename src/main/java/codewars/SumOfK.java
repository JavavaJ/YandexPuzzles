package codewars;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

    https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa/train/java

    John and Mary want to travel between a few towns A, B, C ... Mary has on a sheet of paper a list of distances
    between these towns. ls = [50, 55, 57, 58, 60]. John is tired of driving and he says to Mary that he doesn't want
    to drive more than t = 174 miles and he will visit only 3 towns.

    Which distances, hence which towns, they will choose so that the sum of the distances is the biggest possible to please
    Mary and John?

    Example:
    With list ls and 3 towns to visit they can make a choice between: [50,55,57],[50,55,58],[50,55,60],[50,57,58],[50,57,60],
    [50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].

    The sums of distances are then: 162, 163, 165, 165, 167, 168, 170, 172, 173, 175.

    The biggest possible sum taking a limit of 174 into account is then 173 and
    the distances of the 3 corresponding towns is [55, 58, 60].

    The function chooseBestSum (or choose_best_sum or ... depending on the language)
    will take as parameters
    t (maximum sum of distances, integer >= 0),
    k (number of towns to visit, k >= 1) and
    ls (list of distances, all distances are positive or null integers and
    this list has at least one element).

    The function returns the "best" sum ie the biggest possible sum of k distances less than or equal to the given limit t,
    if that sum exists, or otherwise nil, null, None, Nothing, depending on the language.

 */
public class SumOfK {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        if (ls.size() < k) {
            return null;
        }
        int maximum = 0;
        Set<Set<Integer>> combinations = getCombinations(k, ls);

        for (Set<Integer> combination : combinations) {
            int sum = 0;
            for (Integer index : combination) {
                sum += ls.get(index);
            }
            if ((sum > maximum) && (sum <= t)) {
                maximum = sum;
            }
        }


        return maximum == 0 ? null : maximum;
    }

    private static Set<Set<Integer>> getCombinations(int k, List<Integer> ls) {
        Set<Integer> indices = IntStream.range(0, ls.size())
            .boxed()
            .collect(Collectors.toSet());

        return Sets.combinations(indices, k);
    }
}
