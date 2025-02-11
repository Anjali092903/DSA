import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a) {
        int totalSum = 0, leftSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        // Compute total sum of array
        for (int num : a) {
            totalSum += num;
        }

        // Iterate through the array and use HashMap for prefix sum tracking
        for (int i = 0; i < a.length; i++) {
            int rightSum = totalSum - leftSum - a[i];

            // Check if equilibrium condition is met
            if (leftSum == rightSum) {
                return i; // Return index if equilibrium found
            }

            // Store leftSum in HashMap
            prefixMap.put(i, leftSum);
            leftSum += a[i]; // Update leftSum
        }

        return -1; // No equilibrium index found
    }
}




Equilibrium Index
Given an array of size n, find the equilibrium index in the array, or return -1 if it does not exist.

The equilibrium index is that index such that the sum of elements at lower indices is equal to sum of elements at higher indices.

complete the function that returns the equilibrium index given an array.

Input Format
The first line of the input contains one integer n, denoting the size of the array arr.

The second line of the input contains the elements of the array arr.

Output Format
Your code should output the equilibrium index if it exists, else output -1.

Example 1
Input

4
2 3 1 1
Output

1
Explanation

The value at index 1 is 3, we can see that sum of elements left of 3 is 2 and sum of elements right of 3 is 1+1=2 therefore 3 is the equilibrium index.

Example 2
Input

3
3 3 4
Output

-1
Explanation

there is no index for which leftsum is equal to rightsum therefore value is -1

Example 3
Input

1
2
Output

0
Explanation

As sum left of index 0 is 0 and right of index 0 is 0 as there is only one element. the equilibrium index is 0.

Constraints
1 <= n <= 2*10^5

0 <= arr[i] <= 1000
Topics
Arrays
Prefix Sum
Companies
Amazon
Adobe
