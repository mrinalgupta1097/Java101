package executerframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
  public static void main(String[] args) {
    /*
     * An Executor that provides methods to manage termination
     * and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
     * An ExecutorService can be shut down, which will cause it to reject new tasks.
     *  Two different methods are provided for shutting down an ExecutorService.*/
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    executorService.execute(newRunnable("Task1"));
    executorService.execute(newRunnable("Task2"));
    executorService.execute(newRunnable("Task3"));

    /*shutDown() method
     * Initiates an orderly shutdown in which previously submitted tasks are executed,
     *  but no new tasks will be accepted.
     *  Invocation has no additional effect if already shut down.
     *  This method does not wait for previously submitted tasks to complete execution.
     *  Use awaitTermination to do that.*/
    executorService.shutdown();
  }

  private static Runnable newRunnable(String message) {
    return new Runnable() {
      @Override
      public void run() {
        String completeMessage = Thread.currentThread().getName() + ": " + message;
        System.out.println(completeMessage);
      }
    };
  }
}
