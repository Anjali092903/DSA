import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt();

        // Process each test case
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(camelCase(s));
        } sc.close();
    }

    static String camelCase(String s) {
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();

        boolean capitalizeNext = false;

        // Iterate over the string characters
        for (char ch : s.toCharArray()) {
            if (ch == '_') {
                // Mark the next character for capitalization
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    // Convert to uppercase and append to result
                    result.append(Character.toUpperCase(ch));
                    capitalizeNext = false;
                } else {
                    // Append as is
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}




Camel Case
You are given a string consisting of different words separated by underscores _. You have to convert the string to camel case. The first letter of the entire case should be lowercase.

eg: app_dsd_sdda to appDsdSdda

Note:

StringBuilder in Java represents a mutable sequence of characters.

Input Format
The first line contains the number of test cases.

For each test case: The first line contains the string S.

Output Format
For each test case print the final formed string in a new line.

Example 1
Input:

1
abb_b_cc_d
Output:

abbBCcD
Explanation:

We remove the underscores and convert the next character to uppercase.

Example 2
Input:

1
how_are_you
Output:

howAreYou

Explanation:

We remove the underscores and convert the next character to uppercase.

Constraints
1 <= T <= 10

1 <= |S| <= 100000

Topics
Strings - Basics
Strings
