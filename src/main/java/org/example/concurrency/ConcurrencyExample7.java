package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyExample7 {

    // race condition example
    // prints different number sequence (but each number appears)

    private AtomicInteger sheepCount = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        incrementIssueWithAtomic();
    }

    private static void incrementIssueWithAtomic() {
        ExecutorService service = null;
        try {
            // creates 20 threads
            service = Executors.newFixedThreadPool(20);
            ConcurrencyExample7 sheepManager = new ConcurrencyExample7();
            for (int i = 0; i < 10; i++) {
                service.submit(sheepManager::incrementAndReport);
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private void incrementAndReport() {
        System.out.println(sheepCount.incrementAndGet() + " ");
    }

}
