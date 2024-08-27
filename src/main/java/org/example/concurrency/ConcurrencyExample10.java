package org.example.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExample10 {

  public static void main(String[] args) {
    usingCyclicBarrier();
  }

  private void removeAnimals() {
    System.out.println("removing animals");
  }

  private void cleanPen() {
    System.out.println("cleaning pen");
  }

  private void addAnimals() {
    System.out.println("adding animals");
  }

  public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
    try {
      removeAnimals();
      c1.await();
      cleanPen();
      c2.await();
      addAnimals();
    } catch (BrokenBarrierException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  /*
      Thread Pool Size and Cyclic Barrier Limit
      If you are using a thread pool, make sure you set the number of available threads to be at least as large as
      your CyclicBarrier limit value. For example, what if we changed the code to allocate only two threads,
      such as in the following snippet?
      ExecutorService service = Executors.newFixedThreadPool(2);
      In this case, the code will hang indefinitely. The barrier would never be reached as the only threads available
      in the pool are stuck waiting for the barrier to complete.
   */
  public static void usingCyclicBarrier() {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(4);

      ConcurrencyExample10 manager = new ConcurrencyExample10();

      CyclicBarrier c1 = new CyclicBarrier(4);
      CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** pen cleaned"));

      for (int i = 0; i < 4; i++) {
        service.submit(() -> manager.performTask(c1, c2));
      }
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
