package Bank;

/**
 * Teller Class to
 */
public class Teller {
    boolean free;
    int customersHelped;//number of customers Helped
    int timeSpent;
    long timeOfExit;

    /**
     * Default Constructor
     */
    public Teller() {
        free = true;
        customersHelped = 1;// as the teller is originally attending a customer
        timeSpent = 0;
        timeOfExit = 0;
    }

    /**
     * To check if a teller is free or not.
     * @return True if free, else false
     */
    public boolean isFree() {
        return free;
    }

    /**
     * To print the
     * @return
     */
    public String toString() {
        return "Customers helped: " + customersHelped + "\tTime occupied: (in seconds)" + timeSpent;
    }
}
