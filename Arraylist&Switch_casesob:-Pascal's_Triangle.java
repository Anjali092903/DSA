Pascal's Triangle II
Given an number n, print the nth row of the Pascal's triangle.

Pascal Triangle

Your task is to complete the function pascalTriangleRow which receives n as the parameter and returns the nth row of the pascal's triangle.

Input Format
There is a single line of input representing n.

Output Format
Return the nth row of the Pascal’s triangle

Example 1
Input

4
Output

1 3 3 1
Explanation

The elements in the 4rd row are 1 3 3 1.




  import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Read the row number of Pascal's Triangle to generate
        ArrayList<Integer> triangle = pascalTriangleRow(n);  // Get the nth row of Pascal's Triangle
        for (int i = 0; i < triangle.size(); i++) {  // Print each element in the row
            System.out.print(triangle.get(i) + " ");
        }
    }

    public static ArrayList<Integer> pascalTriangleRow(int n) { // Function to generate the nth row of Pascal's Triangle
       
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // Initialize a list to hold each row of Pascal's Triangle

        // Initialize the first row as [1] and add it to the ans list
        ArrayList<Integer> zerothLi = new ArrayList<>();  
        zerothLi.add(1); 
        ans.add(zerothLi); 

        // Check for edge case where n = 1; if so, return the first row directly
        if (n == 1) {
            return zerothLi;
        } 

        // Initialize the second row as [1, 1] and add it to ans
        ArrayList<Integer> firstLi = new ArrayList<>();  
        firstLi.add(1);
        firstLi.add(1);
        ans.add(firstLi);

        // Generate each row from the third row up to the nth row
        for (int row = 2; row < n; row++) {  
            ArrayList<Integer> curr = new ArrayList<>();  // Create a new list for the current row
            curr.add(1);  // Each row starts with a 1

            ArrayList<Integer> prev = ans.get(row - 1);  // Get the previous row to calculate the current row

            // Calculate the middle elements of the current row by adding adjacent elements in the previous row
            for (int j = 0; j < prev.size() - 1; j++) {  
                int val1 = prev.get(j);  // Get the current element in the previous row
                int val2 = prev.get(j + 1);  // Get the next element in the previous row
                int sum = val1 + val2;  // Sum the two adjacent elements to form the next element in the current row
                curr.add(sum);  // Add the calculated sum to the current row
            }

            curr.add(1);  // Each row ends with a 1
            ans.add(curr);  // Add the completed current row to ans
        }

        // Return only the nth row
        return ans.get(n - 1);  
    }
}
