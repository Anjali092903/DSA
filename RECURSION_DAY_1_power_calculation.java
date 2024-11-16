method 1

import java.util.*;

// Main class
class Main {

    // Recursive function to calculate x^n
    public static long xPowerN(int x, int n) {
        // Base case: If the exponent n is 0, return 1
        if (n == 0) {
            return 1;
        }

        // Recursive case: Calculate x^(n-1)
        long res = xPowerN(x, n - 1);

        // Multiply x with the result of x^(n-1) to get x^n
        return x * res;
    }

    // Main method to take inputs and print the result
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input

        // Take input for base x
        int x = sc.nextInt();

        // Take input for exponent n
        int n = sc.nextInt();

        // Call the recursive function and print the result
        System.out.println(xPowerN(x, n));
    }
}



method 2


  







  



  



power calculation
You are given two integers, N and X. You have to find X raised to the power N in O(N) time complexity using recursion.

Note Complete the given function and use recursion to solve this problem.

It is guaranteed that the test cases are made such that the answer does not overflow a 64-bit integer datatype.

Input Format
The first line contains two integers, X, and N.

Output Format
Print the answer.

Example 1
Input

2 3
Output

8
Explanation

2 raised to the power 3 is 8.

Example 2
Input

10 5
Output

100000
Explanation

10 raised to the power 5 is 100000.

Constraints
1 <= X <= 10^8

1 <= N <= 64

Topics
Recursion
Companies
MakeMyTrip
Walmart Global Tech
