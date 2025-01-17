import java.util.*;

public class Main {

    public static void findPosition(int a[], int n, int k) {
        int first = findFirst(a, n, k);
        int last = findLast(a, n, k);

        // Print the results
        System.out.println(first + " " + last);
    }

    // Helper method to find the first occurrence of the target
    private static int findFirst(int[] a, int n, int k) {
        int low = 0, high = n - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == k) {
                result = mid; // Potential first occurrence
                high = mid - 1; // Move left to find earlier occurrence
            } else if (a[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Helper method to find the last occurrence of the target
    private static int findLast(int[] a, int n, int k) {
        int low = 0, high = n - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == k) {
                result = mid; // Potential last occurrence
                low = mid + 1; // Move right to find later occurrence
            } else if (a[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        findPosition(array, n, k);
    }
}








Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, print[-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Input Format
The first line contains two integers n (number of elements in the array) and target.

The second line contains n integers (value of elements in the array).

Output Format
Print two space separated integers denoting the first and last index of target.

Example 1
Input

 6 8
 5 7 7 8 8 10
Output

 3 4
Explanation

8 occurs for the first time at index 3 and at index 4 for the last time.

Example 2
Input

 6 6
 5 7 7 8 8 10
Output

 -1 -1
Explanation

6 doesn't occur in the given array, hence we return -1 -1

Constraints
0 <= nums.length <= 10^5

-10^9 <= nums[i] <= 10^9

nums is a non-decreasing array.

-10^9 <= target <= 10^9

Topics
Binary Search
Arrays
Companies
Intuit
Facebook
ByteDance
Amazon
Twitter
Qualtrics
Tesla
Shopee
Bloomberg
Nutanix
Oracle
Adobe
Flipkart
Apple
Uber
Snapchat
Google
Microsoft
LinkedIn
Audible
Netflix
Yandex
Quip(Salesforce)
