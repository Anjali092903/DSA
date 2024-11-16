import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner object to read input
        int n = sc.nextInt(); // Read the integer input for number of times to print
        solve(n); // Call the recursive function to print "ACCIOJOB" n times
    }

    /**
     * Recursive function to print "ACCIOJOB" n times.
     * @param n: the number of times to print the string.
     */
    public static void solve(int n) {
        // Base case: if n is 0, stop the recursion
        if (n == 0) {
            return;
        }

        // Print "ACCIOJOB"
        System.out.println("ACCIOJOB");

        // Recursive call with n-1 to print the string one less time
        solve(n - 1);
    }
}




Print ACCIOJOB
Using recursion, your task is to print string ACCIOJOB, n times.

Input Format
First line contains integer n

Output Format
Print the string ACCIOJOB, n times.

Example 1
Input

3
Output

ACCIOJOB
ACCIOJOB
ACCIOJOB
Explanation:

As the value of n is 3 so, we get 3 times ACCIOJOB.

Example 2
Input

1
Output

ACCIOJOB
Explanation:

As the value of n is 1, so we get ACCIOJOB 1 times.

Constraints
