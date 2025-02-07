import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE; // This stores the potential "2" in the "132" pattern
        
        // Traverse from the right side to maintain a decreasing stack
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true; // Found a valid "132" pattern
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop(); // The last popped element is a potential "2"
            }
            stack.push(nums[i]); // Push the current number to stack
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        boolean result = obj.find132pattern(arr);

        System.out.println(result ? "true" : "false");

        sc.close();
    }
}




132 Pattern
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Input Format
Input consists of two lines.

First line contains an integer n which is the number of elements in nums.

Next line contains n spaced integers which represents the elements of nums.

Output Format
Return true if a 132 pattern is found otherwise return false.

Example 1
Input

4
1 2 3 4
Output

false
Explanation

There is no 132 pattern in the sequence.

Example 2
Input

4
3 1 4 2
Output

true
Explanation

There is a 132 pattern in the sequence: [1, 4, 2]

Example 3
Input

4
-1 3 2 0
Output

true
Explanation

There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

Constraints
1 <= n <= 2*10^5

-10^9 <= nums[i] <= 10^9

Topics
Stacks
Arrays
