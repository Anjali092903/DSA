import java.util.*;
import java.io.*;

public class Main {

    // Function to compress the string
    static void compressedString(String s) {
        StringBuilder res = new StringBuilder();  // Use StringBuilder to efficiently build the result
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            int count = 1;
            
            // Count consecutive occurrences of the same character
            while (i + 1 < n && s.charAt(i + 1) == currentChar) {
                i++;
                count++;
            }
            
            // Append the character and the count (if greater than 1)
            res.append(currentChar);
            if (count > 1) {
                res.append(count);
            }
        }
        
        System.out.print(res.toString());  // Output the result
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  // Read the number of test cases
        
        while (t-- > 0) {
            String s = br.readLine();  // Read the input string for each test case
            compressedString(s);  // Call the function to compress the string
            System.out.println();  // Print a new line after each test case output
        }
    }
}







Compressed Strings
You are given a string 'S'. You need to compress it using the following algorithms:

Take an empty string res. For every block of consecutive repeating character, do the following:

If the size of block is 1, concatenate it to the end of `S`.
Else, concatenate the character followed by the size of the block.

Return res after completing the above operations on the whole string

Note

StringBuilder in Java represents a mutable sequence of characters.

Input Format
The first line contains the number of test cases.

For each test case: The first line contains the string 'S'

Output Format
For each test case return the string res. Input and output is inbuilt.

Example 1
Input:

1
abbbccd
Output:

ab3c2d
Explanation:

a occurs once, so, we add a to res.

Then, b is repeated 3 times so, b3 is added.

Then, c is repeated 2 times so, c2 is added.

d occurs once, so, we add d to res.

Example 2
Input:

1
aabccc
Output:

a2bc3
Explanation:

a is repeated 2 times so, a2 is added.

b occurs once, so, we add b to res.

Then, c is repeated 3 times so, c3 is added.

Constraints
1 <= T <= 10
1 <= |S| <= 100000
Topics
Strings - Basics
Strings
Companies
Amazon
Microsoft
