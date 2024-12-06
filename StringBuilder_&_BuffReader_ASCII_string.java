import java.io.*;
import java.util.*;

public class Main {

    public static String solution(String str) {
        // StringBuilder to efficiently build the result
        StringBuilder result = new StringBuilder();

        // Append the first character to result
        result.append(str.charAt(0));
        
        // Loop through the string from the second character
        for (int i = 1; i < str.length(); i++) {
            // Calculate the difference in ASCII values
            int diff = str.charAt(i) - str.charAt(i - 1);
            // Append the difference and the current character to result
            result.append(diff).append(str.charAt(i));
        }
        
        // Return the final result as a string
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}




ASCII string
You are given a string str that contains only lowercase alphabets.

You have to form a string that contains the difference of ASCII values of every two consecutive characters between those characters.

Note Complete the given function. The input and output would be handled by the driver code.

Input Format
The only line contains the string str.

Output Format
Print the new string.

Example 1
Input

abecd
Output

a1b3e-2c1d
Explanation

'b' - 'a' = 1
'e' - 'b' = 3
'c' - 'e' = -2
'd' - 'c' = 1
Example 2
Input

abc
Output

a1b1c
Explanation

'b' - 'a' = 1
'c' - 'b' = 1
Constraints
1 <= |str| <= 1000

Topics
Strings - Basics
Strings
