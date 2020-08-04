package some_playground;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class StreamStatsPlayground {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1, 2, 3);
        IntSummaryStatistics statistics = intStream.summaryStatistics();
        double average = statistics.getAverage();
        long count = statistics.getCount();
        int max = statistics.getMax();
        int min = statistics.getMin();
        long sum = statistics.getSum();

        boolean contains11 = IntStream.range(1, 70)
                .anyMatch(i -> i % 11 == 0);
        System.out.println(contains11);

        int maxInt = IntStream.range(2, 49)
                .max()
                .getAsInt();
        System.out.println(maxInt);
        int sumOfRange = IntStream.rangeClosed(1, 6).reduce(0, (x, y) -> x + y);
        System.out.println("sum: " + sumOfRange);



    }

}
