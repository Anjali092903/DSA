import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();  // Array size
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        
        int target = sc.nextInt(); // Element to search

        Accio ob = new Accio();
        int ans = ob.findElement(arr, N, target);

        System.out.println(ans);
        sc.close();
    }
}

class Accio {
    static int findElement(int arr[], int n, int target) {
        // Step 1: Find the peak element index
        int peak = findPeak(arr, n);

        // Step 2: Perform binary search in the increasing part
        int index = binarySearch(arr, 0, peak, target, true);
        if (index != -1) return index; // Found in increasing part

        // Step 3: Perform binary search in the decreasing part
        return binarySearch(arr, peak + 1, n - 1, target, false);
    }

    // Function to find the peak (max element) using Binary Search
    private static int findPeak(int arr[], int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Peak is in the left side
            } else {
                left = mid + 1; // Peak is in the right side
            }
        }
        return left; // Peak index
    }

    // Binary search function
    private static int binarySearch(int arr[], int left, int right, int target, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid; // Found target

            if (isAscending) { // For increasing part
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            } else { // For decreasing part
                if (arr[mid] > target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}




Search In Bitonic Array!
Given a zero based Bitonic array arr of size N. You need to find the index of the target value in the array arr, if it is present else -1.

Note

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Input Format
The first line of input contains a single integer representing N.

The second line of input contains N space seperated integer representing array element.

The third line of input contains the target, element to be searched in the array.

Output Format
Return the positon of target value in the array if present else -1.

Example 1
Input

7
-3 9 18 20 17 5 1
20
Output:

3
Explanation:

Element 20 is found at index 3.

Example 2
Input

3
3 4 1
5
Output:

-1
Explanation:

Element 5 can not be found in the array so we output -1.

Constraints
1 <= N <= 10^5

-10^6 <= arr[i] <= 10^6

Topics
Binary Search
Arrays
