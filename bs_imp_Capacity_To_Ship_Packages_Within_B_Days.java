import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static long solve(int[] A, int B) {
        // Determine the range for binary search
        int maxWeight = 0;
        long totalWeight = 0;
        for (int weight : A) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        long lo = maxWeight, hi = totalWeight;
        long result = hi;

        // Binary search to find the minimum capacity
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (canShipInBDays(A, B, mid)) {
                result = mid; // Update result if feasible
                hi = mid - 1; // Try for smaller capacity
            } else {
                lo = mid + 1; // Increase capacity
            }
        }

        return result;
    }

    private static boolean canShipInBDays(int[] A, int B, long capacity) {
        long currentWeight = 0;
        int daysNeeded = 1; // At least one day is needed

        for (int weight : A) {
            if (currentWeight + weight > capacity) {
                // Start a new day
                daysNeeded++;
                currentWeight = weight;

                // If more days are needed than allowed, return false
                if (daysNeeded > B) {
                    return false;
                }
            } else {
                // Add the package to the current day
                currentWeight += weight;
            }
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A, B));
    }
}





Capacity To Ship Packages Within B Days
A conveyor belt has packages that must be shipped from one port to another within B days.

The ith package on the conveyor belt has a weight of A[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Print the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within B days.

You have to complete solve function which contains array A and integer B days and you have to return integer answer which represents least weight capacity of ship

Input Format
The first line contains an integer n — the length of array A.

The second line contains n integers A1,A2,…,An — elements of array A.

The third line contains the integer B denoting the number of days.

Output Format
Print the least weight capacity of the ship.

Example 1
Input

 10
 1 2 3 4 5 6 7 8 9 10
 5
Output

15
Explanation

A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:

1st day: 1, 2, 3, 4, 5

2nd day: 6, 7

3rd day: 8

4th day: 9

5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2
Input

 6
 3 2 2 4 1 4
 3
Output

6
Explanation

A ship capacity of 6 is the minimum to ship all the packages in 3 days like this: 1st day: 3, 2

2nd day: 2, 4

3rd day: 1, 4

Constraints
1 <= B <= |A| <= 5 * 10^5

1 <= A[i] <= 10^5

Topics
Binary Search
Companies
Amazon
