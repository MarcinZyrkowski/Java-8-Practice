package org.example.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import lombok.AllArgsConstructor;

public class ConcurrencyExample11 {

    /*
        the difference between RecursiveAction and RecursiveTask is analogous to the difference between Runnable and
        Callable, respectively.
     */

  @AllArgsConstructor
  public static class WeighAnimalAction extends RecursiveAction {

    private int start;
    private int end;
    private Double[] weights;

    @Override
    protected void compute() {
      if (end - start <= 3) {
        for (int i = start; i < end; i++) {
          weights[i] = (double) new Random().nextInt(100);
          System.out.println("animal weighed: " + i);
        }
      } else {
        int middle = start + ((end - start) / 2);
        System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
        invokeAll(new WeighAnimalAction(start, middle, weights), new WeighAnimalAction(middle, end, weights));
      }
    }
  }

  public static void usingRecursiveAction() {
    Double[] weights = new Double[10];

    ForkJoinTask<?> task = new WeighAnimalAction(0, weights.length, weights);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(task);

    // print result
    System.out.println();
    System.out.println("weights: ");
    Arrays.stream(weights)
        .forEach(d -> System.out.println(d.intValue() + " "));
  }

  public static void main(String[] args) {
    usingRecursiveAction();
  }

}
