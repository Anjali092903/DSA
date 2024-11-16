Decrease Print Increase Print
You are given a number N. You have to print the backward counting from N to 1. On reaching 1, you have to print counting from 1 to N.

Note

Complete the body of printDI function to achieve it. Don't change the function Definition.

Input Format
The first line contains a single integer N.

Output Format
Print the counting with each number in a new line.

Example 1
Input

4
Output

4
3
2
1
1
2
3
4
Explanation

We count from 4 to 1 and back to 4 again.

Example 2
Input

2
Output

2
1
1
2
Explanation

We count from 2 to 1 and back to 2 again.

Constraints
1 <= N <= 15000






import java.util.*;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); // Scanner object to take input from the user
        int n = scn.nextInt(); // Read an integer input from the user
        printDI(n); // Call the recursive function to print the desired pattern
    }

    /**
     * Recursive function to print numbers in decreasing and then increasing order.
     * @param n: the current number to process
     */
    public static void printDI(int n) {
        // Base case: if n is 0, terminate the recursion
        if (n == 0) {
            return; // No further processing is required
        }

        // Pre-recursion phase: print the current number
        System.out.println(n);

        // Recursive call: reduce the number by 1
        printDI(n - 1);

        // Post-recursion phase: print the current number again
        System.out.println(n);
    }
}
