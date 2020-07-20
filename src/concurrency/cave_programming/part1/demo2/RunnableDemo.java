package concurrency.cave_programming.part1.demo2;

class RunnerFromI implements Runnable {

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
}

public class RunnableDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnerFromI());
        Thread thread2 = new Thread(new RunnerFromI());

        thread1.start();
        thread2.start();
    }

}
