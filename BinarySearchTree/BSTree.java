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
 *         This Java file has three classes BSTree, TreeNode and Driver. BSTree and TreeNode are used to implement Binary Search
 *         Tree and Driver class is used to store number in BSTree and LinkedList and print them.
 */

public class BSTree {
    TreeNode root;

    /**
     * @param root Root of the tree
     * @param val  Value to be inserted
     * @return TreeNode object
     */
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    /**
     * Method to insert value to the Binary Tree
     *
     * @param val
     */
    void insert(int val) {
        root = insert(root, val);
    }

    /**
     * @param root
     */
    private void infixTraversal(TreeNode root) {
        if (root != null) {
            infixTraversal(root.left);
            System.out.println(root.data);
            infixTraversal(root.right);
        }
    }

    /**
     * Method to print the tree
     */
    void printTree() {
        infixTraversal(root);
    }
}

/**
 * Node class that contains the data to be stored in the Binary Tree
 */
class TreeNode {
    int data;
    TreeNode left, right;

    /**
     * Constuctor to store the data into TreeNode
     *
     * @param data
     */
    public TreeNode(int data) {
        this.data = data;
    }
}

class Driver {
    /**
     * The purpose of this class is to implement the linkedlist and binaryTree.
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int maxRange = 100;
        for (int i = 0; i < maxRange; i++) {
            int random = 1 + (int) (Math.random() * (99));
            list.add(random);
        }
        System.out.println("Linked List: Horizontal");
        list.printList();
        BSTree binaryTree = new BSTree();
        LinkedList.Node curLinkedNode = list.head;
        while (curLinkedNode != null) {
            binaryTree.insert(curLinkedNode.data);
            curLinkedNode = curLinkedNode.next;
        }
        System.out.println("\n--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Binary Search Tree: Vertical");
        binaryTree.printTree();
    }
}