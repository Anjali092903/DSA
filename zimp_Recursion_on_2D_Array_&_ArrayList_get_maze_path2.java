import java.util.*;

public class Main {
    // Store the paths in the ans ArrayList
    static ArrayList<String> ans = new ArrayList<>();

    public static ArrayList<String> allPossiblePaths(int n, int m) {
        // Clear the ans list for a fresh start
        ans.clear();
        // Call the recursive function
        getPaths(0, 0, n - 1, m - 1, "");
        return ans;
    }

    public static void getPaths(int sr, int sc, int dr, int dc, String psf) {
        // Base case: Out of bounds
        if (sr > dr || sc > dc) {
            return;
        }

        // Base case: Reached the destination
        if (sr == dr && sc == dc) {
            ans.add(psf);
            return;
        }

        // Horizontal moves
        getPaths(sr, sc + 1, dr, dc, psf + "h1");
        getPaths(sr, sc + 2, dr, dc, psf + "h2");

        // Vertical moves
        getPaths(sr + 1, sc, dr, dc, psf + "v1");
        getPaths(sr + 2, sc, dr, dc, psf + "v2");

        // Diagonal moves
        getPaths(sr + 1, sc + 1, dr, dc, psf + "d1");
        getPaths(sr + 2, sc + 2, dr, dc, psf + "d2");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);

        // Print the paths
        for (String str : result) {
            System.out.println(str);
        }
    }
}




Get Maze Paths
Given a grid with N rows and M columns, you must print all the possible paths from the top-left cell to the bottom-right cell.

However you can only make the following moves:

Move one cell to the right (denoted as h1)
Move two cells to the right (denoted as h2)
Move one cell down (denoted as v1)
Move two cells down (denoted as v2)
Move one cell diagonally down and right (denoted as d1)
Move two cells diagonally down and right (denoted as d2)
Return an ArrayList containing all the possible sequence of moves you can make to reach the bottom-right cell.

Note: The online judge can''t force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line of input contains two space-separated integers N and M.

Output Format
Return the list of all possible paths from the top-left cell to the bottom-right cell. The driver code will print the paths in the required format.

Example 1
Input

3 3
Output

d1d1
d1h1v1
d1v1h1
d2
h1d1v1
h1h1v1v1
h1h1v2
h1v1d1
h1v1h1v1
h1v1v1h1
h1v2h1
h2v1v1
h2v2
v1d1h1
v1h1d1
v1h1h1v1
v1h1v1h1
v1h2v1
v1v1h1h1
v1v1h2
v2h1h1
v2h2
Explanation

h1h1v1v1 - Move one cell to the right, move one cell to the right, move one cell down, move one cell down. This will take you from (1,1) to (3,3).

h1h1v2 - Move one cell to the right, move one cell to the right, move two cells down. This will take you from (1,1) to (3,3).

Similarly, all the other paths will also take you from (1,1) to (3,3).

Example 2
Input

2 2
Output

d1  
h1v1
v1h1
Constraints
1 <= N <= 6

1 <= M <= 6

Topics
Recursion
Strings
Companies
PayTM
Amazon
Walmart Global Tech
Microsoft
LinkedIn
