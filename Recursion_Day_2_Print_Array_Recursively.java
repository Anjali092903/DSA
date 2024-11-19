import java.util.*;  // Importing the Scanner class to take user input

public class Main {
    
    // Main method, where the program execution starts
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        
        // Read the number of elements 'n' in the array
        int n = sc.nextInt();
        
        // Create an array of size 'n' to store the elements
        int[] arr = new int[n];

        // Read the 'n' elements from the user and store them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Storing each element input by the user in the array
        }

        // Call the PrintArray method to print the array elements
        PrintArray(arr, n);
        
        // Close the scanner object to avoid resource leakage
        sc.close();
    }

    // Recursive method to print the array elements
    public static void PrintArray(int[] arr, int n) {
        
        // Base case: if n == 0, stop the recursion
        // This is the condition that will prevent the recursion from going beyond the array bounds
        if (n == 0) {
            return;  // Return if the size of the array is zero (no elements left to process)
        }
        
        // Recursive step: Call the method with (n - 1), effectively reducing the size of the array to process
        PrintArray(arr, n - 1);
        
        // After the recursion returns (when n becomes 0), print the current element (arr[n-1]).
        // This ensures the elements are printed in the order they appear in the array (starting from arr[0]).
        System.out.print(arr[n - 1] + " ");
    }
}







Print Array Recursively
You are given an array arr of n elements, you are required to print all the n elements in a single line.

Note: Print the elements using a Recursive approach and not using loops(for, while, etc).

Input Format
First line contains an integer n which is the number of elements.

Second line contains n space separated integers.

Output Format
Print all the n elements space-separated in a single line

Example 1
Input

4
1 2 3 4
Output

1 2 3 4
Constraints
1 <= n <= 1000

0 <= arr[i] <= 1000
