import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        // Initialize the range for binary search
        int low = 1, high = A;
        int ans = 0;

        // Binary search to find the floor of the square root
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid; // Use long to avoid overflow

            if (square == A) {
                // If perfect square, output the result and return
                System.out.println(mid);
                return;
            } else if (square < A) {
                // If mid^2 is less than A, move to the right half
                ans = mid; // Update the possible answer
                low = mid + 1;
            } else {
                // If mid^2 is greater than A, move to the left half
                high = mid - 1;
            }
        }

        // Print the floor of the square root
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        sqrt(A);
    }
}




Square root of a number
Given an integer x, find the square root of x.

If x is not a perfect square, then return floor(√x).

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Note: Try Solving the question without using sqrt Function.

Input Format
The only line contains an integer x.

Output Format
Print the square root of x.

Example 1
Input

5
Output

2
Explanation

Since, 5 is not a perfect square, floor of square root of 5 is 2.

Constraints
1 ≤ x ≤ 10^7
Topics
Binary Search
Math
