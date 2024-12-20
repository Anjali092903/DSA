import java.io.*;
import java.util.*;

public class Main {
    // Recursive function to count all maze paths
    static int countMazePath(int n, int m) {
        return countPathsHelper(0, 0, n, m); // Start at top-left corner (sr = 0, sc = 0)
    }

    // Helper function for recursion
    static int countPathsHelper(int sr, int sc, int n, int m) {
        // Base case: Reached the bottom-right corner
        if (sr == n - 1 && sc == m - 1) {
            return 1;
        }

        // Base case: Out of bounds
        if (sr >= n || sc >= m) {
            return 0;
        }

        // Recursive case: Sum paths from moving right and down
        int rightPaths = countPathsHelper(sr, sc + 1, n, m); // Move right
        int downPaths = countPathsHelper(sr + 1, sc, n, m);  // Move down

        return rightPaths + downPaths;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of rows
        int m = sc.nextInt(); // Number of columns
        System.out.println(countMazePath(n, m)); 
        }
}






Count Maze Path
Given two integers N and M, representing the number of rows and columns in the maze respectively, find all the paths to go from the top left cell to the bottom right cell.

Only two moves are allowed 1-step horizontal to the right and 1-step vertically down.

Complete the body of the print countMazePath function - without changing the signature to print the count of all the possible paths from top left to bottom right of the matrix.

Note The online judge can't force you to write the function recursively but that is what the spirit of the question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line contains the value of N.

The second line contains the value of M.

Output Format
Print all possible paths.

Example 1
Input

2
2
Output

2
Explanation

We first go right then down, which gives first path.

One other path is to go down then right which second path.

Total paths 2.

Example 2
Input

1
2
Output

1
Explanation

The only possible path is to go two steps to the right, which gives is total paths as 1.

Constraints
1 <= N <= 10

1 <= M <= 10

Topics
Recursion
