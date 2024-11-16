Pascal's Triangle
You are given a number n, you are required to print the first n rows of the pascal triangle.

Pascal Triangle

Your task is to complete the function pascalTriangle which receives n as the parameters and returns a 2D array containing the first n rows of the pascal's triangle.

Input Format
You are given a single integer n representing the number of rows of pascal's triangle.

Output Format
Print n lines of output, where ith line represents the ith row of the triangle.

Example 1
Input

3
Output

1
1 1
1 2 1
Example 2
Input

5
Output

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
Constraints:
1<= n <= 30

Topics
Math
Companies
Samsung
Amazon
Goldman Sachs
Twitter
Bloomberg
Adobe
VMware
Apple




  import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of rows for Pascal's Triangle
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        
        // Print the triangle row by row
        for (ArrayList<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        // Loop to generate each row of Pascal's Triangle
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            
            // Each row starts and ends with 1
            row.add(1);
            
            // Fill the middle elements using the previous row
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(value);
            }
            
            // Add 1 at the end of the row (except for the first row)
            if (i > 0) {
                row.add(1);
            }

            // Add the row to the triangle
            triangle.add(row);
        }

        return triangle;
    }
}
