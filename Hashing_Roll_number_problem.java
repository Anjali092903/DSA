import java.util.*;

class Solution {
    static int[] findRepeatingAndMissingNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int repeating = -1, missing = -1;

        // Step 1: Count occurrences of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the missing and repeating numbers
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                missing = i; // Number not found -> Missing number
            } else if (map.get(i) == 2) {
                repeating = i; // Number appears twice -> Repeating number
            }
        }

        return new int[]{repeating, missing};
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = Solution.findRepeatingAndMissingNumbers(nums);
        System.out.println(ans[0] + " " + ans[1]);
    }
}





Roll number problem
You are given roll number of students in the form of an array nums consisting of first N positive integers. But in the array of N integers, one of the roll number occurs twice, and one of the roll number is missing. You need to determine the repeating and the missing roll number.

Input Format
The first line contains an integer N denoting the number of elements present in the array.

The second line contains N space-separated integers denoting the elements present in the array.

Output Format
Print the two space-separated integers denoting the repeating and the missing numbers, in the same order.

Example 1
Input

5
1 4 2 5 2
Output

2 3
Explanation

We have, array: [1, 4, 2, 5, 2] and N = 5. In the given array ‘2’ occurs twice and the number ‘3’ is missing. Hence, we output 2 and 3 for the repeating and the missing number, respectively.

Example 2
Input

2
2 2
Output

2 1
Explanation

We have, array: [2, 2] and N = 2. In the given array ‘2’ occurs twice and the number ‘1’ is missing. Hence, we output 2 and 1 for the repeating and the missing number, respectively.

Constraints
2 <= N <= 10^5

1 <= nums[i] <= N
