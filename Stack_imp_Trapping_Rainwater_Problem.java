import java.util.*;

class Solution {
    public void TappingWater(int[] arr, int n) {
        if (n == 0) {
            System.out.println(0);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            // Process bars that can trap water
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int top = stack.pop(); // Remove the top element
                
                if (stack.isEmpty()) break; // No left boundary

                int leftIndex = stack.peek(); // Left boundary index
                int width = i - leftIndex - 1; // Distance between left and current bar
                int boundedHeight = Math.min(arr[leftIndex], arr[i]) - arr[top]; // Height of trapped water

                totalWater += width * boundedHeight; // Calculate trapped water
            }
            stack.push(i); // Push current index onto stack
        }
        System.out.println(totalWater); // Print the total trapped water
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }

        Solution Obj = new Solution();
        Obj.TappingWater(arr, n); 
        sc.close();
    }
}




Trapping Rainwater Problem
Given n non-negative integers representing an elevation map where the width of each bar is 1. Compute how much water it can trap after rain.

Input Format:
The first line contains one integer input n, the size of the array.

The second line contains n space-separated integers (arr[i]) that describe the width of each bar.

Output Format:
Prints a single integer value, which represents the amount of water it can hold.

Example 1:


Input:

12
0 1 0 2 1 0 1 3 2 1 2 1
Output:

6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input:

6
4 2 0 3 2 5
Output:

9
Explanation: In this case, 9 units of rainwater will be trapped.

Constraints:
n == height.length

1 <= n <= 2 * 10^4

0 <= arr[i] <= 10^5

Topics
Dynamic Programming
2-Pointers
Arrays
Companies
ServiceNow
Visa
Citadel
Facebook
ByteDance
Zillow
Amazon
Tiktok
Robinhood
Paypal
Goldman Sachs
Airbnb
Twitter
Qualtrics
Tesla
Intel
Bloomberg
Oracle
Adobe
Rubrik
Cisco
Lyft
Swiggy
Flipkart
VMware
C3 IoT
Apple
Databricks
Twitch
Coupang
Sapient
Myntra
Uber
Grab
DE Shaw
Snapchat
Google
Walmart Global Tech
Microsoft
Morgan Stanley
eBay
National Instruments
Yandex
Accolite
Yahoo
Expedia
