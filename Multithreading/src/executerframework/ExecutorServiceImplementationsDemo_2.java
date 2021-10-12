package executerframework;

import java.util.concurrent.*;

public class ExecutorServiceImplementationsDemo_2 {
  /*Executor Service is an interface ie you have to create an object
   * of the class that implements it.
   * Java provides two built in implementations
   * 1. Thread Pool Executor
   * 2. Scheduled Thread Pool Executor.*/

  public static void main(String[] args) {
    //
    int corePoolSize = 10;
    int maxPoolSize = 20;
    long keepAliveTime = 3000;

    ExecutorService threadPoolExecutor =
        new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveTime,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(128));
    threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));

    threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

//    ScheduledExecutorService extends ExecutorService
    ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);


    scheduledExecutorService = Executors.newScheduledThreadPool(10);
  }

//  passing runnable by method
  public static Runnable newRunnable(String message){
    return new Runnable() {
      @Override
      public void run() {
        String completeMessage = Thread.currentThread().getName() + ": " + message;
        System.out.println(completeMessage);
      }
    };
  }
}
