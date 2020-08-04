package concurrency.cave_programming.part10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        synchronized (this) {
            increment();
        }
    }

    public void secondThread() throws InterruptedException {
        synchronized (this) {
            increment();
        }
    }

    public void finished() {
        System.out.println("Count: " + count);
    }

}
