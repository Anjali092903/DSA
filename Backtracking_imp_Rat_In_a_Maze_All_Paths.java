import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][] path = new int[n][n]; // To store the path
        boolean[][] visited = new boolean[n][n]; // To track visited cells
        findPaths(maze, n, 0, 0, path, visited, result);
        return result;
    }

    private static void findPaths(int[][] maze, int n, int x, int y, int[][] path, boolean[][] visited, ArrayList<ArrayList<Integer>> result) {
        // Base case: if we reach the destination
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1; // Mark the destination cell
            addPathToResult(path, result, n);
            path[x][y] = 0; // Backtrack
            return;
        }

        // Check if the current cell is valid and not visited
        if (isSafe(maze, n, x, y, visited)) {
            // Mark the cell as part of the path and as visited
            path[x][y] = 1;
            visited[x][y] = true;

            // Move Up
            findPaths(maze, n, x - 1, y, path, visited, result);
            // Move Down
            findPaths(maze, n, x + 1, y, path, visited, result);
            // Move Left
            findPaths(maze, n, x, y - 1, path, visited, result);
            // Move Right
            findPaths(maze, n, x, y + 1, path, visited, result);

            // Backtrack
            path[x][y] = 0;
            visited[x][y] = false; // Unmark the cell as visited
        }
    }

    private static boolean isSafe(int[][] maze, int n, int x, int y, boolean[][] visited) {
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && !visited[x][y]);
    }

    private static void addPathToResult(int[][] path, ArrayList<ArrayList<Integer>> result, int n) {
        ArrayList<Integer> currentPath = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentPath.add(path[i][j]);
            }
        }
        result.add(currentPath);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> ans = Solution.ratInAMaze(maze, n);
        for(int i = 0; i < ans.size(); i++) {
            for(int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}


Rat In a Maze All Paths
You are given a N * N maze with a rat placed at MAZE[0][0]. Find and print all paths that rat can follow to reach its destination i.e. MAZE[N - 1][N - 1]. Rat can move in any direction ( left, right, up and down). Value of every cell in the MAZE can either be 0 or 1. Cells with value 0 are blocked means the rat cannot enter into those cells and those with value 1 are open.

Note: If you are at a point (x,y) where you can go in all direction, then prioritise going Up(x-1, y) first, then Down(x+1, y), then Left(x, y-1) and lastly Right(x, y+1).

Input Format
The first line of input contains an integer N representing the dimension of the maze.

The next N lines of input contain N space-separated integers representing the type of the cell.

Output Format
For each test case, print the path from the start position to the destination position and only cells that are part of the solution path should be 1, rest all cells should be 0.

Output for every test case will be printed in a separate line.

Example 1
Input

3
1 0 1
1 0 1
1 1 1
Output

1 0 0 1 0 0 1 1 1
Explanation

Only 1 path is possible which contains coordinate < (1,1), (2,1), (3,1), (3,2) and (3,3)

Constraints
1 <= N <= 10

0 <= MAZE[i][j] <= 1

Topics
Recursion - Basics
Coding
Recursion
DFS
Companies
Visa
PayTM
Amazon
Flipkart
