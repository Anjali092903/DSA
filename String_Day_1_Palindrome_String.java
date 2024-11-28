import java.io.*;
import java.util.*;

public class Main {

    // Method to remove unwanted characters and convert to lowercase
    static String removeUnwantedChars(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                ans.append(Character.toLowerCase(ch));
            }
        }
        return ans.toString();
    }

    // Method to check if the string is a palindrome
    static int isPalindrome(String str) {
        str = removeUnwantedChars(str); // Clean the string

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return 0; // Not a palindrome
            }
            i++;
            j--;
        }
        return 1; // It's a palindrome
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // Input the string
        int result = isPalindrome(str);
        System.out.println(result); // Output the result
    }
}










Palindrome String
Given a string str, determine if it is a palindrome, considering only alphabetic characters and ignoring the upper or lower case. Return 0 if it is not a palindrome, else return 1.

Input Format
Input consists of one line

The first line given is a string str.

Output Format
Returns 0 if it is not a palindrome, else return 1 if it is a palindrome

Example 1
Input

race a car
Output

0
Explanation

Not a palindrome

Example 2
Input

a man, a plan, a canal Panama
Output

1
Explanation

It is a palindrome.

Constraints
1 <= str.length <= 10000

Topics
Strings - Basics
Recursion
2-Pointers
Strings
Companies
Facebook
PayTM
Amazon
FactSet
Cisco
DE Shaw
Morgan Stanley
Zoho
