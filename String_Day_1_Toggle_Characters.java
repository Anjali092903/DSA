import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read the size of the string
        sc.nextLine(); // Consume the newline character
        String str = sc.nextLine(); // Read the string

        toggleCase(n, str);
    }

    static void toggleCase(int n, String str) {
        // StringBuilder is more efficient for string manipulation
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                // Convert lowercase to uppercase
                ans.append((char) (ch - 'a' + 'A'));
            } else if (ch >= 'A' && ch <= 'Z') {
                // Convert uppercase to lowercase
                ans.append((char) (ch - 'A' + 'a'));
            } else {
                // Append non-alphabetic characters as-is
                ans.append(ch);
            }
        }

        // Print the toggled string
        System.out.println(ans.toString());
    }
}





Toggle Characters
Given a string of length N, toggle the case of all the characters in the string, i.e. You should set all lowercase characters to uppercase and vice versa.

Please note that the string may contain numbers or special characters as well.

Input Format
The input consists of two lines.

The first line of the input contains one integer N, denoting the size of the string.

The second line of the input contains the string S.

Output Format
Your code should output the string S with its characters toggled.

Example 1
Input

8
helloABC
Output

HELLOabc
Explanation

All the lower case alphabets got converted into upper case and vice versa.

Example 2
Input

4
aBC1
Output

Abc1
Explanation

All the lower case alphabets got converted into upper case and vice versa.

Constraints
`1 <= N <= 2*10^5``

where n is the size of the string.

Topics
Strings - Basics
Strings
