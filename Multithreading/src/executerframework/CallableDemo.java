package executerframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
  public static void main(String[] args) {
    //
    ExecutorService executorService = Executors.newSingleThreadExecutor();
/*
* submit() also takes callable and returns a future object*/
    Future<?> future =
        executorService.submit(
            () -> System.out.println(Thread.currentThread().getName() + " : Task1.2"));

    System.out.println(future.isDone());

    try{
      String result = (String) future.get();
      System.out.println(result);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(future.isDone());
  }
}
