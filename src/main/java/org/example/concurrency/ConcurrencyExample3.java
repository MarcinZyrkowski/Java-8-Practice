package org.example.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyExample3 {

  public static void main(String[] args) {
    executingTaskAngGetResult();
  }

  private static void executingTaskAngGetResult() {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<?> result = service.submit(() -> {
        for (int i = 0; i < 500; i++) {
          System.out.println("printing record: " + i);
        }
      });
      result.get(10, TimeUnit.SECONDS);
    } catch (TimeoutException | InterruptedException | ExecutionException e) {
      System.out.println("Not reached in time");
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
