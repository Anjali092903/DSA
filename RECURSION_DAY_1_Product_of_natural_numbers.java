import java.util.*;

public class Main {
	static long product(int n){
		//Write code here
          // Base case: If n is 1, return 1 as the product of numbers till 1 is 1
        if (n == 1) {
            return 1;
        }
        // Recursive case: Multiply n with the product of numbers till n-1
        return n * product(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(product(n));
    }
}




Product of natural numbers
Write a recursive program to find the product of all the Natural numbers till N. Take input of N from the user and write a recursive function that returns the product of all the Natural numbers until N.

Input Format
Enter an integer N (N>0)

Output Format
Print the product of all the Natural numbers between N and 1 (both included).

Example 1
Input

5
Output

120
Explanation

5 * 4 * 3 * 2 * 1 = 120.

Example 2
Input

4
Output

24
Explanation

4 * 3 * 2 * 1 = 24.
