import java.util.*;

public class Main {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = m * n - 1;

        // Treat the 2D matrix as a 1D array for binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate row and column from the mid index
            int row = mid / n;
            int col = mid % n;

            if (mat[row][col] == x) {
                return true; // Element found
            } else if (mat[row][col] < x) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return false; // Element not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        if (SearchA2DMatrix(mat, x)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}





Search A 2D Matrix
You are given a 2D matrix mat of size m x n. Each row of mat has elements sorted from left to right. Also the first(leftmost) element of each row is greater than the last(rightmost) element of previous row.

You are also given an integer x, Search for this x in mat, return true if x is present in mat, else return false.

Input Format
First line contains three space-separated integers m n, which is the size of matrix mat

Next m lines contains n space separated integers.

Last line contains a single integer x, which is to be searched in mat

Output Format
Return true or false, according to the conditions given above

Example 1
Input

3 4
1 3 5 7
10 11 16 20
23 30 34 60
10
Output

true
Explanation

x = 10, is present in middle row first column.

Example 2
Input

3 4
1 3 5 7
10 11 16 20
23 30 34 60
12
Output

false
Constraints
1 <= m, n <= 1000

-104 <= mat[i][j] <= 104

Topics
Conditionals
Binary Search
2D-Arrays
