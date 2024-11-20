import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input number
        int n = sc.nextInt();

        // Call the count7 function and print the result
        System.out.println(count7(n));

        sc.close();
    }

    public static int count7(int n) {
        // Base case: if n is 0, return 0
        if (n == 0) {
            return 0;
        }

        // Extract the last digit of the number
        int ld = n % 10;

        // Remove the last digit of the number
        int rd = n / 10;

        // Recursive call for the remaining digits
        int count = count7(rd);

        // Increment the count if the last digit is 7
        if (ld == 7) {
            return count + 1;
        } else {
            return count;
        }
    }
}





Count 7
Given a number N, your task is to find the number of occurrences of the digit 7 in the number.

Input Format
The first line contains an integer N denoting the number.

Output Format
For each test case return a number, denoting the number of occurrences of the digit 7 in the given number.

Example 1
Input

27727
Output

3
Explanation

There are 3 occurrences of the digit 7 in the number.

Example 2
Input

17245
Output

1
Explanation

There is 1 occurrence of the digit 7 in the number.

Constraints
1 <= N <= 10^9

Topics
Recursion
Math
