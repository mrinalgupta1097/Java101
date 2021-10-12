package executerframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Task1"));
        executorService.execute(newRunnable("Task2"));
        executorService.execute(newRunnable("Task3"));

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
