import java.util.*;
import java.io.*;

public class Main {
    static int sorting4(int n, int[] arr, int l) {
        Arrays.sort(arr); // Sort the points
        int count = 0;

        for (int i = 0; i < n - 2; i++) { // Fix the first point
            int j = i + 1, k = i + 2;

            // Move `k` to find the maximum valid range
            while (k < n && arr[k] - arr[i] <= l) {
                k++;
            }

            // Calculate the number of valid triplets in the range [i, k-1]
            int totalPoints = k - i;
            if (totalPoints >= 3) {
                int combinations = (totalPoints - 1) * (totalPoints - 2) / 2;
                count += combinations;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        int[] arr = new int[n];

        inputLine = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        inputLine = br.readLine().trim().split(" ");
        int l = Integer.parseInt(inputLine[0]);

        int ans = sorting4(n, arr, l);
        System.out.println(ans);
    }
}





AS Sorting 4
Given a set of N distinct points lying on the X-axis and an integer L, the task is to find the number of ways of selecting three points such that the distance between the most distant points is less than or equal to L

Input Format
The first line contains integer N denoting the number of points

The second line contains N integers denoting the points

The third line contains L denoting the maximum distance possible

Output Format
Print the count of the total ways of selecting three points

Example 1
Input

4
2 1 3 4
3
Output

4
Explanation

{1, 2, 3} Here distance between farthest points = 3 – 1 = 2 <= L

{1, 2, 4} Here distance between farthest points = 4 – 1 = 3 <= L

{1, 3, 4} Here distance between farthest points = 4 – 1 = 3 <= L

{2, 3, 4} Here distance between farthest points = 4 – 2 = 2 <= L

Example 2
Input

4
2 1 3 4
2
Output

2
Explanation

{1, 2, 3} Here distance between farthest points = 3 – 1 = 2 <= L

{2, 3, 4} Here distance between farthest points = 4 – 2 = 2 <= L

Constraints
1 <= N <= 100

0 <= points <= 1000

1 <= L <= 500

Topics
Arrays
Array - Basics
Sorting
