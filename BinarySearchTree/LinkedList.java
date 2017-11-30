package Assignments;

/**
 * @author Harnoor Singh
 *         Program name: calc.java
 *         Due Date: Nov 29, 2017
 *         <p>
 *         Purpose of the program:
 *         The program's purpose is to create Binary Search Tree and Linked List from scratch. Numbers in the LinkedList
 *         are used as input for Binary Search Tree.
 *         <p>
 *         Solution for problem and algorithms used:
 *         The best solution has been to create both data structures in two different files and use then in a Driver class to
 *         make the code re-usable. We are generating 100 random integer numbers between 0-99. The program will display unsorted
 *         in the linkedlist and then in the Binary Search tree using InOrderTraversal.
 *         <p>
 *         Data Structures used in this solution:
 *         Linked List and Binary trees are used. (Created from Scratch)
 *         <p>
 *         Description of how to use the program and expected input/output:
 *         No user input is required. The user will see Random numbers in the Linked List and then in the Binary Search Tree
 *         using InOrderTraversal.
 *         <p>
 *         Purpose of this class:
 *         This Java file has two classes LinkedList and Node. Node class stores the data that gets stored in to the
 *         LinkedList
 */
public class LinkedList {
    class Node {
        int data;
        Node next;

        /**
         * Node constructor to store the data in Node.
         *
         * @param d
         */
        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;  // head of list

    /**
     * Method to add/append data into LinkedList
     *
     * @param data
     */
    void add(int data) {
        if (head == null) {
            head = new Node(data);//head become the new data
            return;
        }
        Node current = head;
        while (current.next != null) {//point to the last not null elemet
            current = current.next;//points to the last element that is null
        }
        current.next = new Node(data);// last element become new node
    }

    /**
     * Method to print the data in the LinkedList.
     */
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

