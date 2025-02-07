import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    
    System.out.println(reverseParentheses(s));
  }

  public static String reverseParentheses(String s) {
    Stack<StringBuilder> stack = new Stack<>();
    StringBuilder current = new StringBuilder();

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        stack.push(current); // Save current substring before '('
        current = new StringBuilder(); // Start new substring
      } else if (ch == ')') {
        StringBuilder temp = current.reverse(); // Reverse inside parentheses
        current = stack.pop().append(temp); // Merge with the previous substring
      } else {
        current.append(ch); // Append normal characters
      }
    }

    return current.toString(); // Final formatted string
  }
}





Reverse Substrings Between Each Pair of Parentheses
You are given a string s that consists of lower case alphabets and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Result should be bracket-less.

Input Format
Input consists of a single string s

Output Format
Print the new string after formatting

Example 1
Input

(abcd)
Output

dcba
Explanation

There is a single pair of brackets in this string and the substring in between them, abcd gets reversed to dcba and parantheses gets removed.

Example 2
Input

(accio(job))
Output

joboicca
Explanation

The substring "job" is reversed first, then the whole string is reversed.

Constraints
1 <= s.length <= 2000

s consists of only lower case alphabets and brackets

The string will be balanced

Topics
Stacks
Strings
Companies
SAP
