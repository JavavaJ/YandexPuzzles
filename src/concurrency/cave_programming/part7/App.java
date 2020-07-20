package concurrency.cave_programming.part7;

import java.io.File;
import java.io.FileFilter;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class App {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        // number of available processors to the JVM
        int availableProcessors = Runtime.getRuntime()
            .availableProcessors();

        System.out.println("availableProcessors: " + availableProcessors);

        Thread thread1 = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(30);

            if (random.nextInt(10) == 0) {
                queue.put(random.nextInt(100));
            }

        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(100);

            if (random.nextInt(10) == 0) {
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }

}
