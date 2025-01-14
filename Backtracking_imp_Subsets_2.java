import java.io.*;
import java.util.*;

class Solution {
    static int[][] solve(int n, int[] nums) {
        // Step 1: Sort the input array to handle duplicates and ensure subsets are lexicographically sorted
        Arrays.sort(nums);

        // Step 2: Use a list of lists to store subsets
        List<List<Integer>> subsets = new ArrayList<>();

        // Step 3: Backtracking function to generate all subsets
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        // Step 4: Convert list of subsets to 2D array for output
        int[][] result = new int[subsets.size()][];
        for (int i = 0; i < subsets.size(); i++) {
            List<Integer> subset = subsets.get(i);
            result[i] = subset.stream().mapToInt(Integer::intValue).toArray();
        }

        return result;
    }

    // Helper function for backtracking
    private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        // Add the current subset to the result list (except empty subset)
        if (!current.isEmpty()) {
            subsets.add(new ArrayList<>(current));
        }

        // Iterate through the array starting from 'index'
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in the current subset
            current.add(nums[i]);

            // Recurse with the next index
            generateSubsets(nums, i + 1, current, subsets);

            // Backtrack by removing the last element
            current.remove(current.size() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_nums = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i_nums = 0; i_nums < arr_nums.length; i_nums++) {
            nums[i_nums] = Integer.parseInt(arr_nums[i_nums]);
        }

        int[][] out_ = Solution.solve(n, nums);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
            System.out.print(out_[i_out_][0]);
            for (int j_out_ = 1; j_out_ < out_[i_out_].length; j_out_++) {
                System.out.print(" " + out_[i_out_][j_out_]);
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }
}





Subsets 2
Given an integer array nums that may contain duplicates, print all possible subsets (the power set).

The solution set must not contain duplicate subsets. Two subsets are considered the same if after sorting both arrays they both become equal. Print the subsets in sorted order and also prints subset in sorted order see the example for a better understanding Ignore null set

Input Format
Input consists of two lines

The first line contains 'n' the size of the array

The second line contains 'n' space-separated integers

Output Format
Print all the distinct subsets sorted in increasing order each being on a new line

Example 1
Input

3
2 1 2
Output

1
1 2
1 2 2
2
2 2
Explanation

All the distinct subsets of [1, 2, 2] are [1], [1, 2], [1, 2, 2], [2], [2, 2]

Example 2
Input

2
1 1
Output

1
1 1
Explanation

All the distinct subsets of [1, 1] are [1], [1, 1]

Constraints
1 <= nums.length <= 10

-10 <= nums[i] <= 10

Topics
Recursion
Companies
Facebook
Amazon
Swiggy
Apple
