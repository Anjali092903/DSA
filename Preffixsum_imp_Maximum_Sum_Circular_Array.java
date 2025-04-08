import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Step 1: Find max subarray sum using normal Kadane's Algorithm
        int currentMax = arr[0], maxSum = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        // Step 2: Find total sum and min subarray sum
        int totalSum = arr[0];
        int currentMin = arr[0], minSum = arr[0];
        for (int i = 1; i < n; i++) {
            totalSum += arr[i];
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSum = Math.min(minSum, currentMin);
        }

        // Step 3: If all numbers are negative, max circular sum is not valid
        if (maxSum < 0) {
            return maxSum;
        }

        // Step 4: Return the maximum of normal and circular sum
        return Math.max(maxSum, totalSum - minSum);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}



Maximum Sum Circular Array
You are given a circular array arr of size n. Your task is to find the maximum possible sum of a non-empty subarray of arr.

Input Format
First line contains an integer n, which is the size of arr

Second line contains n space separated integers of arr

Output Format
Complete the function MaxSum() and return the required sum.

Example 1
Input

4
1 -2 3 -2
Output

3
Example 2
Input

3
1 -3 1
Output

2
Constraints
1 <= n <= 104

-104 <= arr[i] <= 104

Topics
Dynamic Programming
Arrays
Companies
Amazon
Microsoft
