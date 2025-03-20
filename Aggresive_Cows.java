import java.io.*;
import java.util.*;

class Solution {
    public static int aggressiveCows(int a[], int cows) {
        // Step 1: Sort the stall positions
        Arrays.sort(a);
        
        // Step 2: Define search space
        int left = 1; // Minimum possible distance
        int right = a[a.length - 1] - a[0]; // Maximum possible distance
        int result = 0;

        // Step 3: Binary search on the answer
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if it's possible to place cows with at least 'mid' distance
            if (canPlaceCows(a, cows, mid)) {
                result = mid;  // Update result to mid (valid answer)
                left = mid + 1; // Try a larger distance
            } else {
                right = mid - 1; // Try a smaller distance
            }
        }
        
        return result; // Return the largest minimum distance
    }

    // Helper function to check if we can place cows with at least 'dist' apart
    private static boolean canPlaceCows(int a[], int cows, int dist) {
        int count = 1; // Place the first cow in the first stall
        int lastPos = a[0]; // Position of the last placed cow

        for (int i = 1; i < a.length; i++) {
            if (a[i] - lastPos >= dist) {
                count++; // Place a cow
                lastPos = a[i]; // Update the last placed position
                if (count == cows) return true; // All cows placed
            }
        }

        return false; // Not enough cows placed
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of stalls
        int k = sc.nextInt(); // Number of cows
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(nums, k)); // Output the result
    }
}






Aggresive Cows
Given an array of length N, where each element denotes the position of a stall. You are also given an integer K which denotes the number of cows that are aggressive. To prevent the cows from hurting each other, you need to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. Return the largest minimum distance.

Input Format
The first line contains 'N' and 'K' denoting the number of elements in the array/list and the number of aggresive cows.

The second line contains 'N' single space-separated integers denoting the elements of the array.

"NOTE: " You do not need to print anything; it has already been taken care of.

Just Complete the funtion.

Output Format
Print the majority element.

Example 1
Input

3 2
1 2 3
Output:

2
Explanation:

The largest minimum distance will be 2 when 2 cows are placed at positions {1,3}.

Example 2
Input

6 4
0 3 4 7 10 9
Output:

3
Explanation:

The largest distance will be 3 when 4 cows are placed at positions {0,3,7,10}.

Constraints
2<=N<=20000

2<=C<=N

0<=arr[i]<=10^9

Topics
Binary Search
Sorting
Companies
Amazon
Goldman Sachs
Infosys
Adobe
Dunzo
Sharechat
