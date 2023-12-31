package mudit;

import java.util.concurrent.*;

class SharedResource {
    // Shared resource
    private volatile int counter = 0;

    // Method synchronized for thread safety
    public synchronized void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class IncrementTask implements Runnable {
    private final SharedResource sharedResource;

    public IncrementTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.incrementCounter(); // Thread-safe method
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Teacher8 {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 1L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        // Creating a ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);

        // Shared resource instance
        SharedResource sharedResource = new SharedResource();

        // Submitting tasks to the ThreadPoolExecutor
        for (int i = 0; i < 3; i++) {
            IncrementTask task = new IncrementTask(sharedResource);
            executor.submit(task);
        }

        // Shutting down the ThreadPoolExecutor
        executor.shutdown();

        // Waiting for all threads to finish
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Displaying the final value of the counter
        System.out.println("Final Counter Value: " + sharedResource.getCounter());
    }
}

