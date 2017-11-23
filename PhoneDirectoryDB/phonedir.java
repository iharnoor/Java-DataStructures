package Assignments;
/**
 * @author Harnoor Singh
 * Program name: phonedir.java
 * Due Date: Oct 18, 2017
 * <p>
 * Purpose of the program:
 * The program's purpose is to used LinkedList from the Java library. The LinkedList data structure plays the role
 * of a database and it helps in pushing data into the database, fetching it and modifying it. The phone number is always
 * unique and the linked list is always sorted without using a sorting algorithm directly from Java Library.
 * <p>
 * Solution for problem and algorithms used:
 * The solution of program has been creating small methods for the necessary operations of this database carried through
 * the LinkedList. All these method together make this program more efficient and reusable. Alogirthims has been defined
 * in these methods that allow the user to perform all the necessary operations in the database's menu. List is sorted
 * by placing the Customer objects into the required position using a compareTo method.
 * <p>
 * Data Structures used in this solution:
 * LinkedList has been used from the Java library.
 * <p>
 * Description of how to use the program and expected input/output:
 * The user is required to input the commands from the menu in order to start using the database. With the help of
 * these commands the user will easily be able to perform all the necessary operations carried throughout this database.
 * <p>
 * Purpose of this class:
 * This class the is main method class where methods from this class and the Customer class are called. This class
 * defines all the methods required for the functioning of the database such as add, remove and modify.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class phonedir {
    static LinkedList<Customer> customerLinkedList = new LinkedList<Customer>();
    private static int current = customerLinkedList.size() - 1;

    /**
     * Main method.
     * This method is used to call all the methods in this class and from the Customer class. It uses a switch statement
     * to call the methods associated with the specific commands in the menu.
     *
     * @param args
     */

    public static void main(String[] args) {
        menu();
        Scanner input = new Scanner(System.in);
        String commandStr;
        char command = 0;
        while (command != 'q') {
            while (true) {
                commandStr = input.next();
                if (commandStr.length() == 1) {
                    command = commandStr.charAt(0);
                    break;
                } else
                    System.out.println("Invalid Command");
            }
            switch (command) {
                case 'a':
                    showAllRecords();
                    break;
                case 'd':
                    deleteCurrentRecord(input);
                    break;
                case 'n':
                    addRecordN(input);
                    break;
                case 'f':
                    changeFirstName(input);
                    break;
                case 'l':
                    changeLastName(input);
                    break;
                case 'p':
                    changePhoneNumber(input);
                    break;
                case 's':
                    selectCurrentRecord(input);
                    break;
                case 'q':
                    System.out.println("Exited. Thank you for using this DB");
                    break;
                default:
                    System.out.println("Illegal Command");
                    menu();
            }
        }
    }

    /**
     * Precondition: Phone number must be ten digits
     * Postcondition: Changes the the current record to the one you type.
     * Modifies global variables current and LinkedList customerLinkedList.
     *
     * @param input input from the scanner
     */
    public static void selectCurrentRecord(Scanner input) {
        System.out.print("Enter first name: ");
        String fName = input.next().trim();
        System.out.print("Enter last name: ");
        String lName = input.next().trim();
        System.out.print("Enter phone number: ");

        String phNo = input.next().trim();
        phNo = parsePhNo(phNo);
        while (!phNo.matches("[0-9]{3}-?[0-9]{3}-?[0-9]{4}")) {
            System.out.println("Invalid phone number, please try again: ");
            phNo = parsePhNo(input.next());
        }
        Customer cc = new Customer(fName, lName, phNo);
        if (indexOf(cc) != -1) {
            current = indexOf(cc);
        } else {
            System.out.println("Record Not Found");
        }
        System.out.println("Current record is: " + customerLinkedList.get(current));
        System.out.println("------------------------------------------------");
        menu();
    }

    /**
     * modifies the global customerLinkedList. deltes the current record
     *
     * @param input Accepts input from the Scanner to input first name last name and also phone number if required. Phone number will
     *              be required if the last name and the first name is same.
     */
    public static void deleteCurrentRecord(Scanner input) {
        if (!customerLinkedList.isEmpty()) {
            System.out.println("Deleted: " + customerLinkedList.get(current));
            customerLinkedList.remove(current);
        }
        showAllRecords();
        menu();
    }

    /**
     * @param input Accepts input from the Scanner to input first name last name and also phone number if required. Phone number will
     *              be required if the last name and the first name is same. Expected: String
     */
    public static void changeFirstName(Scanner input) {
//        showAllRecords(customerLinkedList);
        System.out.print("\nEnter new first name: ");
        String newFirstName = input.next();
        System.out.println();
        Customer cc = new Customer(newFirstName, customerLinkedList.get(current).getLastName(), customerLinkedList.get(current).getPhoneNumber());
        customerLinkedList.remove(current);
        adding(cc);
        current = customerLinkedList.indexOf(cc);
        System.out.println("Current record is: " + customerLinkedList.get(current));
        System.out.println("------------------------------------------------");
        menu();
    }

    /**
     * @param input Accepts input from the Scanner to input first name last name and also phone number if required. Phone number will
     *              be required if the last name and the first name is same. Expected String.
     */
    public static void changeLastName(Scanner input) {
        showAllRecords();
        System.out.print("\nEnter new last name: ");
        String newLastName = input.next();
        Customer cc = new Customer(customerLinkedList.get(current).getFirstName(), newLastName, customerLinkedList.get(current).getPhoneNumber());
        customerLinkedList.remove(current);
        adding(cc);
        current = customerLinkedList.indexOf(cc);
        System.out.println("Current record is: " + customerLinkedList.get(current));
        System.out.println("------------------------------------------------");
        menu();
    }

    /**
     * @param input Accepts input from the Scanner to input first name last name and also phone number if required. Phone number will
     *              be required if the last name and the first name is same. Expected 10 digit numbers.
     */
    public static void changePhoneNumber(Scanner input) {
        showAllRecords();
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = input.next();
        newPhoneNumber = parsePhNo(newPhoneNumber);
        while (!newPhoneNumber.matches("[0-9]{3}-?[0-9]{3}-?[0-9]{4}") || !isUnique(newPhoneNumber)) {
            System.out.println("Invalid phone number, please try again: ");
            newPhoneNumber = input.next();
        }

        Customer cc = new Customer(customerLinkedList.get(current).getFirstName(), customerLinkedList.get(current).getLastName(), newPhoneNumber);
        customerLinkedList.remove(current);
        adding(cc);
        current = customerLinkedList.indexOf(cc);
        System.out.println("Current record is: " + customerLinkedList.get(current));
        System.out.println("------------------------------------------------");
        menu();
    }

    /**
     * @param input Accepts input from the Scanner to input first name last name and also phone number if required. Phone number will
     *              be required if the last name and the first name is same.
     */
    public static void addRecordN(Scanner input) {
        System.out.print("Enter first name: ");
        String fName = input.next().trim();
        System.out.print("Enter last name: ");
        String lName = input.next().trim();
        System.out.print("Enter phone number: ");
        String phNo = input.next().trim();
        phNo = parsePhNo(phNo);
        while (!phNo.matches("[0-9]{3}-?[0-9]{3}-?[0-9]{4}") || !isUnique(phNo)) {
            System.out.println("Invalid phone number, please try again: ");
            phNo = input.next();
        }
        Customer cc = new Customer(fName, lName, phNo);
        adding(cc);
        current = customerLinkedList.indexOf(cc);
        showAllRecords();
    }

    /**
     * shows all the existing records
     */
    public static void showAllRecords() {
        if (!customerLinkedList.isEmpty()) {
            for (int i = 0; i < customerLinkedList.size(); i++) {
                System.out.println(customerLinkedList.get(i));
            }
        } else
            System.out.println("\nThere are no records");
        menu();
    }

    /**
     * Method to add the elements into the linkedlist into its respective position without using a sorting algorithm.
     * modifies the flobal linkedList. Phone number must be unique..
     *
     * @param c
     */
    public static void adding(Customer c) {
        if (customerLinkedList.size() == 0) {
            customerLinkedList.add(c);
        } else {
            for (int i = 0; i < customerLinkedList.size(); i++) {
                if (c.compareTo(customerLinkedList.get(i)) < 0) {
                    customerLinkedList.add(i, c);
                    break;
                } else if (i == customerLinkedList.size() - 1) {
                    customerLinkedList.add(c);
                    break;
                } else if (c.compareTo(customerLinkedList.get(i)) == 0) {
                    System.out.println("Please enter Unique phone number");
                    break;
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * checks if the phone number is unique or not.
     *
     * @param phNo input phone number
     * @return returns true if phone number is unique else false.
     */
    public static boolean isUnique(String phNo) {
        boolean bool = true;
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).phoneNumber.equals(phNo))
                bool = false;
        }
        return bool;
    }

    /**
     * converts the phone number to a form which contains '-'
     *
     * @param phoneNumber accepts a string phone number
     * @return phoneNumber with '-' if it doesn't contains '-'
     */
    public static String parsePhNo(String phoneNumber) {
        if (!phoneNumber.contains("-")) {
            String one = phoneNumber.substring(0, 3);
            String two = phoneNumber.substring(3, 6);
            String three = phoneNumber.substring(6);
            phoneNumber = one + "-" + two + "-" + three;
        }
        return phoneNumber;
    }

    /**
     * Method to Print the menu each time before taking user Input
     */
    public static void menu() {
        System.out.println("\na. Show all records");
        System.out.println("d. Delete the current record");
        System.out.println("f. Change the first name in the current record");
        System.out.println("l. Change the last name in the current record");
        System.out.println("n. Add a new record");
        System.out.println("p. Change the phone number in the current record");
        System.out.println("q. Quit");
        System.out.println("s. Select a record from the record list to become the current record");
        System.out.print("Enter a command from the list above (q to quit): ");
    }

    /**
     * @param cc Checks if the customer object exists in the customerLinkedList
     * @return -1 if not found otherwise the index of the object.
     */
    public static int indexOf(Customer cc) {
        int index = -1;
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).compareTo(cc) == 0)
                index = i;
        }
        return index;
    }
}
