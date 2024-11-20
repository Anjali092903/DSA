import java.util.*;

public class Main {
    // Function to calculate the sum of digits of a number recursively
    static int sumOfDigi(int n) {
        // Base case: if the number becomes 0, return 0
        if (n == 0) {
            return 0;
        }
        // Recursive case: extract the last digit and add it to the result of the remaining number
        return (n % 10) + sumOfDigi(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input number
        int n = sc.nextInt();
        // Call the sumOfDigi function and store the result
        int result = sumOfDigi(n);
        // Print the result
        System.out.println(result);
        sc.close();
    }
}






Find Digit Sum
Given the number n, find out and return the sum of digits present in a number recursively.

Input Format
Input consists of single line which has the integer n.

Output Format
Return the sum of digits present in n.

Example 1
Input

1256
Output

14
Explanation

Here the sum is 1+2+5+6 = 14.

Example 2
Input

12345
Output

15
Explanation

Here the sum is 1+2+3+4+5 = 15.

Constraints
1 <= n <= 10^9

Topics
Recursion
