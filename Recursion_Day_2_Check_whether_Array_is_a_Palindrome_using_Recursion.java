import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Read the size of the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Read array elements
        }
        sc.close();

        // Call the function to check if the array is a palindrome
        System.out.println(isPalindrome(arr, n));
    }

    // Function to check if the array is a palindrome
    public static boolean isPalindrome(int[] arr, int n) {
        // Call the recursive helper function
        return isPalindrome(arr, 0, n - 1);
    }

    // Recursive helper function to check palindrome property
    public static boolean isPalindrome(int[] arr, int st, int en) {
        // Base case: If start index crosses or equals the end index, it is a palindrome
        if (st >= en) {
            return true;
        }
        // Check if the elements at start and end indices are equal
        if (arr[st] == arr[en]) {
            // Recur for the next pair of indices
            return isPalindrome(arr, st + 1, en - 1);
        } else {
            // If any pair of elements is not equal, return false
            return false;
        }
    }
}






Check whether Array is a Palindrome using Recursion
Given an array arr of length n, you have to find whether the given array is a palindrome using recursion.

Note: A palindrome is an array which reads the same both forwards and backwards.

Input Format
First line consists of an integer n, the number of elements in the array

Second line consists of n spaced inetegrs, representing the array arr.

Output Format
Print true if the array is a palindrome else print false.

Example 1
Input

4
4 3 2 10
Output

false
Explanation

Backwards, it reads 10, 2, 3, 4 which is not the same

Example 2
Input

5
1 2 3 2 1
Output

true
Explanation

Backwards it reads 1, 2, 3, 2 1 which is the same.

Constraints
1 <= n <= 10^3

-10^4 <= arr[i] <= 10^4

Topics
Recursion
Arrays



