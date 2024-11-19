import java.util.Scanner;

public class Main {
     public static void printZigZag(int n) {
        // Base case: stop recursion when n reaches 0
        if (n == 0) {
            return;
        }
       // Pre-order: print before the recursive calls
        System.out.print(n + " ");
        
        // Recursive call for the first sequence
        printZigZag(n - 1);
        
        // In-order: print after the first recursive call
        System.out.print(n + " ");
        
        // Recursive call for the second sequence
        printZigZag(n - 1);
        
        // Post-order: print after the second recursive call
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read the input
        printZigZag(n); // Call the function
        scanner.close(); // Close the scanner
    }
}






ZigZag Printing
You are given an integer n.

You need to Figure out the pattern and complete the recursive function printZigZag() to achieve the below pattern for any positive number n.

Examples :


  For n = 1  pattern : 1 1 1 
  For n = 2  pattern : 2 1 1 1 2 1 1 1 2
  For n = 3  pattern : 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3

Note:- Input has been handled in the driver code. You need to complete printZigZag() function.

Input Format
single line consisting of an integer n.

Output Format
Print the pattern.

Example 1
Input

2

Output


2 1 1 1 2 1 1 1 2

Explanation


Observe the pattern from the problem statment.

Example 2
Input


3

Output

3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3

Explanation


Observe the pattern from the problem statment.

Constraints
1 <= n <= 10
Topics
Recursion
