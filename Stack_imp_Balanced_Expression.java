import java.util.*;
import java.io.*; // Importing required classes for BufferedReader and InputStreamReader

class Solution {
    public boolean expBalanced(String exp) {
        Stack<Character> stack = new Stack<>(); // Stack to store opening brackets

        // Iterate through each character in the string
        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Push opening brackets onto the stack
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // If stack is empty, there's no matching opening bracket
                }
                char top = stack.pop(); // Pop the top element from the stack
                
                // Check if the popped bracket matches the current closing bracket
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false; // If not matched, return false (unbalanced brackets)
                }
            }
        }
        return stack.isEmpty(); // If stack is empty, all brackets are balanced
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for fast input
        String exp = br.readLine(); // Read string input (expression with brackets, operators, and letters)
        Solution Obj = new Solution(); // Create an object of Solution class
        
        // Check if expression is balanced and print appropriate message
        System.out.println(Obj.expBalanced(exp));
    }
}






Balanced Expression
You are given a string exp representing an expression. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

The string exp contains the characters '(', ')', '{', '}', '[', ']', operators i.e. '-', '+', '*', '/' and lowercase english alphabets.

Example:

[(a+b)+{(c+d)*(e/f)}] -> true
[(a+b)+{(c+d)*(e/f)]} -> false
[(a+b)+{(c+d)*(e/f)} -> false
([(a+b)+{(c+d)*(e/f)}] -> false
An input string is Balanced if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Your task is to complete the function expBalanced which receives the input expression exp as parameter and returns true or false depending on if the expression is balanced or not.

Input Format
The only line contains string exp

Output Format
Print true is the expression is balanced otherwise print false.

Example 1
Input

[(a+b)+{(c+d)*(e/f)}]
Output

true
Explanation As [ was closed with ], ( was closed with ) and { was closed with } therefore output istrue.

Example 2
Input

[(a+b)+{(c+d)*(e/f)]}
Output

false
Explanation The bracket { and [ was not closed, Therefore output is false.

Constraints
1 <= exp.length <= 10^4
Topics
Stacks
Companies
Amazon
Yatra.com
Oracle
Adobe
Oyo Rooms
Flipkart
Snapdeal
Google
Walmart Global Tech
Microsoft
