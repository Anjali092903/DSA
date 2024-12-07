
import java.io.*; 
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Create a Scanner object to read input from the console
        Scanner input = new Scanner(System.in);

        // Read two integers from the user: n (number of rows) and m (number of columns)
        int n = input.nextInt();
        int m = input.nextInt();

        // Create an instance of the Main class to call its non-static methods
        Main mainInstance = new Main();

        // Call the getMazePaths method to calculate all paths from the top-left to the bottom-right
        ArrayList<String> paths = mainInstance.getMazePaths(0, 0, n - 1, m - 1);

        // Print the list of all possible paths
        System.out.println(paths);
    }

    // This method computes all paths from (sr, sc) to (dr, dc) and returns them as a list
    public ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // Initialize an empty list to store all paths
        ArrayList<String> MazePaths = new ArrayList<>();

        // Call the helper method to recursively find all paths
        getMazePaths(sr, sc, dr, dc, "", MazePaths);

        // Return the list of paths
        return MazePaths;
    }

    // Helper method to recursively explore all possible paths
    public void getMazePaths(int sr, int sc, int dr, int dc, String psf, ArrayList<String> MazePaths) {
        // Base case: If the current position (sr, sc) is the destination (dr, dc)
        if (sr == dr && sc == dc) {
            // Add the path string so far (psf) to the list of paths
            MazePaths.add(psf);
            return;
        }

        // If the current position is out of bounds (beyond the destination), stop the recursion
        if (sr > dr || sc > dc) {
            return;
        }

        // Recursive case 1: Move horizontally (right) by incrementing the column (sc)
        // Append "h" to the path string to indicate a horizontal move
        getMazePaths(sr, sc + 1, dr, dc, psf + "h", MazePaths);

        // Recursive case 2: Move vertically (down) by incrementing the row (sr)
        // Append "v" to the path string to indicate a vertical move
        getMazePaths(sr + 1, sc, dr, dc, psf + "v", MazePaths);
    }
}














Get Maze Paths
You are given n and m representing the number of rows and columns in a maze. You are standing at the top-left corner and have to reach the bottom-right corner.

You can move in only two directions - 1-step horizontal (h) and 1-step vertical (v).

Return the list of all paths that can be used to move from top-left to bottom-right of the maze.

Note: Write the code recusrively. The purpose is to learn recursion and not just solve the problem.

Input Format
First line of input contains two integers n and m.

Output Format
Return the list of all paths that can be used to move from top-left to bottom-right of the maze.

Example 1
Input

3 3
Output

[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
Explanation

You can move to bottom-right in 6 ways.

For 1st way ->

(1,1) -> (1,2) -> (1,3) -> (2,3) -> (3,3)

Example 2
Input

2 1
Output

[v]
Explanation

You can move to bottom-right in 6 ways.

(1,1) -> (2,1)

Constraints
1 <= n <= 10

1 <= m <= 10

Topics
Recursion
Companies
Amazon
