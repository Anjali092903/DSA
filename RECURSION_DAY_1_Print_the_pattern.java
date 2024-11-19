import java.io.*;
import java.util.*;

class Main {

    // Recursive function to print the pattern
    public static void solve(int n) {
        // Base case: If n is 0, stop recursion
        if (n == 0) {
            return;
        }

        // Recursive call to handle smaller rows first
        solve(n - 1);

        // Print the current row of stars
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println(); // Move to the next line after printing one row
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Input: number of rows
        int n = sc.nextInt();
        solve(n);

        sc.close();
    }
}





Print the pattern
Using recursion, print the given pattern.

Input Format
First line contains integer n, representing rows of the given pattern

Output Format
Display the given pattern.

Example 1
Input

5

Output


* 
* * 
* * * 
* * * * 
* * * * * 


Explanation:

The number of rows given is 5.

Example 2
Input

3

Output


* 
* * 
* * * 

Explanation:

The number of rows given is 3.

Constraints
1 <= n <= 102

Topics
Recursion
Companies
