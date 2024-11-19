import java.util.*;

public class Main {

    // Recursive function to print numbers from N to 1
    public static void printtillN(int N) {
        // Base case: when N reaches 0, stop recursion
        if (N == 0) {
            return;
        }
        
        // Print the current number
        System.out.print(N + " ");
        
        // Recursive call with N-1
        printtillN(N - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: integer N
        int N = sc.nextInt();
        
        // Call the recursive function
        printtillN(N);
        
        // Close the scanner
        sc.close();
    }
}







Recursively Print Numbers In Reverse
Write a recursive program to print all numbers starting from N till 1. Print numbers in descending order from N till you reach 1.

Input Format
Input consists of a single integer N

Output Format
Print the numbers between N and 1 in descending order, each separated by a single space.

Example 1
Input

5
Output

5 4 3 2 1
Example 2
Input

10
Output

10 9 8 7 6 5 4 3 2 1
Constraints
1 <= N <= 1000
