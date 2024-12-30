import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array for better organization (optional)
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain == 0) { // If target is achieved, add the combination to result
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (remain < 0) { // If target is exceeded, backtrack
            return;
        }
        for (int i = start; i < nums.length; i++) { // Iterate through numbers
            tempList.add(nums[i]); // Choose the current number
            backtrack(result, tempList, nums, remain - nums[i], i); // Recursive call with updated target
            tempList.remove(tempList.size() - 1); // Backtrack: Remove the last added number
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum(nums, target);

        // Sort each combination
        for (int i = 0; i < ans.size(); ++i) {
            Collections.sort(ans.get(i));
        }

        // Sort the combinations lexicographically
        Collections.sort(ans, (o1, o2) -> {
            int m = Math.min(o1.size(), o2.size());
            for (int i = 0; i < m; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return o1.size() - o2.size(); // In case of equal combinations, compare by size
        });

        // Print the results
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}






Combination Sum
Given an array of distinct integers nums and a target integer target, return a list of all unique combinations of nums where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from nums an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Input Format
Input is managed for you. (You are given an array nums and target target in the combinationSum() function).

Output Format
Output is managed for you. (You can return the possible valid combinations in any order. The combinations will be automatically printed in sorted order).

Example 1
Input

4 16
6 2 7 5
Output

2 2 2 2 2 2 2 2 
2 2 2 2 2 6 
2 2 2 5 5 
2 2 5 7 
2 2 6 6 
2 7 7 
5 5 6 
Explanation

Here all these combinations have sum equal to 16.

(2 2 2 2 2 2 2 2)
(2 2 2 2 2 6)
(2 2 2 5 5)
(2 2 5 7)
(2 2 6 6)
(2 7 7)
(5 5 6)
Example 2
Input

3 5
1 2 3
Output

1 1 1 1 1 
1 1 1 2 
1 1 3 
1 2 2 
2 3 
Explanation

Here all these combinations have sum equal to 5.

(1 1 1 1 1) 
(1 1 1 2) 
(1 1 3) 
(1 2 2) 
(2 3)
Constraints
1 <= nums.length <= 30

2 <= nums[i] <= 40

All elements of nums are distinct

1 <= target <= 40

Topics
Recursion
Arrays
