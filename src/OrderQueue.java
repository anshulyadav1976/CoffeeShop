import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderQueue {
    private final BlockingQueue<Order> orderQueue;

    public OrderQueue(int capacity) {
        this.orderQueue = new LinkedBlockingQueue<>(capacity);
    }

    public void placeOrder(Order order) throws InterruptedException {
        orderQueue.put(order); // Blocks if the queue is full
        System.out.println("Order placed: " + order);
    }

    public Order takeOrder() throws InterruptedException {
        Order order = orderQueue.take(); // Blocks if the queue is empty
        System.out.println("Order taken: " + order);
        return order;
    }
}
