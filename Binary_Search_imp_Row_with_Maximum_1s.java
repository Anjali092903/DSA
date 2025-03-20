import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of rows
        int m = sc.nextInt(); // Number of columns
        int[][] arr = new int[n][m];

        // Read the matrix input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr, n, m));

        sc.close();
    }
}

class Solution {
    // Function to find the row index with the maximum number of 1s
    static int rowWithMaximumOnes(int arr[][], int n, int m) {
        int maxOnesRow = -1;  // Default value (if no 1s are found)
        int maxOnes = 0;      // Track the maximum number of 1s found
       
        for (int i = 0; i < n; i++) {
            int firstOneIndex = firstOccurrenceOfOne(arr[i], m); // Find first 1 using binary search

            // Calculate number of 1s in this row
            int onesCount = m - firstOneIndex;

            // Update if the current row has more 1s than previous rows
            if (firstOneIndex < m && onesCount > maxOnes) {
                maxOnes = onesCount;
                maxOnesRow = i; // Update the row index
            }
        }

        return maxOnesRow;
    }

    // Binary Search to find the first occurrence of 1 in a sorted row
    private static int firstOccurrenceOfOne(int[] row, int m) {
        int low = 0, high = m - 1;
        int firstOnePos = m;  // Default: If no 1 is found, return m (out of bounds)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {
                firstOnePos = mid; // Found a 1, update the index
                high = mid - 1; // Move left to find the first occurrence
            } else {
                low = mid + 1; // Move right if mid is 0
            }
        }

        return firstOnePos; // Index of first 1, or m if no 1 is found
    }
}


Row with Maximum 1's
You have been given a non-empty grid MAT with N rows and M columns consisting of only 0s and 1s. All the rows are sorted in ascending order.

Your task is to find the index of the row that has the maximum number of ones.

Note: If two rows have the same number of ones, consider the one with a smaller index.

Input Format
The first input line contains two space separated integers N and M representing the number of rows and columns of the grid, respectively.

From the second line, the next N lines represent the rows of the grid. Every row contains M single space-separated integers.

Output Format
Print the index of the row with the maximum number of ones.

Example 1
Input

2 2
1 1
1 1
Output:

0
Explanation For the given grid, both rows have an equal number of ones. Since the row with index 0 has a smaller index. Hence the answer is 0.

Example 2
Input

3 4
0 0 1 1
0 0 0 1
0 1 1 1
Output:

2
Explanation For the given grid, third row has highest number of 1s. So, output is 2 (0 based index).

Constraints
1 <= N <= 500

1 <= M <= 500

0 <= MAT[i][j] <= 1

Topics
Binary Search
2D-Arrays
Companies
Amazon
