import java.util.*;

public class Main {
    static int maximum_occurrence(int arr[], int n) {
        // Sort the array in ascending order
        Arrays.sort(arr); // O(n log n)
        
        int count = 1; // To count occurrences of the current element
        int maxCount = 1; // Maximum frequency
        int maxElement = arr[0]; // Element with the maximum frequency
        
        // Traverse the sorted array to count frequencies
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++; // Increment count for repeated element
            } else {
                count = 1; // Reset count for a new element
            }
            
            // Update maximum count and the corresponding element
            if (count > maxCount) {
                maxCount = count;
                maxElement = arr[i];
            }
        }
        
        return maxElement; // Return the element with the highest frequency
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read size of array
        int[] arr = new int[n];
        
        // Read elements of the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Find the element with the maximum occurrence
        System.out.print(maximum_occurrence(arr, n));
    }
}





Maximum occurrence
You are given an array arr of length n. Your task is to print the element which has maximum occurrences in the array. If two elements have the same occurrence then print the smaller element

Input Format
The first line of input contains an integer n, size of the array.

The next line contains n space seperated integers denoting the elements of the array.

Output Format
Print single integer denoting the maximum occurring element in the array.

Example 1
Input

8
7 7 6 4 8 7 3 1
Output

7
Explanation

We have arr = [7 7 6 4 8 7 3 1]

As 7 is occurring 3

Example 2
Input

7
9 8 1 1 2 2 3
Output

1
Explanation

1 and 2 have smae occurrence that is 2 so print smaller element i.e. 1.

Constraints
1 <= n <= 10^6

1 <= arr[i] <= 10^9
