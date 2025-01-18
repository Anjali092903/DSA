import java.util.*;
import java.io.*;
class Solution {
    // Method to solve the problem of minimizing penalty
    public static int solve(int n, int m, int arr[]) {
        // 1 as the minimum possible penalty (smallest size of a bag)
        // `high` as the maximum element in the array (largest bag size)
        int low = 1, high = Arrays.stream(arr).max().getAsInt(), result = high;

        // Perform binary search to find the minimum penalty
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle penalty value
            
            // Check if it's possible to achieve `mid` as the max bag size
            if (canDivide(arr, n, m, mid)) {
                result = mid; // Update result since `mid` is feasible
                high = mid - 1; // Try for smaller penalties
            } else {
                low = mid + 1; // Increase penalty to make division feasible
            }
        }
        return result; // Return the minimum penalty found
    }

    // Helper method to determine if the bags can be divided such that 
    // no bag has more than `maxPenalty` balls, within `maxOperations`
    private static boolean canDivide(int[] arr, int n, int maxOperations, int maxPenalty) {
        int operations = 0; // Count the total number of operations needed

        // Iterate through each bag in the array
        for (int balls : arr) {
            // If the current bag size exceeds `maxPenalty`, calculate how many splits are needed
            if (balls > maxPenalty) {
                operations += (balls - 1) / maxPenalty; // Calculate splits
            }

            // If the number of required operations exceeds the allowed operations, return false
            if (operations > maxOperations) return false;
        }
        return true; // Return true if feasible within the allowed operations
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        System.out.println(Solution.solve(n, m, arr));
    }
}




Minimum Limit of Balls in a Bag
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.

For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.

Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Print the minimum possible penalty after performing the operations.

Input Format
The first line of the input contains the number 𝑛(length of the array) and m(maximum number of operations).

The next n integers denote the elements of the array.

Output Format
Print the minimum penalty possible after performing at most m operations.

Example 1
Input

1 2
9
Output

3 
Explanation

Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].

Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].

The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.

Example 2
Input

4 4
2 4 8 2
Output

2
Explanation

Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].

Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].

Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].

Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].

The bag with the most number of balls has 2 balls, so your penalty is 2 an you should return 2.

Constraints:
1 <= nums.length <= 10^5

1 <= maxOperations, nums[i] <= 10^9

Topics
Binary Search
Companies
Wipro
TCS
Flipkart
