/**
 *
 * @author Harnoor Singh
 *
 * Purpose of the program:
 *      The purpose of this program is to use basic Data Structure the Array 2 dimensionally. This will
 *      all the user to calculate Addition and Multiplication of 2D Arrays only if the size of the Matrix is
 *      atleast 25x25. This program only works for Square Matrices with nxn dimension. It also reprompts the
 *      user until he or she enters atleast dimension as 25 or wants to use/run the program again.
 *
 * Solution for problem and algorithms used:
 *      Basic nested for loops were created to store Random numbers in the array and also to add and multiply two
 *      matrices.
 *
 *Data Structures used in this solution:
 *		The most basic Data Structure the Array was used in this Program
 *
 *Description of how to use the program and expected input/output:
 *		In order to use this program, the user will need to run the program and enter an integer that is the
 *	    dimension of the square matrix which should be greater than or equal to 25.
 *
 */

package Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class matrix {
    static long startTime;
    static long endTime;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter dimension for nxn Square Matrix: ");
            int dimension = input.nextInt();
            if (dimension < 25) {
                System.out.println("Number is Less than 25. Please Re-enter");
                continue;
            }

            int[][] matrix1 = genRandomArray(dimension);
            int[][] matrix2 = genRandomArray(dimension);
            System.out.println("Matrix 1: " + Arrays.deepToString(matrix1));
            System.out.println("Matrix 2: " + Arrays.deepToString(matrix2));
            /////////                       ADDITION Starts
            startTime = System.currentTimeMillis();
            int[][] addedArray = addArrays(matrix1, matrix2);
            endTime = System.currentTimeMillis();
            System.out.println("Addition of Matrices took " + (endTime - startTime) + " milliseconds \n Solution: " + Arrays.deepToString(addedArray));
            /////////                       ADDITION Ends

            /////////                       MULTIPLICATION Starts
            startTime = System.currentTimeMillis();
            int[][] multipliedArray = multiplyArrays(matrix1, matrix2);
            endTime = System.currentTimeMillis();
            System.out.println("Multiplication of Matrices took " + (endTime - startTime) + " milliseconds \n Solution: " + Arrays.deepToString(multipliedArray));
            /////////                       MULTIPLICATION Ends
            System.out.println("Do you want to Continue? enter y/n ");
            String continueProgram = input.next();
            if (dimension >= 25 & continueProgram.equalsIgnoreCase("n"))
                break;
            else
                continue;
        }
    }
    /*
    This method generates a random 2D array (Matrix) for the size provided
     */
    public static int[][] genRandomArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 30) + 1;
            }
        }
        return array;
    }
    /*
    This method adds two 2D arrays (Matrix)
     */
    public static int[][] addArrays(int[][] arr1, int[][] arr2) {
        int[][] solution = new int[arr1.length][arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                solution[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return solution;
    }
    /*
    This method multiplies two 2D arrays (Matrix)
     */

    public static int[][] multiplyArrays(int[][] arr1, int[][] arr2) {
        int[][] solution = new int[arr1.length][arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    solution[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        return solution;
    }
}
