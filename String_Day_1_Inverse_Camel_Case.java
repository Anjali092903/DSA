import java.io.*; 
import java.util.*;

public class Main {
  
  // Function to split the camel case string into words and print each word
  public static void solution(String str) {
    String word = "";  // Variable to accumulate the current word
    
    // Loop through each character in the string
    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      
      // If the character is uppercase and it's not the first character, print the accumulated word
      if (Character.isUpperCase(currentChar) && !word.isEmpty()) {
        System.out.println(word);  // Print the previous word
        word = "";  // Reset word for the next word
      }
      
      // Add the current character to the word
      word += currentChar;
    }
    
    // Print the last accumulated word
    if (!word.isEmpty()) {
      System.out.println(word);
    }
  }

  public static void main(String[] args) {
    // Scanner to read the input string
    Scanner scn = new Scanner(System.in);
    String str = scn.next();  // Read the input string
    solution(str);  
  }
}






Inverse Camel Case
One of the important aspect of object oriented programming is readability of the code. To enhance the readability of code, developers write function and variable names in Camel Case.

You are given a string S, written in Camel Case. Find All The Words Contained In It.

Note Complete the given function. The input would be handled by the driver code. You only have to print the answer.

Input Format
The only line contains the string S.

Output Format
Print each word in a new line

Example 1
Input

IAmAJavaProgrammer
Output

I
Am
A
Java
Programmer
Explanation

We separate each word and print them in a new line.

Example 2
Input

OnePiece
Output

One
Piece
Explanation

We separate each word and print them in a new line.

Constraints
1 <= |str| <= 10000

Topics
Strings - Basics
Strings
