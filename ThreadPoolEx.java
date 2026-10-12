import java.util.concurrent.*;

class Task implements Runnable {
    int id;

    Task(int id) {
        this.id = id;
    }

    public void run() {
        try {
            System.out.println("Task " + id + " running on " + Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            pool.submit(new Task(i));
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("All tasks completed.");
    }
}