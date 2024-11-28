import java.util.*;
import java.io.*;

public class Main {
    public static void isPangram(String s) {
        // Convert string to lowercase
        s = s.toLowerCase();

        // Create a boolean array to track all 26 letters
        boolean[] history = new boolean[26];

        // Iterate over the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a'; // Find the index for the letter
                history[idx] = true;
            }
        }

        // Check if all letters are present
        for (boolean exists : history) {
            if (!exists) {
                System.out.println("not pangram");
                return;
            }
        }
        System.out.println("pangram");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); // Read input string
        isPangram(s); // Call the function to check pangram
    }
}




Pangrams
A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.

Input Format
The first line inputs a string, S.

Output Format
In a new line, print "pangram" if string contains every letter of the alphabet else "not pangram".

Example 1
Input

We promptly judged antique ivory buckles for the next prize
Output

pangram
Explanation All of the letters of the alphabet are present in the string.

Example 2
Input

We promptly judged antique ivory buckles for the prize
Output

not pangram
Explanation

The string lacks an x.

Constraints:
0 < length of s <= 1000\

Each character of s, s[i]∈{a-z,A-Z,space}

Topics
Strings - Basics
Arrays
Array - Basics
Hashing
Strings
Companies
Snapdeal
