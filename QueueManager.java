import java.util.*;
/**
 * Write a description of class QueueManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QueueManager {
    private static final String LINE = "\n" + "*".repeat(72) + "\n";

    private final Queue<CustomerInformation> primaryCounter = new PriorityQueue<>();
    private final Queue<CustomerInformation> primaryExpressCounter = new PriorityQueue<>();
    private final Queue<CustomerInformation> secondaryExpressCounter = new PriorityQueue<>();

    public final List<Queue<CustomerInformation>> queues = List.of(primaryCounter, primaryExpressCounter, secondaryExpressCounter);

    // Stores the counter where next customer will be added.
    private Queue<CustomerInformation> currentExpressCounter = secondaryExpressCounter;

    public Queue<CustomerInformation> nextExpressCounter() {
        if (currentExpressCounter.equals(primaryExpressCounter))
            currentExpressCounter = secondaryExpressCounter;
        else
            currentExpressCounter = primaryExpressCounter;
        
        return currentExpressCounter;

    }

    public int counterNumber(Queue<CustomerInformation> counter) {
        if (counter.equals(primaryExpressCounter)) return 1;
        else if (counter.equals(secondaryExpressCounter)) return 2;
        else if (counter.equals(primaryCounter)) return 3;
        return 0;
    }

    public void addToPrimary(CustomerInformation customer) {
        customer.setCounterPaid(counterNumber(primaryCounter));
        primaryCounter.add(customer);
    }

    public void addToExpress(CustomerInformation customer) {
        nextExpressCounter().add(customer);
        customer.setCounterPaid(counterNumber(currentExpressCounter));
    }

    public void queuesStatus() {
        System.out.println("Counter 1 Queue: " + primaryExpressCounter.toString() 
            + "\nCounter 2 Queue: " + secondaryExpressCounter.toString() 
            + "\nCounter 3 Queue: " + primaryCounter.toString());
        
    }
    public String queuesStatusCounter1() {
        return ("Counter 1 Queue: " + primaryExpressCounter.toString());
    }
    public String queuesStatusCounter2() {
        return ("Counter 2 Queue: " + secondaryExpressCounter.toString());
    }
    public String queuesStatusCounter3() {
        return ("Counter 3 Queue: " + primaryCounter.toString());
    }

    public static void flush(Queue<CustomerInformation> queue) {
        CustomerInformation customer = queue.poll();

        while (customer != null) {
            System.out.print(LINE + "Customer ID: " + customer.toString() +"\nCustomer IC: " + customer.getCustIc() +"\nCounter Paid: " + customer.getCounterPaid() + "\n\n" + customer.getItem().toString() + LINE);
            customer = queue.poll();
        }
    }
}
