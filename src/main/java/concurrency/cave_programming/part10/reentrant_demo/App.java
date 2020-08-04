package concurrency.cave_programming.part10.reentrant_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public final static int THREAD_NUM = 2;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);

        for (int i = 0; i < 4; i++) {
            String name = "Job" + i;
            Worker worker = new Worker(lock, name);
            pool.execute(worker);
        }

        pool.shutdown();
    }

}
