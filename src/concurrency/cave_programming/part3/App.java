package concurrency.cave_programming.part3;

public class App {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public void doWork() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
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
