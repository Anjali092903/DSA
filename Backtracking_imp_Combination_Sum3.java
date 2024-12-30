import java.util.*;

// Class to implement the solution for the combination sum problem
class Solution {
    // Method to find all combinations of k numbers that sum up to n
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>(); // List to store the final combinations
        backtrack(result, new ArrayList<>(), k, n, 1); // Start backtracking from number 1
        return result;
    }

    // Helper method to perform backtracking
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        // If the combination is valid (k numbers and the sum equals n)
        if (tempList.size() == k && remain == 0) {
            result.add(new ArrayList<>(tempList)); // Add the current combination to the result
            return;
        }
        // If the combination is invalid (more than k numbers or sum exceeds n)
        if (tempList.size() >= k || remain < 0) {
            return;
        }
        // Iterate through numbers from start to 9 to build combinations
        for (int i = start; i <= 9; i++) {
            tempList.add(i); // Add the current number to the temporary list
            backtrack(result, tempList, k, remain - i, i + 1); // Recurse with the updated list and remaining sum
            tempList.remove(tempList.size() - 1); // Backtrack by removing the last added number
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner to take input from the user
        int k = sc.nextInt(); // Number of elements in each combination
        int n = sc.nextInt(); // Target sum for the combinations

        Solution ob = new Solution(); // Create an instance of the Solution class
        List<List<Integer>> ans = ob.combinationSum3(k, n); // Get all valid combinations

        // Sort each combination for consistent ordering
        for (int i = 0; i < ans.size(); ++i) {
            Collections.sort(ans.get(i));
        }

        // Sort the list of combinations based on their numerical values
        Collections.sort(ans, (o1, o2) -> {
            int m = Math.min(o1.size(), o2.size());
            for (int i = 0; i < m; i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i); // Compare based on element values
                }
            }
            return o1.size() - o2.size(); // Compare based on size if all elements are equal
        });

        // Print each combination in a formatted manner
        for (List<Integer> combination : ans) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner to release resources
    }
}





Combination Sum 3
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers `1` through `9` are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Input Format
Input is managed for you. (You are given k and n in the combinationSum3() function).

Output Format
Output is managed for you. (You can return the possible valid combinations in any order. The combinations will be automatically printed in sorted order).

Example 1
Input

3 8
Output

1 2 5 
1 3 4 
Explanation

Here all these combinations have sum equal to 8.

(1 2 5) 
(1 3 4)
Example 2
Input

4 10
Output

1 2 3 4
Explanation

Here all these combinations have sum equal to 10.

(1 2 3 4)
Constraints
2 <= k <= 9

1 <= n <= 60

Topics
Recursion
Arrays
Companies
Amazon
Adobe
Google
Microsoft
Netflix
