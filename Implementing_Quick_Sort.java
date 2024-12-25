import java.util.*;

class Solution{
    static void quickSort(int[] arr){
        // Call the helper quickSort method
        quickSort(arr, 0, arr.length - 1);
    }

    static int partitionArray(int[] arr, int st, int en){
        int pivot = arr[en];  // Pivot element is taken as the last element
        int i = st - 1; // Pointer for the smaller element

        for (int j = st; j < en; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Place the pivot element in the correct sorted position
        int temp = arr[i + 1];
        arr[i + 1] = arr[en];
        arr[en] = temp;
        
        // Return the index of the pivot element
        return i + 1;
    }

    static void quickSort(int[] arr, int st, int en) {
        if (st < en) {
            // Partition the array and get the pivot index
            int idx = partitionArray(arr, st, en);
            
            // Recursively sort the subarrays
            quickSort(arr, st, idx - 1); // Left part
            quickSort(arr, idx + 1, en); // Right part
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        Solution obj = new Solution();
        obj.quickSort(arr);  
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        
        sc.close();
    }
}








Implementing Quick Sort
Given an array A[] of size N, containing positive integers. You need to sort the elements of array using the Quick sort algorithm.

Input Format
The first line of input N is the size of array and the second line consists of N array elements separated by space.

Output Format
Print the sorted array in a new line.

Example 1
Input

5
4 1 3 9 7
Output

1 3 4 7 9 
Explanation

The array after perfoming Quick sort: 1 3 4 7 9.

Example 2
Input

10
10 9 8 7 6 5 4 3 2 1
Output

1 2 3 4 5 6 7 8 9 10
Explanation

The array after performing Quick sort: 1 2 3 4 5 6 7 8 9 10.

Constraints
1 <= N <= 10^5

-10^6 <= A[i] <= 10^6

Topics
Sorting
