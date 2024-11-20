import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input the size of the array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input the elements of the array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find the maximum element using recursion
        int result = findMax(nums, 0);
        System.out.println(result);

        sc.close();
    }

    // Recursive function to find the maximum element
    public static int findMax(int[] arr, int index) {
        // Base case: If we're at the last element, return it
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursively find the maximum of the rest of the array
        int maxFromRest = findMax(arr, index + 1);

        // Compare the current element with the max from the rest
        if (arr[index] > maxFromRest) {
            return arr[index];
        } else {
            return maxFromRest;
        }
    }
}







Maximum of Array
You are given an array arr of length n. You have to find the maximum element of the array.

Note

You have to use Recursion.

Input Format
The first line of input contains an integer n, size of the array.

The next line contains n space seperated integers denoting the elements of the array.

Output Format
Print single integer representing maximum of the given array

Example 1
Input

3
2 3 10
Output

10
Explanation

10 is maximum among 2,3 and 10.

Example 2
Input

4
1 3 5 7
Output

7
Explanation

7 is maximum among 1,3,5 and 7.

Constraints
0 <= nums.length <= 100

0 <= nums[i] <= 100000

Topics
Recursion
Arrays
