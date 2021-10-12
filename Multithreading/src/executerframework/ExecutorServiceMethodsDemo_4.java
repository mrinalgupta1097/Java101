package executerframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMethodsDemo_4 {
  public static void main(String[] args) {
    //
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    /*
     * In order to create a pool of one thread use
     * ExecutorService executorService = Executors.newSingleThreadExecutor*/

    executorService.execute(
        () -> System.out.println(Thread.currentThread().getName() + " : Task1.1"));
    executorService.execute(
        () -> System.out.println(Thread.currentThread().getName() + " : Task1.2"));
    executorService.execute(
        () -> System.out.println(Thread.currentThread().getName() + " : Task1.3"));

    //   submit() method - Submits a Runnable task for execution and returns a Future representing
    // that task. The Future's get method will return null upon successful completion.
    Future<?> future =
        executorService.submit(
            () -> System.out.println(Thread.currentThread().getName() + " : Task1.1"));

    /*More About Future
     * A Future represents the result of an asynchronous computation.
     *  Methods are provided to check if the computation is complete, to wait for its completion,
     *  and to retrieve the result of the computation.
     *  The result can only be retrieved using method get when the computation has completed,
     *  blocking if necessary until it is ready. Cancellation is performed by the cancel method. */
    System.out.println(future.isDone());

    try {
      future.get(); // get() method returns null if the task is in progress state
    } catch (InterruptedException | ExecutionException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(future.isDone());

    executorService.shutdown();
  }
}
