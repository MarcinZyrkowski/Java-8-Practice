package org.example.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import lombok.AllArgsConstructor;

public class ConcurrencyExample12 {

    /*
        the difference between RecursiveAction and RecursiveTask is analogous to the difference between Runnable and
        Callable, respectively.
     */

  @AllArgsConstructor
  public static class WeighAnimalTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;

    @Override
    protected Double compute() {
      if (end - start <= 3) {
        double sum = 0;
        for (int i = start; i < end; i++) {
          weights[i] = (double) new Random().nextInt(100);
          System.out.println("animal weighed: " + i);
          sum += weights[i];
        }
        return sum;
      } else {
        int middle = start + ((end - start) / 2);
        System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
        RecursiveTask<Double> otherTask = new WeighAnimalTask(start, middle, weights);
        otherTask.fork();
        return new WeighAnimalTask(middle, end, weights).compute() + otherTask.join();
      }
    }
  }

  public static void usingRecursiveTask() {
    Double[] weights = new Double[10];

    ForkJoinTask<Double> task = new WeighAnimalTask(0, weights.length, weights);
    ForkJoinPool pool = new ForkJoinPool();
    Double sum = pool.invoke(task);
    System.out.println("sum: " + sum);

    // print result
    System.out.println();
    System.out.println("weights: ");
    Arrays.stream(weights)
        .forEach(d -> System.out.println(d.intValue() + " "));
  }

    /*
        One thing to be careful about when using the fork() and join() methods is the order is which they are applied.
        For instance, while the previous example was multithreaded, the following variation operates with
        single-threaded performance:
        RecursiveTask<Double> otherTask = new WeighAnimalTask(start, middle, weights);
        Double otherResult = otherTask.fork().join();
        return new WeighAnimalTask(middle, end, weights).compute() + otherResult;
        In this example, the current thread calls join(), causing it to wait for the [start, middle] subtask to finish
        before starting on the [middle, end] subtask. In this manner, the results are actually performed in
        single-threaded manner.
     */

  public static void main(String[] args) {
    usingRecursiveTask();
  }

}
