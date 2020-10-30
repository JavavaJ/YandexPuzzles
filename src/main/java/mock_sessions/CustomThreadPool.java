package mock_sessions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CustomThreadPool implements ExecutorService {

    private int maxThreads;
    private final List<Thread> threads = new ArrayList<>();
    private ConcurrentLinkedQueue<Runnable> tasks = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunning = false;


    public CustomThreadPool(int maxThreads) {
        this.maxThreads = maxThreads;
        init();
    }

    public void init() {
        isRunning = true;

        for (int i = 0; i < maxThreads; i++) {
            Thread thread = new Thread(() -> {
                while(isRunning) {
                    Runnable runnable = tasks.poll();
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });

            thread.start();
            threads.add(thread);
        }
    }

    @Override
    public Future<?> submit(Runnable task) {
        tasks.add(task);
        return null;
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
}
