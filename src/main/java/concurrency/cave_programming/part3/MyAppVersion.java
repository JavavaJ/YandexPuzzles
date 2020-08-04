package concurrency.cave_programming.part3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAppVersion {

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        MyAppVersion app = new MyAppVersion();
        app.doWork();
    }

    public void doWork() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.incrementAndGet();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.incrementAndGet();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is " + count);

    }

}
