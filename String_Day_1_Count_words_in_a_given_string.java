import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();  // Consume the newline after the integer input
    while (t > 0) {
      String s = sc.nextLine();
      System.out.println(countWords(s));
      t--;
    }
  }

  public static int countWords(String s) {
    int count = 0;  // Initialize word count to 0
    int i = 0;
    int j = 0;

    // Iterate through the string
    while (j < s.length()) {
      char ch = s.charAt(j);

      if (ch == ' ') {
        // Skip over spaces, and when a space is encountered, it means a word ended
        i = j;
        i++;
        j++;
      } else if (i == j) {
        // If we're at the beginning of a new word, increment the count
        count++;
        j++;
      } else {
        j++;
      }
    }
    return count;

    
    
    // split method     String [] arr=s.split(" ");
                         return arr.lenth;
   
  }
}








Count words in a given string
You are given a string containing some space-separated words. You need to count the number of words in the string.

NOTE

You need to complete the given function. The input and printing of output will be handled by the driver code.

Input Format
The first line contains the number of test cases.

For each test case: The first line has the string S.

Output Format
For each test case return the number of words.

Example 1
Input:

1
  this is  a sample   string  
Output

5
Explanation

There are five words which are 'this' , 'is' , 'a' , 'sample' , 'string'.

Example 2
Input

1
gear five
Output

2
Explanation

The two words that are present here are 'gear', and 'five'.

Constraints:
1 <= T <= 10
1 <= |S| <= 10000
Topics
Strings - Basics
Strings
Companies
Amazon
