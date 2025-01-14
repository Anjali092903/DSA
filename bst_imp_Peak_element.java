import java.util.*;

class Solution {
    // Function to find the peak element
    public int findPeak(int arr[], int n) {
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
                return mid; // Peak element found
            }

            // If the element on the right is greater, move to the right half
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } 
            // If the element on the left is greater, move to the left half
            else {
                hi = mid - 1;
            }
        }
        return -1; // This line should never be reached because the array is guaranteed to have a peak
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt(); // Number of test cases
            while (t > 0) {
                int n = sc.nextInt(); // Size of the array
                int[] A = new int[n];

                // Reading the array elements
                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextInt();
                }

                Solution ob = new Solution();
                int ans = ob.findPeak(A, n);

                // Check if the found element is a peak by checking its neighbors
                if (ans == 0) {
                    if (A[ans] > A[ans + 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else if (ans == n - 1) {
                    if (A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else {
                    if (A[ans] > A[ans + 1] && A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
                t--; // Decrease the number of test cases
            }
        }
    }
}













Peak element
Given an array A with N positive integers.

Your task is to find the index of peak element i.e. an element that is not smaller than its neighbors i.e. if arr[i] is the peak element, arr[i-1]<arr[i] and arr[i+1]<arr[i].

Note For corner elements, we need to consider only one neighbor.

Input Format
The first line contains the number of test cases T

For each test case: The first line contains an integer N denoting the number of elements.

The second line contains N space separated integers denoting the elements of the array A.

You need to complete findPeak function which contains array arr of size N and returns the index of the peak element.

Output Format
For each test case return an integer, denoting the index of the peak element. If there are multiple peak element return any one index.

Example 1
Input

1
5
1 10 3 10 2
Output

1
Explanation

10 is greater than 1 and 3. Therefore index 1 is a peak element

The answer is 1.

Note The answer can even be 4.

Example 2
Input

1
5
1 2 3 4 5
Output

4
Explanation

5 is greater than 4.

Thus answer is index 4.

There is only one unique answer in this case.

Constraints
1 <= T <= 10

1 <= N <= 10000

1 <= A[i] <= 1000000000

Topics
Binary Search
Arrays
Companies
Visa
Amazon
Adobe
Google
