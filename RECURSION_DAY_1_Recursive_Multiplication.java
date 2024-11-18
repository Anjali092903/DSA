import java.io.*; 
import java.util.*;

public class Main {
    // Recursive function to calculate n * m
    public static int multiplyRecursively(int n, int m) {
        // Base case: if m is 0, the product is 0
        if (m == 0) {
            return 0;
        }

        // Recursive case: n * m = n + (n * (m - 1))
        return n + multiplyRecursively(n, m - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // First number
        int m = scn.nextInt(); // Second number
        
        // Call the recursive function and print the result
        System.out.println(multiplyRecursively(n, m));
    }
}





Recursive Multiplication
You are given two integers N and M. Calculate and return their multiplication using recursion.

You can only use subtraction and addition for your calculation. No other operators are allowed.

Note

Complete the given function. The input would be handled by the driver code. You only have to print the answer.

Input Format
The first line contains N.

The second line contains M.

Output Format
Print the product.

Example 1
Input

10
13
Output

130
Explanation

10 * 13 = 130

Example 2
Input

5
4
Output

20
Explanation

5 * 4 = 20.

Constraints
1 <= N, M <= 10000
