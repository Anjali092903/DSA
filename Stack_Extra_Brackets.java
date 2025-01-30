import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public boolean ExtraBrackets(String exp) {
        Stack<Character> st = new Stack<>(); // Stack to keep track of brackets and operators

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                st.push(ch); // Push opening bracket into stack
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch); // Push operators into stack
            } else if (ch == ')') {
                // If top of stack is '(', it means there's an empty pair of brackets
                if (st.peek() == '(') {
                    return true; // Found extra brackets
                }

                // Pop elements until an opening bracket '(' is found
                while (!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                }
                if (!st.isEmpty()) {
                    st.pop(); // Pop the matching '('
                }
            }
        }
        return false; // No extra brackets found
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine(); // Read input expression
        Solution Obj = new Solution();
        
        // Print result based on whether extra brackets are found
        if (Obj.ExtraBrackets(exp)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}





Extra Brackets
You are given a string exp representing an expression. Assume that the expression is balanced i.e. the opening and closing brackets match with each other.

But, some pair of brackets maybe extra/needless. You are required to find out if there are extra brackets or not.

Note: This expression only contains round brackets '(' and ')'. You need not worry about the other type of brackets

Input Format
First line contains the string exp

Output Format
Complete the function ExtraBrackets() and return true or false according to the question.

Example 1
Input

((a + b) + (c + d))
Output

false
Example 2
Input

(a + b) + ((c + d))
Output

true
Constraints
1 <= exp.size() <= 10000

Topics
Stacks
Strings
