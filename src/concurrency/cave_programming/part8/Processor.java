package concurrency.cave_programming.part8;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running ...");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
        }
    }


}
