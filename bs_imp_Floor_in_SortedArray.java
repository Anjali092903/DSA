import java.util.*;
import java.io.*;

public class Main {
    public static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int result = -1; // Initialize result as -1 (not found)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return mid; // Exact match found
            } else if (arr[mid] < x) {
                result = mid; // Update result as this might be the floor
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findFloor(arr, n, x));
    }
}





Floor in a Sorted Array
Given a sorted array arr[] of size N without duplicates, and given a value x. Find the index of floor of x in given array. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Try to use binary search to solve this problem.

Input Format
First line of input contains number of integers in array, N and element whose floor is to be searched.
Last line of input contains array elements.
Output Format
Output the index of floor of x if exists, else print -1. Use 0-indexing.

Example
Input

7 0 
1 2 8 10 11 12 19
Output

-1
Explanation

No element less than or equal to 0 is found. So output is "-1".

Example 2
Input

7 5 
1 2 8 10 11 12 19
Output

1
Explanation

Number less than or equal to 5 is 2, whose index is 1(0-based indexing).

Example 3
Input

7 10 
1 2 8 10 11 12 19
Output

3
Explanation

Number less than or equal to 10 is 10 and its index is 3.

Constraints
1 ≤ N ≤ 10^5
1 ≤ arr[i] < 10^9
0 ≤ X ≤ arr[n-1]
Topics
Binary Search
Companies
Amazon
