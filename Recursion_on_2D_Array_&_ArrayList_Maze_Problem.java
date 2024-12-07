import java.io.*;

public class Main {
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        // Base case: If starting point equals destination point, print the path
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        // Base case: If out of bounds, stop recursion
        if (sr > dr || sc > dc) {
            return;
        }

        // Horizontal moves
        for (int j = 1; j <= dc - sc; j++) {
            printMazePaths(sr, sc + j, dr, dc, psf + "h" + j);
        }

        // Vertical moves
        for (int j = 1; j <= dr - sr; j++) {
            printMazePaths(sr + j, sc, dr, dc, psf + "v" + j);
        }

        // Diagonal moves
        for (int j = 1; j <= Math.min(dr - sr, dc - sc); j++) {
            printMazePaths(sr + j, sc + j, dr, dc, psf + "d" + j);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}






Maze Problem
You are given two numbers n and m representing number of rows and columns in a maze.

You are standing in the top-left corner and have to reach the bottom-right corner.

In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).

Your task is to print the list of all paths that can be used to move from top-left to bottom-right.

Note

You need to write a recursive solution to the problem.

You only need to complete the given function. The function parameters consist of the starting row and column, destination row and column and an empty string.

Use example to take idea about output.

Input Format
The first line conatins an integer n.

The second line conatins an integer m.

Output Format
Print in a new line the list of all paths that can be used to move from top-left to bottom-right.

Example 1
Input

2
2
Output

h1v1
v1h1
d1
Explanation

All paths from top left cell to bottom right cell are printed.

Example 2
Input

3
3
Output

h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2
Explanation

All paths from top left cell to bottom right cell are printed.

Constraints
1 ≤ N ≤ 5

1 ≤ M ≤ 5

Topics
Recursion
