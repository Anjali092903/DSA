import java.util.*;

class Solution {
    static boolean areAnagram(String str1, String str2) {
        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a frequency map for characters in str1
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Decrement the frequency for characters in str2
        for (char ch : str2.toCharArray()) {
            if (!freqMap.containsKey(ch)) {
                return false; // Character not found in str1
            }
            freqMap.put(ch, freqMap.get(ch) - 1);

            // Remove the character from the map if its frequency becomes 0
            if (freqMap.get(ch) == 0) {
                freqMap.remove(ch);
            }
        }

        // If the map is empty, both strings are anagrams
        return freqMap.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();

        if (Obj.areAnagram(str1, str2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}




Valid Anagram
Given an string str1 and str2, check if they both are anagrams or not.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Input Format
Input consists of a 2 lines of String str1 and String str2.

Output Format
Print "Yes" if they both are valid anagrams else print "No".

Example 1
Input:

anagram
grmaana
Output:

Yes
Explanation:

Both anagram and gramaana contains same set of characters.

Example 2
Input:

rat
car
Output:

No
Explanation:

car and rat contain different characters.

Constraints:
1 <= str1.length, str2.length <= 5 * 10^4

str1 and str2 consist of lowercase English letters.
Topics
Strings
Companies
Directi
Adobe
Flipkart
Nagarro
Google
