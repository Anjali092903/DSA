public class MaxFrequencyChar {
    public static void main(String[] args) {
        // Example input
        String s = "abbbc";  // You can change this to test

        // Call function to find max frequency character
        char result = getMaxFrequencyChar(s);

        // Print the result
        System.out.println(result);
    }

    // Function to find the maximum frequency character
    public static char getMaxFrequencyChar(String s) {
        // Step 1: Frequency array (26 for 'a' to 'z')
        int[] freq = new int[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);       // pick each character
            freq[ch - 'a']++;            // map 'a'->0, 'b'->1 ... 'z'->25
        }

        // Step 2: Find the character with highest frequency
        int maxFreq = -1;
        char ans = 'z';   // start with 'z' (so smaller chars win in tie)

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                ans = (char) (i + 'a');  // convert index back to character
            } else if (freq[i] == maxFreq && freq[i] > 0) {
                // If tie, choose lexicographically smaller
                char current = (char) (i + 'a');
                if (current < ans) {
                    ans = current;
                }
            }
        }

        return ans;
    }
}







Maximum Frequency Character
Given a string s containing lowercase alphabets, return the character with the highest occurrence in s.

If there are multiple such characters, then return the lexicographically smallest one of them.

Input Format
The only line of the input contains the string s.

Output Format
Print the maximal occurring character in the string s. If there are multiple, print the lexicographically minimum one.

Example 1
Input

abbbc
Output

b
Explanation

Here, a occurs 1 time, c occurs 1 time, and b occurs 3 times. Hence our answer for this is b.

Example 2
Input

aabbbccc
Output

b
