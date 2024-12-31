import java.util.concurrent.ThreadLocalRandom;

public class Barista implements Runnable {
    private final OrderQueue orderQueue;
    private final int baristaId;

    public Barista(OrderQueue orderQueue, int baristaId) {
        this.orderQueue = orderQueue;
        this.baristaId = baristaId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = orderQueue.takeOrder(); // Take order from the queue
                System.out.println("Barista " + baristaId + " is preparing: " + order);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 1500)); // Simulate coffee preparation time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Barista " + baristaId + " interrupted.");
        }
    }
}
