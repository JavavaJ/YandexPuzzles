package codewars;

import com.google.common.collect.EvictingQueue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class SpiralizorTest {

    @Test
    void spiralize() {
        int[][] cells = Spiralizor.spiralize(10);
        for (int[] arr : cells) {
            System.out.println(Arrays.toString(arr));
        }
    }

}