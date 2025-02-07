import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start time using Arrays.sort()
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]); // Push the first interval onto the stack

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i]; // Get the current interval
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            // Peek the last interval from the stack
            int[] topInterval = st.peek();
            int lastStart = topInterval[0];
            int lastEnd = topInterval[1];

            // If the intervals overlap, merge them
            if (lastEnd >= currentStart) {
                st.peek()[1] = Math.max(lastEnd, currentEnd);
            } else {
                // Otherwise, push the new interval
                st.push(currentInterval);
            }
        }

        // Convert the stack into an array
        int[][] ans = new int[st.size()][2];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans; // Return the merged intervals
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); 
        int[][] A = new int[m][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        Solution Obj = new Solution();
        int[][] result = Obj.merge(A); // Store the merged intervals

        // Print the merged intervals
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
}





Merge Intervals
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.

Input Format
First line contains an integer n denoting number of intervals.

Next n lines contain the two integers, representing the start and end intervals.

Output Format
Print the merged intervals, each interval in a new line.

Example 1
Input

4
1 3
2 4
6 8
9 10
Output

1 4
6 8
9 10
Explanation

Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].

Example 2
Input

4
6 8
1 9
2 4
6 7
Output

1 9
Constraints
1 <= n <= 10000

Topics
Arrays
Sorting
Companies
ServiceNow
Visa
Reddit
Intuit
Twilio
Facebook
ByteDance
Zillow
DoorDash
Amazon
Zulily
IBM
Tiktok
Robinhood
Paypal
Hotstar
Houzz
Goldman Sachs
Square
Wish
Twitter
Tesla
Shopee
JP Morgan
Bloomberg
Nutanix
Oracle
Adobe
BlackRock
Two Sigma
Cisco
Palantir Technologies
VMware
Apple
Coupang
Tableau
Uber
Grab
Snapchat
Google
Walmart Global Tech
Microsoft
Morgan Stanley
LinkedIn
Audible
Salesforce
Netflix
