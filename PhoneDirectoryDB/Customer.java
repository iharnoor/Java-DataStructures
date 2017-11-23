package Assignments;

/**
 * @author Harnoor Singh
 *         <p>
 *         Program name: Customer.java
 *         Due Date: October 18, 2017
 *         <p>
 *         Purpose of the class:
 *         This class created to collect all the information relating to the Customer that are first name, last name and
 *         phone number. This class is treated as a database for storing infomation for the Customer in our LinkedList.
 */
public class Customer {
    String firstName, lastName, phoneNumber;

    /**
     * Default Constructor
     */
    public Customer() {
        firstName = "";
        lastName = "";
        phoneNumber = "";
    }

    /**
     * @param firstName Stores the first name of the Customer as String
     * @param lastName  Stores the last name of customer as String
     * @param phoneNum  Stores the phone number of the customer as String
     */

    public Customer(String firstName, String lastName, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = parsePhNo(phoneNum);
    }

    /**
     * @return returns the first name as String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return returns the last name as String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return returns the phone number as String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param firstName changes the phone number to the parameter passed (String).
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName changes the phone number to the parameter passed (String).
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param phoneNumber changes the phone number to the parameter passed (String).
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return Returns the content of Customer Object as String.
     */

    public String toString() {
        if (!phoneNumber.contains("-")) {
            String one = phoneNumber.substring(0, 3);
            String two = phoneNumber.substring(3, 6);
            String three = phoneNumber.substring(6);
            phoneNumber = one + "-" + two + "-" + three;
        }
        String str1 = String.format("\n%-20s %-20s %-20s \n", "First Name", "Last Name", "Phone Number:");
        String str2 = String.format("%-20s %-20s %-20s \n", "-------------", "-------------", "-------------", "-------------");
        String str3 = String.format("%-20s %-20s %-20s \n", firstName, lastName, phoneNumber);
        return str1 + str2 + str3;
    }

    public int compareTo(Customer cust) {
        if (lastName.compareTo(cust.lastName) == 0) {
            if (firstName.compareTo(cust.getFirstName()) == 0) {
                return phoneNumber.compareTo(cust.getPhoneNumber());
            } else
                return firstName.compareTo(cust.getFirstName());
        } else return lastName.compareTo(cust.getLastName());
    }

    public String parsePhNo(String phoneNumber) {
        if (!phoneNumber.contains("-")) {
            String one = phoneNumber.substring(0, 3);
            String two = phoneNumber.substring(3, 6);
            String three = phoneNumber.substring(6);
            phoneNumber = one + "-" + two + "-" + three;
        }
        return phoneNumber;
    }

}
