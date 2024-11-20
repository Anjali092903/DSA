import java.util.Scanner;  // Importing Scanner class to read input from the user

public class Main {

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Read the number of elements in the array
        int n = sc.nextInt();

        // Create an array of size 'n' to store the elements
        int[] arr = new int[n];

        // Read the 'n' elements from the user and store them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the PrintReverseArray method to print the array in reverse order
        PrintReverseArray(arr, 0);  // Starting from index 0
        
        // Close the scanner to avoid resource leaks
        sc.close();
    }

    // Recursive method to print array in reverse order
    public static void PrintReverseArray(int[] arr, int index) {
        // Base case: If we've reached the end of the array, stop the recursion
        if (index == arr.length) {
            return;  // Do nothing when all elements are printed
        }

        // Recursive call: Print elements from the current index to the last
        PrintReverseArray(arr, index + 1);

        // Print the element after the recursive call (this ensures reverse printing)
        System.out.print(arr[index] + " ");
    }
}










Print Reverse Array Recursively
You are given an array arr of n elements, you are required to print all the n elements but in a reverse order, in a single line.

Note: Print the elements using a Recursive approach and not using loops(for, while, etc).

Input Format
First line contains an integer n which is the number of elements.

Second line contains n space separated integers.

Output Format
Print all the n elements but in reverse space-separated in a single line

Example 1
Input

4
1 2 3 4
Output

4 3 2 1
Constraints
1 <= n <= 1000

0 <= arr[i] <= 1000

Topics
Recursion
Arrays
Companies
Amazon
Infosys
MAQ Software
VMware
