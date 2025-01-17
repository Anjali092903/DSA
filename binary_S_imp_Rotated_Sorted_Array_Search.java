import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.search(A, B));
    }
}

class Solution {
    public int search(final int[] a, int target) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the target
            if (a[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (a[low] <= a[mid]) {
                if (target >= a[low] && target < a[mid]) {
                    // Target is in the sorted left half
                    high = mid - 1;
                } else {
                    // Target is in the right half
                    low = mid + 1;
                }
            }
            // Else, the right half is sorted
            else {
                if (target > a[mid] && target <= a[high]) {
                    // Target is in the sorted right half
                    low = mid + 1;
                } else {
                    // Target is in the left half
                    high = mid - 1;
                }
            }
        }

        // If the target is not found
        return -1;
    }
}




Rotated Sorted Array Search
Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value, B, to search. If found in the array, print its index; otherwise, print -1.

You may assume no duplicate exists in the array.

Note

Array A was sorted in non-decreasing order before rotation.

You need to think of an O(log n) solution.

Input Format
The first line given is an integer N, denoting the size of array A.

The second line given is N integers, the elements of array A.

The third line given is the integer B.

Output Format
Print index of B in array A; otherwise, print -1.

Example 1
Input

8
4 5 6 7 0 1 2 3
4
Output

0
Explanation

Target 4 is found at index 0 in A.

Example 2
Input

4
5 17 100 3
6
Output

-1
Explanation

6 is not present in the array.

Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are distinct.

Topics
Binary Search
Companies
Intuit
PayTM
Amazon
FactSet
Adobe
BankBazaar
Hike
Flipkart
Snapdeal
MakeMyTrip
DE Shaw
Google
Microsoft
