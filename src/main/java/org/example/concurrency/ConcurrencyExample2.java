package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExample2 {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("printing record: " + i);
                }
            });
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end"); // this could be printed in the middle of other output, main() is still independent thread
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

}
