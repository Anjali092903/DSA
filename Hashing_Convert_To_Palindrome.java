import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Helper function to check if the string is a palindrome between two indices
    private boolean isPalindromeRange(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }
        return true; // No mismatches, it's a palindrome
    }

    public int solve(String A) {
        int left = 0;
        int right = A.length() - 1;

        // Use a two-pointer approach to find mismatches
        while (left < right) {
            if (A.charAt(left) != A.charAt(right)) {
                // Check if skipping one character results in a palindrome
                if (isPalindromeRange(A, left + 1, right) || isPalindromeRange(A, left, right - 1)) {
                    return 1; // Can be a palindrome by removing one character
                } else {
                    return 0; // Cannot be a palindrome
                }
            }
            left++;
            right--;
        }

        // If no mismatch is found, the string is already a palindrome
        return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine(); 
        Solution Obj = new Solution(); 
        int ans = Obj.solve(A); 
        System.out.println(ans); 
    }
}




Convert To Palindrome
Given a string S consisting only of lowercase characters. We need to check whether it is possible to make this string a palindrome after removing exactly one character from this.

If it is possible then print 1 else return 0.

Input Format
The first line given is the string S.

Output Format
Print 1 if it is possible to convert S to palindrome by removing exactly one character else return 0.

Example 1
Input

abcba
Output

1
Explanation

We can remove character 'c' to make string palindrome.

Example 2
Input

abecbea
Output

 0
Explanation

It is not possible to make this string palindrome just by removing one character

Constraints
3 <= |S| <= 10^5

S[i] is always a lowercase character.

Topics
Strings
