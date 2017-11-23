package Bank;

/**
 * @author Harnoor Singh
 * Program name: Bank.java
 * Due Date: Nov 15, 2017
 * <p>
 * Purpose of the program:
 * The program's purpose is to simulate a queue in bank. There are total 5 tellers that are occupied by default and
 * there is queue that grows as the customer enters after every 2-6 seconds. Also, the customer spends a random time
 * between 2-5 seconds with the teller.
 * Originally Each teller is occupied.
 * Execution Run=2 minutes. Customers arrive between 2-6 seconds. Each customer will take around 2-5 seconds
 * <p>
 * Solution for problem and algorithms used:
 * The best solution to the problem has been to use Queue data structure for queue in a bank and an array to store the
 * Tellers' objects. Also, currentTimeMillis() is used to make the program run for 120 seconds.
 * <p>
 * Data Structures used in this solution:
 * Queue (Built on a Linked List)and Array have been used from the Java library.
 * <p>
 * Description of how to use the program and expected input/output:
 * To run the program the user is required to enter y or Y. He will be reprompted for the same once the stats are
 * printed.
 * <p>
 * Purpose of this class:
 * The driver class is main method class where methods from this class are called. Furthermore, Customer and Teller
 * classes are used in this class to modify and use their parameters.
 */

import java.util.*;

public class Bank {
    static int totalCustomers = 0;
    static Teller[] tellerArray = new Teller[5];
    static Queue<Customer> customerQueue = new LinkedList<Customer>();

    /**
     * Main method: To call the methods in this class
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String prompt = "";
        while (true) {
            System.out.print("Do you want to run the program? (Enter Y or y) ");
            prompt = input.next();
            if (!prompt.equalsIgnoreCase("Y"))
                System.exit(0);
            simulate();
        }
    }

    /**
     * Modifies the Customer Queue and the Teller Array as the customers are added.
     */
    public static void simulate() {
        Random generator = new Random();
        long currTime = System.currentTimeMillis();
        long stopTime = currTime + (120 * 1000);
        int timeSpent = 0; //Time spent by customer at the teller
        long custArrivalTime = currTime + (generator.nextInt(5) + 2) * 1000;// Time of arrival of customer 2-6 seconds

        System.out.println("Current Time: " + currTime + "\nResult will be Printed in 120 Seconds");
        defaultTellers(currTime);
        while (System.currentTimeMillis() < stopTime) {
            for (int i = 0; i < 5; i++) {
                currTime = System.currentTimeMillis();
                if (custArrivalTime < currTime) {
                    Customer cust = new Customer();
                    cust.arrivalTime = custArrivalTime;
                    customerQueue.add(cust);
                    custArrivalTime = currTime + ((generator.nextInt(5) + 2) * 1000);
                }
                if (tellerArray[i].timeOfExit < currTime)
                    tellerArray[i].free = true;

                if (tellerArray[i].isFree()) {
                    if (!customerQueue.isEmpty()) {
                        customerQueue.poll();
                        timeSpent = generator.nextInt(5) + 2;
                        tellerArray[i].timeOfExit = (currTime + (timeSpent * 1000));
                        tellerArray[i].timeSpent = (tellerArray[i].timeSpent + timeSpent);
                        tellerArray[i].customersHelped = (tellerArray[i].customersHelped + 1);
                    }
                }
            }
        }
        printStats();
    }

    /**
     * To set the default tellers as not free.
     * Each teller has one customer by default.
     *
     * @param currTime
     */
    public static void defaultTellers(long currTime) {
        int timeSpent;
        Random generator = new Random();
        for (int i = 0; i < 5; i++) {
            tellerArray[i] = new Teller();
            timeSpent = generator.nextInt(4) + 2;//Time after new Customer arrives
            tellerArray[i].timeOfExit = (currTime + (timeSpent * 1000));//Time at the customer
            tellerArray[i].timeSpent = timeSpent;
        }
    }

    /**
     * To print the stats after the execution of the simulation.
     * It removes all the elements in the customerQueue.
     */
    public static void printStats() {
        for (int i = 0; i < 5; i++) {
            totalCustomers += tellerArray[i].customersHelped;
            System.out.println("Teller " + (i + 1) + ": " + tellerArray[i]);
        }
        int count = 0;
        while (!customerQueue.isEmpty()) {
            customerQueue.poll();
            count++;
        }
        System.out.println("Customers that did not get to see a teller: " + count);
        System.out.println("Customers that visited the bank: " + (totalCustomers + count));
    }
}
