import java.io.*;
import java.util.*;

public class Main {

    public static int searchInsert(int[] a, int b) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == b) {
                return mid; // Target found at index mid
            } else if (a[mid] < b) {
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        return low; // If not found, return the insertion position
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A, B));
    }
}






Sorted Insert Position
Given a sorted array A and a target value B, return the index if the target is found. If not, print the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Input Format
The first line of input contains an integer n.

The second line of input contains n space-separated integers, each a value of A[i].

The third line of input contains target value B.

Output Format
Print the index where the element is present. If it's not present, print the index it would be inserted into the sorted array.

Example 1
Input

4
1 3 5 6 
5
Output

2
Explanation

5 is found at index 2

Example 2
Input

4
1 3 5 6
2
Output

1
Explanation

2 will be inserted at index 1.

Constraints
1 <= N <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9

Topics
Binary Search
Arrays
Companies
Facebook
Amazon
Tiktok
Bloomberg
Adobe
VMware
Apple
Google
Microsoft
Yahoo
