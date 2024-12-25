
import java.util.*;
import java.io.*;

class Solution {
    // Merge Sort function that sorts an array from index l to r
    static int[] mergeSort(int[] arr, int l, int r) {
        // Base case: if there's only one element in the array, return it
        if (l == r) {
            int[] ans = new int[1]; // Create an array of size 1
            ans[0] = arr[l]; // Store the single element in the array
            return ans; // Return the single element array
        }

        // Find the middle index to divide the array into two parts
        int mid = (l + r) / 2;
        
        // Recursively sort the left half of the array
        int[] left = mergeSort(arr, l, mid);
        
        // Recursively sort the right half of the array
        int[] right = mergeSort(arr, mid + 1, r);
        
        // Create an array to hold the merged result of left and right arrays
        int[] ans = new int[left.length + right.length];
        
        // Indices for traversing the left, right, and result arrays
        int i = 0, j = 0, k = 0;

        // Merge the two sorted arrays (left and right) into the ans array
        while (i < left.length && j < right.length) {
            // Compare elements of left and right arrays, insert the smaller one
            if (left[i] < right[j]) {
                ans[k] = left[i]; // Put the smaller element in the result array
                i++; // Move to the next element in the left array
            } else {
                ans[k] = right[j]; // Put the smaller element in the result array
                j++; // Move to the next element in the right array
            }
            k++; // Move to the next index in the result array
        }

        // If there are remaining elements in the left array, add them to the result
        while (i < left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }

        // If there are remaining elements in the right array, add them to the result
        while (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }

        // Return the merged and sorted array
        return ans;
    }
}

public class Main {
    public static void main(String args[]) {
        // Read input from the user
        Scanner input = new Scanner(System.in);
        
        // Size of the array
        int n = input.nextInt();
        
        // Array to hold the input values
        int[] a = new int[n];
        
        // Read the elements of the array
        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();
        
        // Create an object of the Solution class
        Solution obj = new Solution();
        
        // Sort the array using merge sort
        a = obj.mergeSort(a, 0, n - 1);
        
        // Print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        
        // Close the input scanner
        input.close();
    }
}










Implementing Merge Sort
Given an array A[] of size N, containing positive integers. You need to sort the elements of array using the merge sort algorithm.

Input
The input consists of two lines.

The first line of input is the size of array N and the second line consists of N array elements separated by space.

Output
Print the sorted array in a new line.

Example 1
Input

5
4 1 3 9 7
Output

1 3 4 7 9 
Explanation

The array after performing merge sort: 1 3 4 7 9.

Example 2
Input

10
10 9 8 7 6 5 4 3 2 1
Output

1 2 3 4 5 6 7 8 9 10
Explanation

The array after performing merge sort: 1 2 3 4 5 6 7 8 9 10.

Constraints
1 <= N <= 10^5

-10^6 <= A[i] <= 10^6

Topics
Sorting
Companies
PayTM
Amazon
Snapdeal
Qualcomm
Microsoft
