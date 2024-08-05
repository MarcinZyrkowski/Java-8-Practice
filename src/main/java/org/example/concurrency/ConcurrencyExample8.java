package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExample8 {

    // race condition example
    // prints different number sequence

    private int sheepCount = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService service = null;
        try {
            // creates 20 threads
            service = Executors.newFixedThreadPool(20);
            ConcurrencyExample8 sheepManager = new ConcurrencyExample8();
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
        // lock and monitor sheepCount object
        synchronized (this) {
            System.out.println((++sheepCount) + " ");
        }
    }

    /*
    the above method works the same as method below:
    private synchronized void incrementAndReport() {
        System.out.println((++sheepCount) + " ");
    }
    */

}
