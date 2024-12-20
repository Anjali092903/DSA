import java.util.*;

public class Main {

    // Function to find all paths recursively
    static int countAllPath(int sr, int sc, int n, int m, boolean[][] visited) {
        // Base case: If we reach the bottom-right corner, return 1
        if (sr == n && sc == m) {
            return 1;
        }

        // If out of bounds or the cell is already visited, return 0 (invalid path)
        if (sr > n || sc > m || sr < 1 || sc < 1 || visited[sr][sc]) {
            return 0;
        }

        // Mark the current cell as visited
        visited[sr][sc] = true;

        // Recursive calls for all 8 possible directions:
        int right = countAllPath(sr, sc + 1, n, m, visited); // Move right
        int down = countAllPath(sr + 1, sc, n, m, visited); // Move down
        int diagonal = countAllPath(sr + 1, sc + 1, n, m, visited); // Move diagonally down-right
        int leftDown = countAllPath(sr + 1, sc - 1, n, m, visited); // Move left-down
        int rightUp = countAllPath(sr - 1, sc + 1, n, m, visited); // Move right-up
        int up = countAllPath(sr - 1, sc, n, m, visited); // Move up
        int left = countAllPath(sr, sc - 1, n, m, visited); // Move left
        int diagonalUpLeft = countAllPath(sr - 1, sc - 1, n, m, visited); // Move diagonally up-left

        // Unmark the current cell as visited (backtracking)
        visited[sr][sc] = false;

        // Sum up all the valid moves and return
        return right + down + diagonal + leftDown + rightUp + up + left + diagonalUpLeft;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of rows
        int m = sc.nextInt(); // Number of columns

        // Create a visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[n + 1][m + 1];

        // Call the recursive function starting from (1,1)
        System.out.println(countAllPath(1, 1, n, m, visited));
    }
}












hard
Count aMaze paths for Every Direction
Given two integers N and M, representing the number of rows and columns in the maze respectively, find all the paths to go from the top left cell to the bottom right cell.

All moves are allowed, i.e. a valid path can consist of steps that are horizontal, vertical or diagonal in any direction, except no cell should be repeated twice in the same path.

Complete the body of the print aMazePaths function - without changing the signature - to print the list of all paths that can be used to move from top-left to bottom-right. String psf is initially empty. i and j are two variables with an initial value equal to 1.

Note The online judge can't force you to write the function recursively but that is what the spirit of the question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line contains two integers value of N and M.

Output Format
Print total number of possible paths.

Example 1
Input

2 2
Output

5
Explanation

There are only 5 ways to go from 1,1 to 2,2.

right down
right left-down right
down right
right-down
down right-up down
Example 2
Input

1 2
Output

1
Explanation

There is only 1 possible direction.

Constraints
1 <= N <= 9

1 <= M <= 9

Topics
Recursion
2D-Arrays
Companies
Directi
