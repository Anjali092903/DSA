import java.io.*;
import java.util.*;

class Solution {
    public int reverse(int x) {
        Stack<Character> stack = new Stack<>(); // Stack to store digits as characters
        String numStr = Integer.toString(x); // Convert number to string
        boolean isNegative = numStr.charAt(0) == '-'; // Check if number is negative
        
        // Push digits to stack (excluding sign if negative)
        for (int i = (isNegative ? 1 : 0); i < numStr.length(); i++) {
            stack.push(numStr.charAt(i));
        }
        
        StringBuilder reversedStr = new StringBuilder();
        if (isNegative) reversedStr.append('-'); // Append sign if negative
        
        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop()); // Build the reversed string
        }
        
        try {
            return Integer.parseInt(reversedStr.toString()); // Convert back to integer
        } catch (NumberFormatException e) {
            return 0; // Return 0 if overflow occurs
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Solution Obj = new Solution();
        System.out.print(Obj.reverse(n));
    }
}




Reverse Integer
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Input Format
The first line of input contains the integer n.

Output Format
Print the integer n in reverse if it lies within the range, else print 0.

Example 1
Input

321
Output

123
Example 2
Input

-321
Output

-123
Example 3
Input

120
Output

21
Constraints
-2^31 <= x <= 2^31 - 1
Topics
Stacks
Math
