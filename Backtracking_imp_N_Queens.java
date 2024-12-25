import java.util.*;

public class Main {
    /**
     * Function to calculate the total number of distinct solutions to the N-Queens problem.
     * @param n The size of the chessboard (n x n) and the number of queens to place.
     * @return The total number of distinct solutions.
     */
    public static int totalNQueens(int n) {
        // Initialize variables to keep track of the solutions
        int[] count = new int[1]; // Use an array to track the count across recursive calls
        boolean[] cols = new boolean[n]; // Tracks columns where queens are placed
        boolean[] diag1 = new boolean[2 * n]; // Tracks the primary diagonals
        boolean[] diag2 = new boolean[2 * n]; // Tracks the secondary diagonals

        // Start the backtracking process from row 0
        solveNQueens(n, 0, cols, diag1, diag2, count);

        // Return the total number of solutions
        return count[0];
    }

    /**
     * Helper function for backtracking to place queens.
     * @param n The size of the chessboard.
     * @param row The current row being processed.
     * @param cols Array tracking used columns.
     * @param diag1 Array tracking used primary diagonals.
     * @param diag2 Array tracking used secondary diagonals.
     * @param count Array tracking the total number of solutions.
     */
    public static void solveNQueens(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int[] count) {
        // Base case: All rows are processed, a solution is found
        if (row == n) {
            count[0]++;
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // Index for primary diagonal
            int d2 = row + col;     // Index for secondary diagonal

            // Check if the current cell is under attack
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place the queen and mark the cell
            cols[col] = diag1[d1] = diag2[d2] = true;

            // Recur to place queens in the next row
            solveNQueens(n, row + 1, cols, diag1, diag2, count);

            // Backtrack: Remove the queen and unmark the cell
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalNQueens(n));
    }
}






N Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other. Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Your task is to complete the function totalNQueens which receives n as a parameter and returns the number of distinct solutions.

Input Format
Single line of input contains the number n.

Output Format
Single line of output contains the number of distinct solutions.

Example 1
Input

1
Output

1
Explanation Since there is a single block, only one configuration is possible.

Example 2
Input

4
Output

2
Explanation

Only these two configurations are possible

XOXX      XXOX
XXXO      OXXX
OXXX      XXXO
XXOX      XOXX

Where 'X' represent empty and 'O' represents Queen.
Constraints:
1 <= n <= 10

Topics
Recursion
Companies
Visa
Amazon
Twitter
MAQ Software
Amdocs
DE Shaw
Microsoft
Accolite
