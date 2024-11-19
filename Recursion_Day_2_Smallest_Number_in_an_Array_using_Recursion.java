import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of elements in the array
        int n = sc.nextInt();
        
        // Initialize the array of size 'n'
        int[] arr = new int[n];
        
        // Read the 'n' elements and store them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        sc.close();  // Close the scanner after input is taken
        
        // Call the recursive function to find the minimum value
        System.out.println(recforMin(arr, 0));
    }

    // Recursive function to find the minimum element in the array
    public static int recforMin(int[] arr, int idx) {
        // Base case: If we've reached the end of the array, return a large number
        if (idx == arr.length) {
            return Integer.MAX_VALUE;  // Corrected MAX_VALUE
        }
        
        // Recursive case: Find the minimum element in the rest of the array
        int min = recforMin(arr, idx + 1);  // Recursive call to check the next element
        
        // Return the smaller of the current element and the minimum found so far
        if (arr[idx] < min) {
            return arr[idx];
        }
        
        // Otherwise, return the current minimum
        return min;
    }
}









Smallest Number in an Array using Recursion
Given an array arr of length n, you have to find the minimum element present in the array using recursion.

Input Format
First line consists of an integer n, the number of elements in the array

Second line consists of n spaced inetegrs, representing the array arr.

Output Format
Return the minimum element of the array.

Example 1
Input

3
1 2 3
Output

1
Explanation

1 is the smallest among 1, 2 and 3.

Example 2
Input

5
5 4 0 -8 67
Output

-8
Explanation

-8 is the smallest among 5, 4, 0, -8 and 67

Constraints
1 <= n <= 10^3

-10^4 <= arr[i] <= 10^4
