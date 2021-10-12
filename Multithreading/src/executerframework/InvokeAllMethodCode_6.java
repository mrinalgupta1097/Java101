package executerframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllMethodCode_6 {
  public static void main(String[] args) {
    //
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    List<Callable<String>> callables = new ArrayList<>();
    callables.add(() -> Thread.currentThread().getName() + " : " + "task1.1");
    callables.add(() -> Thread.currentThread().getName() + " : " + "task1.2");
    callables.add(() -> Thread.currentThread().getName() + " : " + "task1.3");

    /*invokeALl() method
     * Executes the given tasks, returning a list of Futures holding their status and results when all complete. Future.isDone is true for each element of the returned list. Note that a completed task could have terminated either normally or by throwing an exception. The results of this method are undefined if the given collection is modified while this operation is in progress*/
    try {
      List<Future<String>> results = executorService.invokeAll(callables);
      results.forEach(
          result -> {
            try {
              System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
              e.printStackTrace();
            }
          });

    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    executorService.shutdown();
  }
}
