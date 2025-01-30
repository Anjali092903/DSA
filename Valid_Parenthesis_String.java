import java.util.*;

class Solution {
    public static boolean checkValidString(int n, String s) {
        // Two stacks to keep track of indices of '(' and '*'
        Stack<Integer> leftParenthesis = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                leftParenthesis.push(i);  // Push index of '('
            } else if (c == ')') {
                if (!leftParenthesis.isEmpty()) {
                    leftParenthesis.pop();  // Match '(' with ')'
                } else if (!star.isEmpty()) {
                    star.pop();  // Treat '*' as '(' to match ')'
                } else {
                    return false;  // No matching '(' or '*'
                }
            } else if (c == '*') {
                star.push(i);  // Push index of '*' to treat it later
            }
        }
        
        // After processing, match remaining '(' with '*'
        while (!leftParenthesis.isEmpty() && !star.isEmpty()) {
            if (leftParenthesis.pop() > star.pop()) {
                return false;  // '*' can't match '(' if its index is less
            }
        }
        
        // If we still have unbalanced '(' left
        return leftParenthesis.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        String s = sc.next(); 
        
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n, s);
        
        if (ans) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}




Valid Parenthesis String
Given a string s containing only three types of characters: '(', ')' and '*', print true if s is valid.

The following rules define a valid string:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Input Format
First line contains a single integer n(length of string).
Second line contains the string s of size n.

Output Format
Print true if the given string is valid else print false.

Example 1
Input

2
()
Output

true
Example 2
Input

4
((*)
Output

true
Explanation

Here '*' will treat as ')' , so output is true.

Constraints
1 <= s.length <= 100
s[i] is '(', ')' or '*'.

Topics
Greedy
Dynamic Programming
Stacks
Strings
