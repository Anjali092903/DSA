import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] A = new int[n];
                int m = sc.nextInt();
                int k = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextInt();
                }
                Solution ob = new Solution();
                int ans = ob.minDays(A, n, m, k);
                System.out.println(ans);
                t--;
            }
        }
    }
}

class Solution {
    public int minDays(int[] bloomDay, int n, int m, int k) {
        // If it's impossible to make the cakes
        if (m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Determine the range of days
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int result = -1;

        // Binary search to find the minimum day
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeCakes(bloomDay, n, m, k, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try for earlier days
            } else {
                low = mid + 1; // Try for later days
            }
        }

        return result;
    }

    private boolean canMakeCakes(int[] bloomDay, int n, int m, int k, int day) {
        int count = 0; // Consecutive available flavors
        int cakes = 0; // Total cakes made

        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                count++;
                if (count == k) {
                    cakes++;
                    count = 0; // Reset after making a cake
                    if (cakes == m) {
                        return true; // Successfully made all required cakes
                    }
                }
            } else {
                count = 0; // Reset count if flavor is not available
            }
        }

        return false; // Not enough cakes could be made
    }
}





Minimum time to make Cakes
Given an array 'A' with 'N' positive integers, an integer 'M' and an integer 'K'.

Integer M denotes the number of cake to be made. The array denotes that the ith flavour will be available on A[i]th day.

To make a cake you need to select k consecutive flavours. Each flavour can only be used in 1 cake.

Your task is to calculate the minimum number of days in which the cakes can be made. If it is not possible to make the cake then print -1.

Input Formaat
The first line contains the number of test cases.

For each test case: The first line contains an integer 'N' denoting the number of elements, integer 'M' denoting number of cakes to be made, integer 'K' denoting a cake can be made using k consecutive flavours.

The second line contains N space separated integers denoting the elements of the array 'A'.

Output Format
For each test case print an integer in a new line, denoting the minimum time to build all the m cakes.

Example 1
Input:

1
5 3 1
1 10 3 10 2
Output:

3
Explanation:

We analyse for 3 days. A means flavour is available and N means not available.

We need 3 cakes each should contain 1 flavour.

After day 1: [A, N, N, N, N] // we can only make one cake.

After day 2: [A, N, N, N, A] // we can only make two cake.

After day 3: [A, N, A, N, A] // we can make 3 cake.

The answer is 3.

Example 2
Input:

1
5 1 2
1 10 3 10 2
Output:

10
Explanation:

We analyse for 10 days. A means flavour is available and N means not available.

We need 1 cakes each should contain 2 flavour.

After day 1: [A, N, N, N, N] // we can make no cake.

After day 2: [A, N, N, N, A] // we can make no cake.

After day 3: [A, N, A, N, A] // we can make no cake.

The array reamins same till day 9.

After day 3: [A, A, A, A, A] // we can make 1 cake.

The answer is 10.

Constraints
1 <= T <= 10

3 <= N <= 1000

3 <= M <= 10000

1 <= K <= N

0 <= A[i] <= 10000

Topics
Binary Search
Arrays
