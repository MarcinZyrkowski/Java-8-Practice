package org.example.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyExample4 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    usingCallableWithTaskResult();
  }

  private static void usingCallableWithTaskResult() throws InterruptedException, ExecutionException {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<Integer> result = service.submit(() -> 30 + 11);
      // .submit() supports both callable and runnable interfaces
      // callable unlike runnable returns type
      System.out.println(result.get());
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
