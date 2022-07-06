import java.util.*;
/**
 * Write a description of class QueueManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QueueManager {
    //Creates a line using *
    private static final String LINE = "\n" + "*".repeat(72) + "\n";

    private final Queue<CustomerInformation> primaryCounter = new PriorityQueue<>();
    private final Queue<CustomerInformation> primaryExpressCounter = new PriorityQueue<>();
    private final Queue<CustomerInformation> secondaryExpressCounter = new PriorityQueue<>();

    public final List<Queue<CustomerInformation>> queues = List.of(primaryCounter, primaryExpressCounter, secondaryExpressCounter);

    // Stores the counter where next customer will be added.
    private Queue<CustomerInformation> currentExpressCounter = secondaryExpressCounter;
    //Determines whether a customer would end up in Counter 1 or Counter 2
    public Queue<CustomerInformation> nextExpressCounter() {
        if (currentExpressCounter.equals(primaryExpressCounter))
            currentExpressCounter = secondaryExpressCounter;
        else
            currentExpressCounter = primaryExpressCounter;
        
        return currentExpressCounter;

    }
    //Sets a customers counter
    public int counterNumber(Queue<CustomerInformation> counter) {
        if (counter.equals(primaryExpressCounter)) return 1;
        else if (counter.equals(secondaryExpressCounter)) return 2;
        else if (counter.equals(primaryCounter)) return 3;
        return 0;
    }
    //Adds customer to Primary / Counter 3 queue
    public void addToPrimary(CustomerInformation customer) {
        //Sets customer counter number
        customer.setCounterPaid(counterNumber(primaryCounter));
        primaryCounter.add(customer);
    }
    //Passes customer to a method which determines either Counter 1 or Counter 2
    public void addToExpress(CustomerInformation customer) {
        nextExpressCounter().add(customer);
        //Sets customer cunter number
        customer.setCounterPaid(counterNumber(currentExpressCounter));
    }
    //Prints queue
    public void queuesStatus() {
        System.out.println("Counter 1 Queue: " + primaryExpressCounter.toString() 
            + "\nCounter 2 Queue: " + secondaryExpressCounter.toString() 
            + "\nCounter 3 Queue: " + primaryCounter.toString());
        
    }
    //Prints queue for Counter 1
    public String queuesStatusCounter1() {
        return ("Counter 1 Queue: " + primaryExpressCounter.toString());
    }
    //Prints queue for Counter 2
    public String queuesStatusCounter2() {
        return ("Counter 2 Queue: " + secondaryExpressCounter.toString());
    }
    //Prints queue for Counter 3
    public String queuesStatusCounter3() {
        return ("Counter 3 Queue: " + primaryCounter.toString());
    }
    //Prints customer receipt
    public static void flush(Queue<CustomerInformation> queue) {
        CustomerInformation customer = queue.poll();

        while (customer != null) {
            System.out.print(LINE + "Customer ID: " + customer.toString() +"\nCustomer IC: " + customer.getCustIc() +"\nCounter Paid: " + customer.getCounterPaid() + "\n\n" + customer.getItem().toString() + LINE);
            customer = queue.poll();
        }
    }
}
