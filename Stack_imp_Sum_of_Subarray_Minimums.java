import java.io.*;
import java.util.*;

class Solution {
    public long minSubarraySum(int n, int a[]) {
        long mod = 1000000007;
        long totalSum = 0;

        // Arrays to store the count of subarrays where a[i] is the minimum
        long[] leftCount = new long[n];
        long[] rightCount = new long[n];

        // Stack to find previous smaller elements
        Stack<Integer> stack = new Stack<>();
        
        // Calculate leftCount (number of subarrays ending at each index)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            leftCount[i] = (stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }

        // Clear the stack to reuse it for rightCount
        stack.clear();

        // Calculate rightCount (number of subarrays starting at each index)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                stack.pop();
            }
            rightCount[i] = (stack.isEmpty() ? n - i : stack.peek() - i);
            stack.push(i);
        }

        // Calculate the total sum of minimums
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + a[i] * leftCount[i] * rightCount[i]) % mod;
        }

        return totalSum;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n, a));
    }
}



Sum of Subarray Minimums
Given an array of integers arr, find the sum of the minimums of all contiguous subarrays of the array. Since the answer may be large, print the answer modulo 10^9 + 7.

Your task is to complete the function minSubarraySum which receives arr and size of array as parameters and returns the sum of the minimums of all contiguous subarrays of the array

Input Format
The first line contains a single integer n(size of the array).

The second line contains n space integers that denote the elements of the array.

Output Format
Print the sum of minimum of all subarrays.

Example 1
Input

4
3 1 2 4
Output

17
Explanation

Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

Example 2
Input

3
1 2 3
Output

10
Explanation

Subarrays are [1], [2], [3], [1,2], [2,3], [1,2,3].
Minimums are 1, 2, 3, 1, 2, 1.
Sum is 10.

Constraints
1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 3 * 10^4

Topics
Stacks
Companies
Amazon
Adobe
VMware
Dunzo
Uber
Google
Microsoft
