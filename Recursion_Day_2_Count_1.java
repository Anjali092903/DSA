import java.util.*;  // Import the Scanner class to take input from the user

public class Main {

    // Recursive function that counts how many times the digit '1' appears in the number 'n'
    static int count(int n) {
        
        // Base case: if n is 0, it means we have processed all digits of the number, so return 0
        if (n == 0) {
            return 0;
        }

        // Extract the last digit of the number 'n' using modulus operation
        int ld = n % 10;  // 'ld' stands for "last digit" (n % 10 gives the remainder, which is the last digit)

        // Remove the last digit by dividing the number 'n' by 10 (integer division)
        int rd = n / 10;  // 'rd' stands for "remaining digits" (n / 10 removes the last digit)

        // Recursive call: Call count() with the remaining digits (rd) of the number
        int count = count(rd);  // The function continues to call itself on the reduced number

        // Check if the last digit is 1. If yes, increment the count by 1; otherwise, return the same count
        if (ld == 1) {
            return count + 1;  // If the last digit is '1', increment the count by 1
        } else {
            return count;  // If the last digit is not '1', return the current count without incrementing
        }
    }

    // Main function to drive the program
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        
        // Read the input number 'n' from the user
        int n = sc.nextInt();
        
        // Call the recursive 'count' function to count the occurrences of digit '1' in the number 'n'
        System.out.println(count(n));
        
        // Close the scanner to free resources after use
        sc.close();
    }
}






Count 1
Given a number N, your task is to find the number of occurrences of the digit 1 in the number. Do it recursively.

Input Format
The first line contains an integer N denoting the number.

Output Format
For each test case return a number, denoting the number of occurrences of the digit 1 in the given number.

Example 1
Input

21121
Output

3
Explanation

There are 3 occurrences of the digit 1 in the number.

Example 2
Input

11245
Output

2
Explanation

There are 2 occurrences of the digit 1 in the number.

Constraints
1 <= N <= 10^9
