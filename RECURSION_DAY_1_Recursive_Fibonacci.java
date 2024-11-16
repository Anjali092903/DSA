import java.util.*;
import static java.lang.Math.ceil;

public class Main {
    /**
     * Recursive function to calculate the nth Fibonacci number.
     * @param n: The position of the Fibonacci sequence to calculate.
     * @return: The nth Fibonacci number.
     */
    public static int fib(int n) {
        // Base case: If n is 1, the first Fibonacci number is 0
        if (n == 1) {
            return 0;
        }
        
        // Base case: If n is 2, the second Fibonacci number is 1
        if (n == 2) {
            return 1;
        }
        
        // Recursive case: Sum of the two previous Fibonacci numbers
        int firstPrev = fib(n - 1);  // Fibonacci number at (n-1)
        int secondPrev = fib(n - 2); // Fibonacci number at (n-2)
        
        return firstPrev + secondPrev; // Return the sum
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object for input
        
        // Read the position n from the user
        int n = sc.nextInt();
        
        // Calculate and print the nth Fibonacci number
        System.out.println(fib(n));
    }
}





Recursive Fibonacci
Given an integer N, find the Nth number in the fibonacci series. Consider 0 and 1 to be the seed values.

In a fibonacci series, each number ( Fibonacci number ) is the sum of the two preceding numbers. The series with 0 and 1 as seed values will go like -

0, 1, 1, 2, 3, 5.....

Input Format
First line contains the integer N

Output Format
Print the Nth fibonacci number

Example 1
Input

1
Output

0
Example 2
Input

2
Output

1
Example 3
Input

5
Output

3
Constraints
1 <= N <= 30

Topics
Recursion
Companies
Amazon
Goldman Sachs
Adobe
MAQ Software
Oyo Rooms
Snapdeal
MakeMyTrip
Microsoft
