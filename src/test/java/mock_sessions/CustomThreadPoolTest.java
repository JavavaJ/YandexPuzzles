package mock_sessions;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomThreadPoolTest {

    @Test
    public void test() {
        CustomThreadPool pool = new CustomThreadPool(4);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            pool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Working " + finalI + " ....");
            });
        }

    }

}