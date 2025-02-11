import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        valueOfExpression(str);
    }

    public static void valueOfExpression(String str) {
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();

        // Traverse from right to left
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                // Push operand into all stacks
                valueStack.push(ch - '0'); // Convert char to integer
                infixStack.push(ch + ""); // Convert char to string
                postfixStack.push(ch + ""); // Convert char to string
            } else {
                // Operator encountered, pop two elements
                int val1 = valueStack.pop();
                int val2 = valueStack.pop();
                int result = operate(val1, val2, ch);
                valueStack.push(result); // Push computed result

                // Infix Conversion
                String infixExp = "(" + infixStack.pop() + ch + infixStack.pop() + ")";
                infixStack.push(infixExp);

                // Postfix Conversion
                String postfixExp = postfixStack.pop() + postfixStack.pop() + ch;
                postfixStack.push(postfixExp);
            }
        }

        // Final outputs
        System.out.println(valueStack.pop());
        System.out.println(infixStack.pop());
        System.out.println(postfixStack.pop());
    }

    // Helper function to evaluate two operands based on the operator
    public static int operate(int val1, int val2, char operator) {
        if (operator == '+') return val1 + val2;
        if (operator == '-') return val1 - val2;
        if (operator == '*') return val1 * val2;
        if (operator == '/') return val1 / val2;
        return 0; // Default case (should never reach here)
    }
}




Prefix Evaluation and Conversion
You are given a prefix expression.

You are required to evaluate it and print it's value.

You are required to convert it to infix and print it.

You are required to convert it to postfix and print it.

Note

Use brackets in infix expression for indicating precedence. Check sample input output for more details.

Input Format
The first line of input contains a string str, prefix expression.

Output Format
You need to output 3 lines,

The value of the expression.

It's infix expression.

It's postfix expression.

Example 1
Input

-+2/*6483
Output

2
((2+((6*4)/8))-3)
264*8/+3-
Explanation

The value for the given prefix expression is 2, its infix expression is ((2+((64)/8))-3) and its postfix expression is 2648/+3-.

Example 2
Input

++123
Output

6
((1+2)+3)
12+3+
Explanation

The given string ab has 2 permutations ab and ba.

Constraints
Expression is a valid prefix expression

The only operators used are +, -, *, /

All operands are single digit numbers.

Topics
Stacks
Companies
Facebook
Paypal
VMware
Google
Microsoft
Yahoo
