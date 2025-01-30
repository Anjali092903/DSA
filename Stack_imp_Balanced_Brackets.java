import java.util.*; // Importing required utility package for Stack and Scanner

class Solution {
    public boolean balancedBrackets(String s, int n) {
        Stack<Character> stack = new Stack<>(); // Stack to store opening brackets

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // Push opening brackets onto the stack
            } else {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object to take input
        int n = sc.nextInt(); // Read integer input (length of string)
        String s = sc.next(); // Read string input (sequence of brackets)
        Solution Obj = new Solution(); // Create an object of Solution class
        
        // Check if brackets are balanced and print appropriate message
        if (Obj.balancedBrackets(s, n)) {
            System.out.println("YES"); // Print YES if brackets are balanced
        } else {
            System.out.println("NO"); // Print NO if brackets are not balanced
        }
    }
}





Balanced Brackets
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is Balanced if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Input Format
The first line contains a single integer n(Length of the string)

The second line contains string s

Output Format
Print YES is brackets are balanced otherwise print NO

Example 1
Input

2
()
Output

YES
Explanation As ( was closed with ) therefore output isYES

Example 2
Input

2
(]
Output

NO
Explanation The bracket ( was not closed, Therefore output is NO

Constraints
1 <= s.length <= 10^6
s consists of parentheses only '()[]{}'
Topics
Stacks
Companies
Wipro
Amazon
Yatra.com
Oracle
Hike
Snapdeal
Walmart Global Tech
Zoho
