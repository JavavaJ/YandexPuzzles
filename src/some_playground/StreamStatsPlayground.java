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



    }

}
