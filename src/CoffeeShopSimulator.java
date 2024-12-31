import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeShopSimulator {
    public static void main(String[] args) {
        int queueCapacity = 5;
        int numCustomers = 3;
        int numBaristas = 2;

        OrderQueue orderQueue = new OrderQueue(queueCapacity);

        ExecutorService executorService = Executors.newFixedThreadPool(numCustomers + numBaristas);

        for (int i = 1; i <= numCustomers; i++) {
            executorService.execute(new Customer(orderQueue, i));
        }

        for (int i = 1; i <= numBaristas; i++) {
            executorService.execute(new Barista(orderQueue, i));
        }

        // Add a shutdown hook to gracefully terminate the simulation
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executorService.shutdownNow();
            System.out.println("Coffee shop simulation shutting down.");
        }));
    }
}
