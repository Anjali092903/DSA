import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here
          // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> freqMap = new HashMap<>();

         // Traverse the array
        for (int i = 0; i < n; i++) {
            // Get the current number
            int num = nums[i];
            
            // Update the frequency in the HashMap
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

             // Check if the frequency of the current number is >= k
            if (freqMap.get(num) >= k) {
                System.out.print(num); // Print the number
                return; // Exit as we found the first element satisfying the condition
            }
        }
        
        // If no element satisfies the condition, print -1
        System.out.print(-1);
        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}



First Element to Occur K Times
Given an array of 'n' integers. Print the first element that occurs k number of times. If there is no element that occurs for at least k number of times print -1.

Input Format
Line 1: contains two integers n and k.

Line 2: contains n-spaced integers denoting elements of the array.

Output Format
Print a single integer denoting the first element in the array which occurs at least k times. If no such element exists, print -1.

Example 1
Input

7 2
1 7 4 3 4 8 7
Output

4
Explanation

As we traverse the array the first number whose frequency becomes greater than or equal to k(2) is 4. Hence, the answer is 4.

Example 2
Input

7 4
2 4 1 2 2 19 3
Output

-1
Explanation

As no element in array has a frequency greater than or equal to k(4), the output will be -1.

Constraints
1 <= n <= 10^6

1 <= arr[i] <= 10^6

Topics
Hashing
