import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        
        // Read the number of bars in the histogram
        long n = Long.parseLong(br.readLine().trim());

        // Read the heights of the bars
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(inputLine[i]);
        }

        // Print the maximum area
        System.out.println(new Solution().maximumArea(arr, n));
    }
}

class Solution {
    public static long maximumArea(long hist[], long n) {
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of histogram bars
        long maxArea = 0; // Variable to store the maximum area

        // Iterate through all bars, including one extra iteration for final processing
        for (int i = 0; i <= n; i++) {
            long currentHeight = (i == n) ? 0 : hist[i]; // Consider last element as height 0 to clear stack
            
            // Process when the stack is not empty and the current height is smaller
            while (!stack.isEmpty() && hist[stack.peek()] > currentHeight) {
                long height = hist[stack.pop()]; // Height of the popped element
                
                // Width calculation: If the stack is empty, width = i (full width)
                // Otherwise, width = i - (stack.peek() + 1) (distance between nearest smaller elements)
                long width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                // Calculate area and update maxArea
                maxArea = Math.max(maxArea, height * width);
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return maxArea;
    }
}



Largest Histogram Area
You are given a histogram of N bars. The height of each bar is given in the the array A. The width of each bar is 1. Find the largest rectangular area possible where the rectangles can be made of a number of contiguous bars.

Note Complete the given function. The input and output would be handled by the driver code.

Input Format
The first line contains N.

The second line contains elements of A.

Output Format
Print the maximum area.

Example 1
Input

4
1 2 3 1
Output

4
Explanation

The rectangle 1 1 1 1 is maximum possible.

Height = 1. Width is 1 * 4 = 4.

Area = 1 * 4 = 4.

Example 2
Input

3
2 2 2
Output

6
Explanation

The rectangle 2 2 2 is maximum possible.

Height = 2. Width is 1 * 3 = 3.

Area = 2 * 3 = 6.

Constraints
1 <= N <= 10000

1 <= A[i] <= 10000

Topics
Stacks
Arrays
Companies
Facebook
ByteDance
Amazon
TCS
Tiktok
Goldman Sachs
Bloomberg
Adobe
MAQ Software
Lyft
Flipkart
Apple
Uber
Snapchat
Google
Microsoft
eBay
Huawei
HBO
Nvidia
