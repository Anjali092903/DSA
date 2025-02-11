import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution ob = new Solution();
        ob.evaluation(exp);
    }
}

class Solution {
    public void evaluation(String exp) {
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Convert char to int and push onto stacks
                valueStack.push(ch - '0');
                infixStack.push(ch + "");
                prefixStack.push(ch + "");
            } else {
                // Pop two values from stacks for evaluation
                int val2 = valueStack.pop();
                int val1 = valueStack.pop();
                int result = operate(val1, val2, ch);
                valueStack.push(result);

                // Infix conversion
                String infixVal2 = infixStack.pop();
                String infixVal1 = infixStack.pop();
                String infixExp = "(" + infixVal1 + ch + infixVal2 + ")";
                infixStack.push(infixExp);

                // Prefix conversion
                String prefixVal2 = prefixStack.pop();
                String prefixVal1 = prefixStack.pop();
                String prefixExp = ch + prefixVal1 + prefixVal2;
                prefixStack.push(prefixExp);
            }
        }

        // Output results
        System.out.println(valueStack.pop());
        System.out.println(infixStack.pop());
        System.out.println(prefixStack.pop());
    }

    // Helper function to evaluate two operands
    public int operate(int val1, int val2, char operator) {
        switch (operator) {
            case '+': return val1 + val2;
            case '-': return val1 - val2;
            case '*': return val1 * val2;
            case '/': return val1 / val2;
            default: return 0;
        }
    }
}






Postfix Evaluation And Conversions
You are given a postfix expression.

You are required to evaluate it and print its value. You are also required to convert it to infix and prefix print both of them.

Note

Use brackets in infix expressions to indicate precedence. For a better understanding, check the example.

Input Format
The first line contains a string s, denoting the postfix expression.

Output Format
In the first line of Output print, the answer is evaluated.

In the second line, print the infix expression.

In the last line, print the prefix expression.

Example 1
Input

264*8/+3-
Output

2
((2+((6*4)/8))-3)
-+2/*6483
Explanation

The evaluated expression is printed in the first line.

The postfix to the infix expression is printed in the second line.

The postfix to prefix expression is printed in the third line.

Example 2
Input

12+34*5/6*7/+
Output

4
((1+2)+((((3*4)/5)*6)/7))
++12/*/*34567
Explanation

The evaluated expression is printed in the first line.

The postfix to the infix expression is printed in the second line.

The postfix to prefix expression is printed in the third line.

Constraints
Expression is a valid prefix expression

The only operators used are +, -, *, /

All operands are single-digit numbers.

Topics
Stacks
Companies
Amazon
