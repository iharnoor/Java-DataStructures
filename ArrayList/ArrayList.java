package Assignments;

/**
 * @author Harnoor Singh
 *         Program name: ArrayList.java
 *         Due Date: Oct 2, 2017
 *         Purpose of the program:
 *         The program's purpose is to develop an ArrayList from scratch. The ArrayList behaves similar to the one already in
 *         the java library. This class defines necessary methods and constructors so that the ArrayList can be created and
 *         modified accordingly. The method includes add(Object x), add(int index, Object x), get(int index),
 *         size(), isEmpty(), isIn(Object ob), find(Object n), remove(Object n) and toString().
 *         <p>
 *         The most important operations include creating an ArrayList with the default size of 10 and the
 *         other is creating with a size of our choice. Two operations add(element) and add (i,element) have been defined to
 *         add an element in the end or at particular.
 *         <p>
 *         Solution for problem and algorithms used:
 *         The solution of program has been creating small methods for the necessary operations in an ArrayList. For loops
 *         have been created in methods such as add, remove and find. All these method together make this program more
 *         efficient and reusable.
 *         <p>
 *         Data Structures used in this solution:
 *         The most basic data structure Array has been used in this class.
 *         <p>
 *         Description of how to use the program and expected input/output:
 *         The input has only been passed through the testarray.java class which checks the proper functioning of the
 *         ArrayList. The output gets printed on the screen after running the main method class.
 *         <p>
 *         <p>
 *         Purpose of this class:
 *         This class is used to declare and define the methods for the necessary operations of ArrayList. This is class
 *         does not contain main method. It acts as a template and also contains global variables so that objects can be
 *         created outside the class.
 */


public class ArrayList {

    Object[] objectArray;
    private int capacity;

    /**
     * Constructor 1. It creates the Array at a default size of 10
     */
    public ArrayList() {
        capacity = 10;
        objectArray = new Object[capacity];
    }

    /**
     * Constructor 1. It creates the Array at any given size.
     * It changes the global variable capacity to intialCapacity (inputted by the user) and also initializes the Array
     * with the given size.
     *
     * @param initialCapacity This is the capacity of Array when user wants to create an ArrayList of any given size.
     */

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        objectArray = new Object[capacity];
    }

    /**
     * This method is created to add object to the end of the ArrayList. If the Array is full then the capacity(size)
     * of Array gets doubled.
     * This method modifies the objectArray and its capacity (length of Array)
     *
     * @param x x is the object that gets added to the end of the Array.
     */
    public void add(Object x) {
        if (size() == capacity) {
            Object[] tempArr = new Object[capacity * 2];
            for (int i = 0; i < size(); i++)
                tempArr[i] = objectArray[i];

            objectArray = tempArr;
            capacity *= 2;
        }
        objectArray[size()] = x;
    }

    /**
     * This method adds object x to any given index of the Array.
     * <p>
     * This method modifies the objectArray and its capacity (length of Array)
     *
     * @param index The parameter is the location where the element needs to be added.
     * @param x     This parameter is the Object that needs to be added.
     */
    public void add(int index, Object x) {
        if (size() > 0) {
            Object[] tempArr = new Object[capacity + 1];
            for (int i = 0; i < index; i++)
                tempArr[i] = objectArray[i];

            tempArr[index] = x;
            for (int i = index + 1; i < objectArray.length; i++)
                tempArr[i] = objectArray[i - 1];

            objectArray = tempArr;  //Assigns objectArray to tempArr
            capacity += 1;
        } else add(x);
    }

    /**
     * Getter. Returns the element associated with the given index of the objectArray.
     *
     * @param index It is the location of the element
     * @return Object
     * Returns the Object associated at the given index.
     */
    public Object get(int index) {
        return objectArray[index];
    }

    /**
     * Takes no parameters.
     *
     * @return count
     * Returns the occupied elements in the Array (Not null).
     */
    public int size() { // returns the size of the Array in an integer
        int count = 0;
        for (int i = 0; i < objectArray.length; i++)
            if (objectArray[i] != null)
                count++;
        return count;
    }

    /**
     * Takes no parameters.
     *
     * @return Returns true if the Array is empty otherwise returns false.
     */
    public boolean isEmpty() {
        int nullCount = 0;
        for (int i = 0; i < this.objectArray.length; i++)
            if (this.objectArray[i] == null)
                nullCount++;
        return nullCount == this.objectArray.length;
    }

    /**
     * @param ob Checks if this parameters in this objectArray (array) or not.
     * @return Returns true if it is present else it returns false.
     */
    public boolean isIn(Object ob) {
        boolean exists = false;
        for (int i = 0; i < objectArray.length; i++)
            if (ob.equals(objectArray[i]))
                exists = true;
        return exists;
    }

    /**
     * Find the object in the Array
     *
     * @param ob Looks for this parameter in the objectArray (array).
     * @return Returns the location if it is present otherwise returns -1.
     */
    public int find(Object ob) {
        int location = -1;
        if (isIn(ob))
            for (int i = 0; i < objectArray.length; i++)
                if (ob.equals(objectArray[i])) {
                    location = i;
                    break;
                }
        return location;
    }

    /**
     * Removes the passed object.
     *
     * @param ob Modifies the objectArray by deleting the passed object in the Array.
     */
    public void remove(Object ob) {
        Object[] tempArr = new Object[capacity - 1];
        int location = find(ob);
        int j = 0;
        for (int i = 0; i < size(); i++) {
            if (i == location)
                continue;
            tempArr[j++] = objectArray[i];
        }
        objectArray = tempArr;
    }

    /**
     * No parameters
     *
     * @return It returns the Array as a String which is suitable for printing.
     */
    public String toString() {
        String stringArr = "[";
        for (int i = 0; i < size(); i++)
            stringArr = i == size() - 1 ? stringArr + objectArray[i] : stringArr + objectArray[i] + ",";
        stringArr = stringArr + "]";
        return stringArr;
    }
}
