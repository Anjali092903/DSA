import java.util.*;

class Solution {
    static int count1(int size, int arr[]) {
        int low = 0, high = size - 1;

        // Perform binary search to find the first occurrence of 0
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                // Move right to find the last occurrence of 1
                low = mid + 1;
            } else {
                // Move left to limit the range
                high = mid - 1;
            }
        }

        // After the loop, `low` points to the index of the first 0
        // or beyond the array if all elements are 1
        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n, array));
    }
}



Count 1 in sorted binary array
Given a binary sorted non-increasing array arr of size N. You need to print the count of 1 in the binary array.

Try to solve the problem using binary search

Input Format
Each test case contains two lines. The first line contains N (size of binary array). The second line contains N elements of binary array separated by space.

Output Format
In new line, print the count of 1 in binary array.

Example 1
Input

8
1 1 1 1 1 0 0 0
Output

5
Explanation

Number of 1 in given binary array : 1 1 1 1 1 0 0 0 is 5.

Example 2
Input

4
1 1 1 1
Output

4
Explanation

Number of 1 in given binary array : 1 1 1 1 is 4.

Constraints
1 <= N <= 10^6

arr[i] = 0,1

Topics
Binary Search
Arrays
