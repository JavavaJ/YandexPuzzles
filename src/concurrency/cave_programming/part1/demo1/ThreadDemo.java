package concurrency.cave_programming.part1.demo1;

class Runner extends Thread {
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

public class ThreadDemo {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }

}
