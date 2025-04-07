import java.util.*;

class Solution {
    public boolean RangeCheck(int[][] intervals, int a, int b) {
        int[] coverage = new int[52]; // up to 51 (to handle end+1 safely)

        // Optional: PriorityQueue to sort intervals by start
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int[] interval : intervals) {
            pq.add(interval);
        }

        while (!pq.isEmpty()) {
            int[] range = pq.poll();
            int start = range[0], end = range[1];
            coverage[start] += 1;
            if (end + 1 <= 51) {
                coverage[end + 1] -= 1;
            }
        }

        // Build prefix sum
        for (int i = 1; i <= 51; i++) {
            coverage[i] += coverage[i - 1];
        }

        // Check if all numbers in [a, b] are covered
        for (int i = a; i <= b; i++) {
            if (coverage[i] == 0) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.RangeCheck(intervals, a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}







Range Check
You are given a 2D array intervals of size n x 2. Each intervals[i] = [start, end] represents an interval from start to end (both inclusive).

You are also given a range [a, b]. You need to find that all the integers in between a and b(both inclusive) are covered in atleast one of the interval of array intervals.

Return true is the condition is satisfied, else return false.

Input Format
First line contains an integer n, which is the number of intervals

Next n lines contains two space separated integers which represent the start and end of ith interval.

Last line contains two space separated integers which are a and b

Output Format
Complete the function RangeCheck() and return true or false according to the question

Example 1
Input

3
1 2
3 4
5 6
2 5
Output

true
Explanation

Every integer between 2 and 5 is covered:

2 is covered by the first range.
3 and 4 are covered by the second range.
5 is covered by the third range.
Example 2
Input

2
1 10
10 20
21 21
Output

false
Constraints
1 <= n <= 50

1 <= intervals[i][0] <= intervals[i][1] <= 50

1 <= a <= b <= 50

Topics
Coding
Arrays
Prefix Sum
Hashing
