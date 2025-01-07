import java.io.*;
import java.util.*;

class Solution {
    public void nonRepeatingCharacter(String s) {
        // Create a frequency map to store the count of each character
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        // Traverse the string and fill the frequency map
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Traverse the string again to find the first non-repeating character
        for (char ch : s.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                System.out.println(ch); // Print the first non-repeating character
                return;
            }
        }

        // If no non-repeating character is found, print -1
        System.out.println(-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next(); 
        Solution Obj = new Solution();
        Obj.nonRepeatingCharacter(s); 
        sc.close();
    }
}




Non Repeating Character
Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.

Input Format
The first line will contain the string S.

Output Format
You need to print the first non-repeating character. If there is no non-repeating character then print -1 .

Example 1
Input

hello
Output

h 
Explanation

In the given string, the first character which is non-repeating is h, as it appears first and there is no other h in the string.

Example 2
Input

zxvczbtxyzvy
Output

c
Explanation

In the given string, c is the first character which is non-repeating.

Constraints:
1 <= S.length() <= 1000

Topics
Strings
Companies
Amazon
Payu
Goldman Sachs
MAQ Software
Flipkart
MakeMyTrip
DE Shaw
Microsoft
InfoEdge
Ola
