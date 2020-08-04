package concurrency.cave_programming.part1.demo3;

public class AnonDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int times = 10;
                int millis = 1000;
                for (int i = 0; i < times; i++) {
                    System.out.println("Hello " + i);
                    try {
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
    }

}
