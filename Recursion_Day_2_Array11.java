import java.util.*;

public class Main {
    static int array11(int[] nums, int index) {
        // Base case: If the index is out of bounds, return 0
        if (index == nums.length) {
            return 0;
        }
        // Check if the current element is 11
        int count = (nums[index] == 11) ? 1 : 0;     
       // Recursive call for the rest of the array
        return count + array11(nums, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the size of the array
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Print the result of the recursive function
        System.out.println(array11(arr, 0));
        
        sc.close();
    }
}








 // Check if the current element is 11
       int count;
      if (nums[index] == 11) {
            count = 1; // If the current element is 11, set count to 1
    } else {
      count = 0; // Otherwise, set count to 0
        }

alternate 
    int count = (nums[index] == 11) ? 1 : 0;




Array11
Given an array of integers. Compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in the index as 0.

array11([1, 2, 11], 0) → 1
array11([11, 11], 0) → 2
array11([1, 2, 3, 4], 0) → 0

Input Format
The first line contains the number n, the size of the array

The second line contains N integers

You need to complete the array11 function, which contains the nums array of size N and an integer index and finally returns the answer.

Output Format
Print the number of 11 in the array.

Example 1
Input

5
1 3 11 11 2
Output

2
Explanation

11 occur twice

Example 2
Input

6
1 8 9 12 11
Output

1
Explanation

11 occur once

Constraints
2 <= N <= 3000

0 <= A[i] <= 5000

Topics
Recursion
Arrays
