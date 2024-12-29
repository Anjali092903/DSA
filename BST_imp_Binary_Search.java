import java.util.*;

public class Main {
    // Function to find the index of a key in a sorted array using Binary Search
    public static int findIndex(int key, int[] arr) {
        // Initialize the search range: lo is the starting index, hi is the ending index
        int lo = 0;
        int hi = arr.length - 1;
        
        // Perform binary search until the range is exhausted
        while (lo <= hi) {
            // Calculate the middle index
            int mid = (lo + hi) / 2;

            // If the middle element matches the key, return its index
            if (arr[mid] == key) {
                return mid;
            }
            // If the key is greater than the middle element, narrow the search to the right half
            else if (arr[mid] < key) {
                lo = mid + 1;
            }
            // If the key is smaller than the middle element, narrow the search to the left half
            else {
                hi = mid - 1;
            }
        }
        // If the key is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the size of the array and the key to search
        int n, key;
        n = sc.nextInt();  // Size of the array
        key = sc.nextInt();  // Key to search for in the array
        
        // Input the sorted array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the findIndex function and print the result
        System.out.println(findIndex(key, arr));

        // Close the scanner
        sc.close();
    }
}



Binary Search
Given an sorted integer array of size n which contains unique elements, find the index (0-based) of the given key.

If the key is not present then return -1.

Input Format
First line contains two spaced integers the array size n and key

Next line contains n spaced integers.

Output Format
Return the index of the key in the array in the given function or return -1 if it's not present in the array.

Example 1
Input

7 730
43 210 723 730 832 838 997 
Output

3
Explanation

According to 0 based indexing the key 730 is at index 3.

Example 2
Input

10 1
24 50 62 74 87 434 477 625 783 940 
Output

-1
Explanation

key 1 is not present in the array so we return -1.

Constraints
1 <= n <= 10^5

1 <= key <= 10^9

1 <= arr[i] <= 10^9

Topics
Binary Search
Arrays
Companies
Wipro
TCS
Accenture
Oracle
Infosys
Qualcomm
LinkedIn
Cognizant
