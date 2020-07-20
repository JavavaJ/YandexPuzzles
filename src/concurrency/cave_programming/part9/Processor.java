package concurrency.cave_programming.part9;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {

                while (list.size() == LIMIT) {
                    lock.wait();
                }

                list.add(value++);
                System.out.print("List size: " + list.size());
                System.out.println("; value: " + value);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {

        while (true) {
            synchronized (lock) {

                while (list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List size: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value: " + value);
                lock.notify();
            }
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
        }
    }

}
