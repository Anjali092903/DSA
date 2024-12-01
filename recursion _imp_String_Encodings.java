import java.util.*;

public class Main {
    public static void printEncodings(String str) {
        // If the input starts with '0', it is invalid, so return nothing.
        if (str.length() == 0 || str.charAt(0) == '0') {
            return;
        }
        // Start recursive encoding.
        pE(str, "");
    }

    public static void pE(String input, String esf) {
        // Base case: if the input is empty, print the encoded string.
        if (input.length() == 0) {
            System.out.println(esf);
            return;
        }

        // Handle single character encoding.
        char ch = input.charAt(0); // Corrected `Char` to `char`.
        if (ch == '0') { // If the current character is '0', it is invalid.
            return;
        }

        String fD = input.substring(0, 1); // First digit as string.
        String ros = input.substring(1);  // Rest of the string.

        // Convert first digit to integer and map to a character.
        int fdInt = Integer.parseInt(fD); // Fixed `pareseInt` to `parseInt`.
        char eqChar = (char) ((fdInt - 1) + 'a'); // Map integer to corresponding alphabet.
        pE(ros, esf + eqChar);

        // Handle two-character encoding if input length is at least 2.
        if (input.length() >= 2) {
            String twoChar = input.substring(0, 2); // First two digits as string.
            ros = input.substring(2);              // Remaining string after two characters.
            int twoCharInt = Integer.parseInt(twoChar); // Fixed incorrect type usage.

            // Check if the two-digit number is between 10 and 26.
            if (twoCharInt >= 10 && twoCharInt <= 26) {
                eqChar = (char) ((twoCharInt - 1) + 'a'); // Map to corresponding alphabet.
                pE(ros, esf + eqChar);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}







String Encodings
You have given string str of digits.

You are required to encode the str as per the following rules

    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
Your task is to calculate all the possible encodings and print them in new line. If no encoding is possible, print nothing.

Note: print all the possible encodings in lexographical manner.

Input Format
First line contains the string str

Output Format
Print the various encodings in new line.

Example 1
Input

123
Output

abc
aw
lc
Explanation

We have three encoding, abc => {1,2,3}, aw => {1, 23}, lc => {12, 3}

Example 2
Input

013
Output

Explanation

String starts with 0, which makes it invalid.

Example 3
Input

303
Output

Explanation

We have no encoding as we can split str as {3, 0, 3}, {30, 3}, or {3, 03}. In {3, 0, 3} we dont have a character for 0. In {30, 3} we dont have a character for 30. In {3, 03}, 03 is invalid.

Constraints
0 <= str.length <= 10

Topics
Recursion
Strings
Companies
Apple
Microsoft
