import java.io.*;
import java.util.*;

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Solution s = new Solution();
        int ans[] = s.stockSpan(a);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    // Function to calculate stock span for each day
    static int[] stockSpan(int[] a) {
        int n = a.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Calculate span for a[i]
            // Pop elements from the stack while the element at stack.peek() is less than or equal to a[i]
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            
            // If the stack is empty, it means the current price is greater than all previous prices
            if (stack.isEmpty()) {
                span[i] = i + 1; // Span is the current index + 1
            } else {
                // Otherwise, the span is the difference between the current index and the index of the last greater element
                span[i] = i - stack.peek();
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return span;
    }
}





Stock Span Problem
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days.

The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day(including), for which the price of the stock on the current day is less than or equal to its price on the given day.

For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Explanation to the given example:

On 0th day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

On 1st day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

On 2nd day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

Now on 3rd day we observe that stock price for last two consecutive days is less than or equal to current day i.e. (60, 70) thus count is 2

On 4th day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

On 5th day we observe that stock price for last four consecutive days is less than or equal to current day i.e. (60, 70, 60, 75) thus count is 4.

On 6th day we observe that stock price for last six consecutive days is less than or equal to current day i.e. (80, 60, 70, 60, 75, 85) thus count is 6.

Input Format
line 1: contains an integer n denoting size of array.

line 2: contains n separated integers denoting elements of array.

Output Format
Print n space separated integers denoting span value of ith day where i=0,1,....n-1.

Example 1
Input

7
100 80 60 70 60 75 85
Output

1 1 1 2 1 4 6
Explanation

On 0th day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

On 1st day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

On 2nd day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

Now on 3rd day we observe that stock price for last two consecutive days is less than or equal to current day i.e. (60, 70) thus count is 2

On 4th day only the current day where we find that stock price is less than or equal to it so for 1 consecutive day(current day) this happens.

On 5th day we observe that stock price for last four consecutive days is less than or equal to current day i.e. (60, 70, 60, 75) thus count is 4.

On 6th day we observe that stock price for last six consecutive days is less than or equal to current day i.e. (80, 60, 70, 60, 75, 85) thus count is 6.

Constraints
1 ≤ n ≤ 100000

1 ≤ arr[i] ≤ 100000

Topics
Stacks
Companies
Samsung
Amazon
Adobe
Flipkart
Microsoft
Accolite
