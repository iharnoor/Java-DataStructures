package Assignments;
/**
 * @author Harnoor Singh
 * Program name: testarray.java
 * Due Date: Oct 2, 2017
 * Purpose of the class:
 *      This is class the main method class for ArrayList. This class has been made to test all the functionalities
 *      of ArrayList. ArrayList gets generated randomly with the size inputted by the user

 * Solution for problem and algorithms used:
 *      Solution of the problem has been to divide the tasks in to small methods so that the code is reusable. Separate
 *      methods has been created to fill the ArrayList with Random numbers and also to test it.
 *
 * Data Structures used in this solution:
 *      The ArrayList created using Array has been used in this class.
 *
 * Description of how to use the program and expected input/output:
 *      The user input is taken for the size of the ArrayList and is tested and printed on the screen.
 *
 */

import java.util.Scanner;

public class testarray {
    /**
     * The class starts with method where all methods in this class are called (Also some from ArrayList class).
     * @param args
     */
    public static void main(String[] args) {
        ArrayList preDefinedList = new ArrayList();
        preDefinedList = fill1(preDefinedList, 15);

        int size = userInputSize();//Took size from the User Input

        ArrayList userDefinedList = new ArrayList(size);
        userDefinedList = fill2(userDefinedList, 15);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("List 1 generated with default size :" + preDefinedList.toString());
        System.out.println("List 2 generated with Initial size of " + size + ": " + userDefinedList.toString());
        testing(preDefinedList,userDefinedList);
    }

    /**
     * This method does not return anything. It just prints on the screen the output from the basic operations performed
     * on the ArrayList.
     * @param preDefined
     * For Testing preDefined ArrayList
     * @param userDefined
     * Foor Testing userDefined ArrayList
     */

    public static void testing(ArrayList preDefined, ArrayList userDefined) {
        System.out.println("------------------------------------------------------------------------------------------");
        preDefined.add(2,3);
        userDefined.add(2,3);
        System.out.println("preDefinedList.add(2,3) : "+preDefined);
        System.out.println("userDefinedList.add(2,3) : "+userDefined);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("preDefinedList.size() : "+preDefined.size());
        System.out.println("userDefinedList.size() : "+userDefined.size());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("preDefinedList.isEmpty() : "+preDefined.isEmpty());
        System.out.println("userDefinedList.isEmpty() : "+userDefined.isEmpty());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("preDefinedList.isIn(5) : "+preDefined.isIn(5));
        System.out.println("userDefinedList.isIn(5) : "+userDefined.isIn(5));
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("preDefinedList.find(5) : "+preDefined.find(5));
        System.out.println("userDefinedList.find(5) : "+userDefined.find(5));
        System.out.println("------------------------------------------------------------------------------------------");
        preDefined.remove(preDefined.get(1));
        userDefined.remove(userDefined.get(1));
        System.out.println("preDefinedList.remove(preDefined.get(1)) : "+preDefined);
        System.out.println("userDefinedList.remove(preDefined.get(1)) : "+userDefined);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
    }

    /**
     * @param list
     * It takes list as a parameter and fills the ArrayList with random numbers ranging from 1 to 25 using the method
     * add(object) from the ArrayList class.
     * @param size
     * It takes the size of the ArrayList to fill it with Random numbers.
     * @return
     * It returns the ArrayList after filling it with random numbers.
     */
    public static ArrayList fill1(ArrayList list, int size) {
        for (int i = 0; i < size; i++) {
            int random_number = (int) ((Math.random() * (25)) + 1);
            list.add(random_number);//note, this generates numbers from [1,8]
        }
        return list;
    }
    /**
     * @param list
     * It takes list as a parameter and fills the ArrayList with random numbers ranging from 1 to 25 using the method
     * add(index, object) from the ArrayList class. This method uses different add method that is the one with two
     * parameters from the ArrayList class.
     * @param size
     * It takes the size of the ArrayList to fill it with Random numbers.
     * @return
     * It returns the ArrayList after filling it with random numbers.
     */
    public static ArrayList fill2(ArrayList list, int size) {
        for (int i = 0; i < size; i++) {
            int random_number = (int) ((Math.random() * (25)) + 1);
            list.add(i, random_number);//note, this generates numbers from [1,8]
        }
        return list;
    }

    /**
     * This method does not take any parameter. It takes the user input from the user for the size of the ArrayList to
     * be created.
     * @return
     * It returns an integer size so that it can be used to create the ArrayList.
     *
     */
    public static int userInputSize() {
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.println("Please enter the size to create an ArrayList");
        boolean error = true;
        do {
            try {
                size = input.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid Integer size:");
                input.next();
            }
        } while (error);
        return size;
    }
}
