Transpose of Matrix
Write a program to find the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

Expected Time Complexity: O(N * N)

Expected Space Complexity: Inplace

Input Format
The first line contains an integer N.

The next N lines contains N spaced integers each, elements of matrix.

Output Format
Print the transposed matrix.

Example 1
Input

4
1 1 1 1
2 2 2 2
3 3 3 3
4 4 4 4
Output

1 2 3 4
1 2 3 4
1 2 3 4
1 2 3 4
Explanation

The rows and columns are switched.



  import java.util.*; 
import java.io.*;

// Class containing the logic for matrix transposition
class Solution {

    // Method to transpose the matrix
    public int[][] matrixTranspose(int[][] arr, int n) {
        // Using diagonal approach to transpose the matrix in place
        for(int dig = 0; dig < arr.length; dig++) {
            int i = 0;
            int j = dig;

            // Swap elements along the diagonal and below it
            while(j < arr.length) {
                // Swapping arr[i][j] with arr[j][i]
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
                
                // Move to next element diagonally
                i++;
                j++;
            }
        }
        // Return the transposed matrix
        return arr;
    }
}

// Main class to take input and output the result
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Scanner for reading input
        int n;
        n = sc.nextInt();  // Input the size of matrix
        int[][] matrix = new int[n][n];  // Initialize the NxN matrix
        
        // Taking input elements for the matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        
        Solution Obj = new Solution();  // Creating an object of Solution class
        int[][] ans = Obj.matrixTranspose(matrix, n);  // Calling the transpose method
        
        // Printing the transposed matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println("");  // Print new line after each row
        }
        sc.close();  // Closing the scanner
    }
}
