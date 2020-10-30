package mock_sessions;

import lombok.ToString;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PlaygroundArea {

    // todo homework - fix
//    @Test
//    public void testGenerics() {
//        Iterable<Map<String, String>> iterable =new ArrayList<Map<String, String>>();
//
//        Class<Iterable<Map<String, String>>> bla = (Class<Iterable<Map<String, String>>>) ((ParameterizedType) getClass()
//            .getGenericSuperclass()).getActualTypeArguments()[0];
//
//        System.out.println(bla);
//
//
//    }

    @Test
    public void yetAnotherTest() {

        // implement pool

        AtomicInteger counter = new AtomicInteger();

        int duration = 10;

        long before = System.currentTimeMillis();
        long stopTime = before + TimeUnit.SECONDS.toMillis(10);
        while(true) {
            prepareNewTread(counter).start();

            if (System.currentTimeMillis() >= stopTime) {
                break;
            }
        }

        System.out.println("Total Counter: " + counter);
    }

    private Thread prepareNewTread(AtomicInteger counter) {
        counter.incrementAndGet();
        return new Thread(() -> {
            System.out.println(counter);
        });
    }


    @Test
    public void startEmptyT() {
        Thread thread = new Thread();
        thread.start();
    }


}
