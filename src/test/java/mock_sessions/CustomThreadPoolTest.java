package mock_sessions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class CustomThreadPoolTest {

    @Test
    public void test() {
        CustomThreadPool pool = new CustomThreadPool(4);

        ArrayList<AtomicBoolean> blablas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            AtomicBoolean boolBla = pool.bla(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Working " + finalI + " ....");
            });
            blablas.add(boolBla);

        }

        for (AtomicBoolean bool : blablas) {
            while(!bool.get()) {

            }
        }
        System.out.println("End of execution!");
    }

    @Test
    public void playground() {
        AtomicInteger atomicInteger = new AtomicInteger();
    }

}