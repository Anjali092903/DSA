import java.util.*;

public class Main {
    static int numOfDigi(int n) {
        // Base case: if the number becomes 0, return 0
        if (n == 0) {
            return 0;
        }

        // Recursive step: divide the number by 10 and add 1 to the count
        int num = n / 10;
        int count = numOfDigi(num); // Use the correct method name
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt(); // Read the input
        int result = numOfDigi(n); // Call the function
        System.out.println(result); // Print the result
        sc.close(); // Close the scanner
    }
}






Find Number of Digits
Given the number n, find out and return the number of digits present in a number recursively.

Input Format
Input consists of single line which has the integer n.

Output Format
Return the number of digits present in n.

Example 1
Input

1256
Output

4
Example 2
Input

12345
Output

5
Constraints
1 <= n <= 10^9

Topics
Recursion
Companies
  oracle



  
