package org.example.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ConcurrencyExample5 {

  public static void main(String[] args) throws Exception {
    callableAndRunnableComparison();
  }

  private static void callableAndRunnableComparison() throws InterruptedException, ExecutionException {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    Runnable task1 = () -> System.out.println("Hello zoo");
    Callable<String> task2 = () -> {
      System.out.println("Monkey");
      return "Monkey";
    };

    ScheduledFuture<?> result1 = service.schedule(task1, 2, TimeUnit.SECONDS);
    ScheduledFuture<String> result2 = service.schedule(task2, 4, TimeUnit.SECONDS);

    result1.get();
    result2.get();

    service.shutdown();
  }

}
