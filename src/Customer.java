import java.util.concurrent.ThreadLocalRandom;

public class Customer implements Runnable {
    private final OrderQueue orderQueue;
    private final int customerId;

    public Customer(OrderQueue orderQueue, int customerId) {
        this.orderQueue = orderQueue;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int orderId = ThreadLocalRandom.current().nextInt(1, 100);
                Order order = new Order(orderId);
                orderQueue.placeOrder(order); // Place order in the queue
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000)); // Simulate time between orders
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Customer " + customerId + " interrupted.");
        }
    }
}
