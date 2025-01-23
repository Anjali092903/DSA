import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    public int maxLen(int arr[]) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int maxLength = 0;
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // Check if cumulative sum is 0
            if (cumulativeSum == 0) {
                maxLength = i + 1; // Update maxLength to the current index + 1
            }

            // If cumulative sum has been seen before
            if (sumMap.containsKey(cumulativeSum)) {
                // Calculate the length of the subarray
                int length = i - sumMap.get(cumulativeSum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Store the cumulative sum with its index
                sumMap.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }
}

class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxLen(nums));
    }
}



Largest Subarray with 0 Sum
Given an array arr[] of length N, find the length of the longest sub-array with a sum equal to 0.

A subarray is a contiguous part of the array.

Complete the given function.

Input Format:
First line contains integer N

Second line contains n integers arr[i].

Output Format:
Print the longest subarray length with a sum equal to 0.

EXAMPLE 1:
Input:

8
15 -2  2 -8 1 7 10 23
Output:

5
Explanation:

The longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}

EXAMPLE 2:
Input:

3
1 2 3
Output:

0
Explanation:

There is no subarray with 0 sum

constraints:
-100000 <= nums.length <= 100000

0 <= nums[i] <= 100000
Topics
Arrays
Companies
Amazon
MakeMyTrip
Microsoft
