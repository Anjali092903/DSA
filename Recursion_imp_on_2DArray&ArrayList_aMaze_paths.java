import java.util.*;
import java.io.*;

public class Main {
    // Recursive function to find and print all maze paths
    public static void aMazePaths(int dr, int dc, String psf, int sr, int sc) {
        // Base case: If current row or column exceeds the maze dimensions, return
        if (sr > dr || sc > dc) {
            return;
        }

        // Base case: If current position reaches the destination, print the path and return
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        // Recursive case 1: Move horizontally (right) by adding 'h' to the path
        aMazePaths(dr, dc, psf + "h", sr, sc + 1);

        // Recursive case 2: Move vertically (down) by adding 'v' to the path
        aMazePaths(dr, dc, psf + "v", sr + 1, sc);
    }

    public static void main(String[] args) throws Exception {
        // Input reading setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;

        // Read maze dimensions (number of rows)
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);

        // Read maze dimensions (number of columns)
        inputLine = br.readLine().trim().split(" ");
        int m = Integer.parseInt(inputLine[0]);

        // Call the recursive function to generate and print all paths
        aMazePaths(n, m, "", 1, 1);
    }
}




aMaze paths
Given two integers N and M, representing the number of rows and columns in the maze respectively, find all the paths to go from the top left cell to the bottom right cell.

Only two moves are allowed h (1-step horizontal to the right) and v (1-step vertically down).

Complete the body of the print aMazePaths function - without changing the signature - to print the list of all paths that can be used to move from top-left to bottom-right. String psf is initially empty. i and j are two variables with an initial value equal to 1.

Note The online judge can't force you to write the function recursively but that is what the spirit of the question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Make the horizontal call first, before the vertical recursive call.

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

hv
vh
Explanation

We first go right then down, which gives hv.

One other path is to go down then right which gives vh.

Example 2
Input

1
2
Output

h
Explanation

The only possible path is to go one step to the right, which gives h.

Constraints
1 <= N <= 10

1 <= M <= 10

Topics
Recursion
