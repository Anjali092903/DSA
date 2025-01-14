import java.util.*;

public class Main {

    // Directions of the knight's moves
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int N = 8; // The size of the chessboard

    // Helper method to check if a position is valid
    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    // Backtracking method to solve the Knight's Tour problem
    static boolean solveKTUtil(int x, int y, int movei, int[][] sol) {
        if (movei == N * N) {
            return true; // All cells are visited
        }

        // Try all 8 possible moves for the knight
        for (int k = 0; k < 8; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (isSafe(newX, newY, sol)) {
                sol[newX][newY] = movei; // Mark the cell as visited
                if (solveKTUtil(newX, newY, movei + 1, sol)) {
                    return true;
                }
                // Backtrack if no solution is found
                sol[newX][newY] = -1;
            }
        }
        return false; // No solution found
    }

    // Function to solve the Knight's Tour problem
    static int[][] findPath() {
        int[][] sol = new int[N][N];
        
        // Initialize all cells as unvisited (-1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        // Start from the first cell (0, 0)
        sol[0][0] = 0; // First move at (0, 0)

        // Try to solve the problem using backtracking
        if (!solveKTUtil(0, 0, 1, sol)) {
            System.out.println("Solution does not exist");
        }

        return sol;
    }

    // Method to check the solution is correct
    static boolean checkSolution(int sol[][]) {
        int[] x = new int[64];
        int[] y = new int[64];
        for (int i = 0; i < 64; i++) {
            x[i] = -1;
            y[i] = -1;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x[sol[i][j]] = i;
                y[sol[i][j]] = j;
            }
        }

        for (int i = 1; i <= 63; i++) {
            if (x[i] == -1 || y[i] == -1) {
                return false;
            }
            int xDist = Math.abs(x[i] - x[i - 1]);
            int yDist = Math.abs(y[i] - y[i - 1]);
            if ((xDist == 1 && yDist == 2) || (xDist == 2 && yDist == 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ans = findPath();
        if (checkSolution(ans)) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }
}




Knight's Tour
Given a 8x8 chess board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each cell in which they are visited.

There may be multiple solutions to this problem so you may return any of the solution in the form of a 8x8 matrix which shall be evaluated by the system for its correctness. If your solution is correct then 1 is printed else 0 is printed.

Your task is to complete the function findPath which returns a 2d Matrix representing the solution.

Output Format:
Return the answer matrix of any possible solution. If the solution is correct, '1' is printed else '0' is printed.

Example
Output:

  0  59  38  33  30  17   8  63 
 37  34  31  60   9  62  29  16 
 58   1  36  39  32  27  18   7 
 35  48  41  26  61  10  15  28 
 42  57   2  49  40  23   6  19 
 47  50  45  54  25  20  11  14 
 56  43  52   3  22  13  24   5 
 51  46  55  44  53   4  21  12 

is one of the possible solutions hence '1' is printed
Constraints:
The board is of size 8 x 8.

Topics
Recursion
Companies
IBM
