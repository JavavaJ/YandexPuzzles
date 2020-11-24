package mock_sessions;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPool implements ExecutorService {

    private int maxThreads;
    private final List<Worker> threads = new ArrayList<>();
    private volatile LinkedBlockingQueue<Trash> tasks = new LinkedBlockingQueue<>();
    private volatile boolean isRunning = false;


    public CustomThreadPool(int maxThreads) {
        this.maxThreads = maxThreads;
        init();
    }

    public void init() {
        isRunning = true;

        for (int i = 0; i < maxThreads; i++) {
            Worker worker = new Worker();
            threads.add(worker);
            worker.start();
        }
    }

    @Override
    public Future<?> submit(Runnable task) {
//        tasks.add(task);

        return null;
    }

    public AtomicBoolean bla(Runnable task) {
        AtomicBoolean thisBool = new AtomicBoolean();
        tasks.add(new Trash(new AtomicBoolean(), task));
        return thisBool;
    }

    @Override
    public void shutdown() {
        isRunning = false;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }


    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return !isRunning;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }





    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }

    private class Worker extends Thread {

        @Override
        public void run() {

            while (isRunning) {
                Trash trash = tasks.poll();
                if (trash != null) {
                    trash.getRunnable().run();
                    trash.getBool().set(true);
                }
            }
        }
    }

    private static class Trash {
        AtomicBoolean bool;
        Runnable runnable;

        Trash(AtomicBoolean bool, Runnable runnable) {
            this.bool = bool;
            this.runnable = runnable;
        }

        public AtomicBoolean getBool() {
            return bool;
        }

        public Runnable getRunnable() {
            return runnable;
        }
    }
}
