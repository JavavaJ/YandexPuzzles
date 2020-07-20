package concurrency.cave_programming.part2.cache_demo;

import java.util.Scanner;

class Processor extends Thread {

    // This value might be cached and never accessed on some systems. That's why volatile.
    private volatile boolean running = true;

    @Override
    public void run() {
        int interval = 300;
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App1 {

    public static void main(String[] args) {
        Processor processor1 = new Processor();
        processor1.start();

        System.out.println("Press return to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        processor1.shutdown();
    }

}
