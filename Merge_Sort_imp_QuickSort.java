import java.util.*;  // Importing the utility package for Scanner
import java.io.*;    // Importing input-output classes

// This is the class containing the merge sort logic
class Solution {

    // Method to perform Merge Sort on the array
    static int[] mergeSort(int[] arr, int l, int r) {
        
        // Base case: If the array has only one element, return it
        if (l == r) {
            int[] ans = new int[1];   // Create a new array of size 1
            ans[0] = arr[l];          // Assign the single element
            return ans;               // Return the single-element array
        }

        // Step 1: Find the middle index to divide the array
        int mid = (l + r) / 2;

        // Step 2: Recursively sort the left half of the array
        int[] left = mergeSort(arr, l, mid);

        // Step 3: Recursively sort the right half of the array
        int[] right = mergeSort(arr, mid + 1, r);

        // Step 4: Merge the sorted left and right halves into a single sorted array
        int[] ans = new int[left.length + right.length];  // Resultant array to store the merged result
        int i = 0;  // Pointer for left array
        int j = 0;  // Pointer for right array
        int k = 0;  // Pointer for the merged array

        // Step 5: Compare elements of left and right arrays and insert the smaller one into the merged array
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {  // If left's element is smaller
                ans[k] = left[i];      // Add it to the merged array
                i++;                   // Move pointer for left array
            } else {                   // If right's element is smaller
                ans[k] = right[j];     // Add it to the merged array
                j++;                   // Move pointer for right array
            }
            k++;  // Move pointer for merged array
        }

        // Step 6: Add remaining elements of the left array (if any)
        while (i < left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }

        // Step 7: Add remaining elements of the right array (if any)
        while (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }

        // Step 8: Return the merged and sorted array
        return ans;
    }
}

// Main class to execute the program
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);  // Create a scanner object for input

        // Step 1: Read the size of the array
        int n = input.nextInt();

        // Step 2: Initialize an array of size n
        int[] a = new int[n];

        // Step 3: Read n elements into the array
        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();

        // Step 4: Create an instance of the Solution class
        Solution Obj = new Solution();

        // Step 5: Call the mergeSort function to sort the array
        a = Obj.mergeSort(a, 0, n - 1);

        // Step 6: Print the sorted array
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
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
