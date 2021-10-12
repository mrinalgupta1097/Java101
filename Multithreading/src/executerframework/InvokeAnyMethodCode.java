package executerframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyMethodCode {
  public static void main(String[] args) {
    //
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    List<Callable<String>> callables = new ArrayList<>();
    callables.add(() -> Thread.currentThread().getName() + " : " + "task1.1");
    callables.add(() -> Thread.currentThread().getName() + " : " + "task1.2");
    callables.add(() -> Thread.currentThread().getName() + " : " + "task1.3");

    /*
     * Executes the given tasks,
     *  returning the result of one that has completed successfully
     *  (i.e., without throwing an exception), if any do.
     *  Upon normal or exceptional return, tasks that have not completed are cancelled.
     *  The results of this method are undefined
     *  if the given collection is modified while this operation is in progress.*/

    try {
      String result = executorService.invokeAny(callables);
      System.out.println(result);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
  }
}
