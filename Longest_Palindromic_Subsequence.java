Longest Palindromic Subsequence
Given a sequence, find the length of the longest palindromic subsequence in it.

Input Format
There is only a singer string.

Output Format
return the length of the longest increasing subsequence as a single integer.

Example 1
Input

acciojobs
Output

3
Explanation

Subsequence "ojo" is the longest subsequence which is also a palindrome.

Example 2
Input

bbabcbcab
Output

7
Explanation
Subsequence "babcbab" is the longest subsequence which is also a palindrome.
Constraints
1 <= |S| <= 1000




  🔹 Recursive Idea

Let LPS(s, i, j) = length of longest palindromic subsequence in substring s[i..j].

Base cases

If i > j → return 0 (empty substring).

If i == j → return 1 (single char is palindrome).

Choices

If s[i] == s[j] → both chars can be part of palindrome
→ 2 + LPS(s, i+1, j-1)

Else → either skip left or skip right
→ max(LPS(s, i+1, j), LPS(s, i, j-1))





import java.util.Scanner;

public class LPSRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input string from user
        String s = sc.nextLine();

        int n = s.length();
        int result = longestPalSubseq(s, 0, n - 1);

        System.out.println(result);

        sc.close();
    }

    // Recursive function
    public static int longestPalSubseq(String s, int i, int j) {
        // Base case: empty substring
        if (i > j) return 0;

        // Base case: single character
        if (i == j) return 1;

        // If characters match
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + longestPalSubseq(s, i + 1, j - 1);
        }

        // Else skip one character from either side
        return Math.max(longestPalSubseq(s, i + 1, j), longestPalSubseq(s, i, j - 1));
    }
}





        // If characters match
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + longestPalSubseq(s, i + 1, j - 1);
        }
If first and last characters are the same → they can be part of palindrome.
So we add 2 (for these two chars) + solve the inside substring (i+1, j-1).


          // Else skip one character from either side
        return Math.max(longestPalSubseq(s, i + 1, j), longestPalSubseq(s, i, j - 1));
If first and last characters don’t match → then we try two options:
Skip left character (i+1, j)
Skip right character (i, j-1)
Take the maximum of the two results.






with DP
  import java.util.Scanner;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input string from user
        String s = sc.nextLine();

        // Call function to calculate LPS
        int result = longestPalindromicSubsequence(s);

        // Print the result
        System.out.println(result);

        sc.close();
    }

    // Function to find the longest palindromic subsequence length
    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();

        // dp[i][j] = length of LPS in substring s[i...j]
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Check substrings of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // endpoint of substring

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2; // two equal chars → palindrome of length 2
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                } else {
                    // If chars don't match, take max by skipping one char
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // Answer is LPS of full string
        return dp[0][n - 1];
    }
}







  
