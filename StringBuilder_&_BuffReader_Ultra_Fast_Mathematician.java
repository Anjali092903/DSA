import java.util.*;

public class Main {
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String A = scn.nextLine(); // Read the first string A
        String B = scn.nextLine(); // Read the second string B
        
        // Create StringBuilder objects for both strings
        StringBuilder a = new StringBuilder(A);
        StringBuilder b = new StringBuilder(B);
        
        // Call the solve method to get the resulting string
        StringBuilder c = solve(a, b);
        
        // Print the resulting string c
        System.out.println(c);
    }
    
    // Method to solve the problem
    static StringBuilder solve(StringBuilder a, StringBuilder b) {
        StringBuilder c = new StringBuilder();
        
        // Loop through each character of the strings a and b
        for (int i = 0; i < a.length(); i++) {
            // Compare the characters at the same position
            if (a.charAt(i) != b.charAt(i)) {
                c.append('1');  // If different, append '1'
            } else {
                c.append('0');  // If same, append '0'
            }
        }
        
        return c;  // Return the resulting StringBuilder c
    }
}




Ultra Fast Mathematician
Bob is given 2 numbers a and b, each of them contains only 0 and 1. Your task is to find a number c, such that if the ith digit of number a and b differ then the ith digit of c is 1, 0 in rest of the cases.

Input Format
The first line of input contains a number a.

The second line of input contains a number b.

Output Format
You need to find such a number c, such that if the ith character of a and b are different then the ith position of string c is 1, else 0 in any other case.

Example 1
Input

000
111
Output

111
Explanation

As the both the numbers have different digits in the ith position so the number c is 111.

Example 2
Input

01110
01100
Output

00010
Explanation

only the number at 4th position differs, so the number c has 4th digit as 1.

Constraints
1 <= a,b <= 10100

a,b - {0,1}

Topics
Strings - Basics
Strings
