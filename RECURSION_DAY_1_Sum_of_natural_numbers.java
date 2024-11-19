import java.util.*;

public class Main {
    // Recursive function to calculate the sum of numbers from 1 to N
    static long NumberSum(long N) {
        // Base case: if N is 0, return 0 (sum of zero numbers is zero)
        if (N == 0) {
            return 0;
        }

        // Recursive call: calculate the sum of numbers from 1 to N-1
        long prevSum = NumberSum(N - 1);

        // Return the current number added to the sum of previous numbers
        return N + prevSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number N
        long N = scanner.nextLong();

        // Print the result of the recursive sum
        System.out.println(NumberSum(N));

        // Close the scanner
        scanner.close();
    }
}






Sum of natural numbers
Write a recursive program to find out the sum of all natural numbers till N. Take input of N from the user and make a recursive function that returns the sum of all the natural numbers upto N.

Input Format
First line is an integer N

Output Format
Print the sum of first N natural numbers.

Example 1
Input

5
Output

15
Explanation

Here, n = 5, so 1 + 2 + 3 + 4 + 5 = 15

Example 2
Input

1
Output

1
Explanation

Here n = 1, so 1 = 1

Constraints
1 <= N < = 10^3

Topics
Basics
Recursion
