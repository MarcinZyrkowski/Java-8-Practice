package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExample6 {

  // race condition example
  // prints different number sequence

  private int sheepCount = 0;

  public static void main(String[] args) throws Exception {
    parallelIncrementIssue();
  }

  private static void parallelIncrementIssue() {
    ExecutorService service = null;
    try {
      // creates 20 threads
      service = Executors.newFixedThreadPool(20);
      ConcurrencyExample6 sheepManager = new ConcurrencyExample6();
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
    System.out.println((++sheepCount) + " ");
  }

}
