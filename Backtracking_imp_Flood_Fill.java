import java.util.*;

public class Main {
    public static void FloodFill(int[][] w, int x, int y, int c) {
        int initialColor = w[x][y];
        if (initialColor != c) {
            dfs(w, x, y, initialColor, c);
        }
    }

    public static void dfs(int[][] w, int x, int y, int initialColor, int newColor) {
        // Check bounds and color match
        if (x < 0 || x >= w.length || y < 0 || y >= w[0].length || w[x][y] != initialColor) {
            return;
        }

        // Change the color of the current cell
        w[x][y] = newColor;

        // Recursive calls for 4 neighbors (up, down, left, right)
        dfs(w, x - 1, y, initialColor, newColor); // Up
        dfs(w, x + 1, y, initialColor, newColor); // Down
        dfs(w, x, y - 1, initialColor, newColor); // Left
        dfs(w, x, y + 1, initialColor, newColor); // Right
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];

        // Read the wall matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        // Read flood fill parameters
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();

        // Perform the flood fill
        FloodFill(w, x, y, c);

        // Print the modified wall
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
    }
}









Flood Fill
You are given a wall w represented as matrix, where each element of this wall matrix is filled with color(s).

You are also given two integers x and y and a color c. Your task is to fill w[x][y] and all its adjacent cells of the same color as w[x][y] with this new color c.

Input Format
First line contains two space separated integers m n, which is the size of wall m x n

Next m lines contain n space separated integers of the wall

Last line contains three space separated integers x y and c.

Output Format
Print the modified wall.

Example 1
Input

3 3
0 1 1
0 1 1
1 0 1
1 1 2
Output

0 2 2
0 2 2
1 0 2
Example 2
Input

3 3
1 1 1
1 1 1
1 1 1
0 0 1
Output

1 1 1
1 1 1
1 1 1
Constraints
1 <= m, n <= 50

0 <= w[i][j] <= 216

0 <= x < m

0 <= y < n

Topics
Recursion
Queues
BFS
DFS
Companies
Uber
Google
