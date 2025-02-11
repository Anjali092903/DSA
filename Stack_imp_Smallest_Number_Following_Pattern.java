import java.io.*;
import java.util.*;

class Solution {
    public String smallestNumber(String str) {
        // Using a stack to process the pattern
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 1; // Start with number 1
        
        // Iterate over the pattern
        for (int i = 0; i < str.length(); i++) {
            stack.push(num++); // Push current number to stack
            
            // If 'i' is encountered or it's the last character, pop the stack
            if (str.charAt(i) == 'i') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        // Push the last remaining number to stack
        stack.push(num);
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.print(Obj.smallestNumber(str));
    }
}





Smallest Number Following Pattern
You are given a pattern of up to 8 lengths containing characters 'i' and 'd'. 'd' stands for decreasing and 'i' stands for increasing. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that the digit decreases following a 'd' and increases following 'i'.

e.g.

d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
Input Format
The single line of input contains the pattern string.

Output Format
Smallest sequence of digits (from 1 to 9) without duplicacy and following the pattern

Example 1
Input

ddd
Output

4321
Explanation
Since all the alphabets are 'd' hence is an ever decreasing sequence and the lowest possible number is '4321'.

Example 2
Input

i
Output

12
Explanation
Since there is only a single 'i' so the smallest possible number following this pattern is '12'.

Constraints:
1 <= str.length <= 8

Topics
Stacks
Strings
Companies
Amazon
Goldman Sachs
Google
