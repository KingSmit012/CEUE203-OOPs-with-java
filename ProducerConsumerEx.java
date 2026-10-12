class SharedBuffer {
    private final int[] buffer = new int[3];
    private int count = 0;
    private int in = 0;
    private int out = 0;
 
    public synchronized void produce(int item)
            throws InterruptedException {
        while (count == buffer.length) {
            wait();
        }
 
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
 
        System.out.println("Produced: " + item);
 
        notify();
    }
 
    public synchronized int consume()
            throws InterruptedException {
        while (count == 0) {
            wait();
        }
 
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
 
        System.out.println("Consumed: " + item);
 
        notify();
        return item;
    }
}
 
class Producer implements Runnable {
    private final SharedBuffer buffer;
 
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
 
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted");
        }
    }
}
 
class Consumer implements Runnable {
    private final SharedBuffer buffer;
 
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
 
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted");
        }
    }
}
 
public class ProducerConsumerEx {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
 
        Thread producer = new Thread(
            new Producer(buffer), "Producer"
        );
        Thread consumer = new Thread(
            new Consumer(buffer), "Consumer"
        );
 
        producer.start();
        consumer.start();
 
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
 
        System.out.println();
        System.out.println("All items produced and consumed");
    }
}
 
 