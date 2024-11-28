import java.util.*;

public class Main {

  // Function to count the good strings
  static int goodStrings(String s, String[] A, int n) {
    int count = 0;

    // Iterate through each string in array A
    for (int i = 0; i < n; i++) {
      String str = A[i];
      boolean isGood = true;

      // Check if all characters in the string exist in string s
      for (int j = 0; j < str.length(); j++) {
        char ch = str.charAt(j);
        if (s.indexOf(ch) == -1) {  // If the character is not in s
          isGood = false;
          break;
        }
      }

      // If all characters are valid, increment the count
      if (isGood) {
        count++;
      }
    }

    return count;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();  // Read number of test cases
    while (t-- > 0) {
      String s = sc.next();  // Read the set of valid characters
      int n = sc.nextInt();  // Read the number of strings in array A
      String[] A = new String[n];  // Initialize the array to store strings

      for (int i = 0; i < n; i++) {
        A[i] = sc.next();  // Read each string into the array
      }

      // Call the goodStrings function and print the result
      System.out.println(goodStrings(s, A, n));
    }
  }
}




Good Strings
You are given a set 'S' of distinct characters. You are also given an array 'A' of 'N' strings.

A String in array 'A' is called good if all the characters of the string is present in the set 'S'.

You have to find how many strings in the array 'A' are good.

Input Format
The first line contains the number of test cases.

For each test case: The first line contains a string denoting the characters of the set 'S'.

The next line contains 'N', the number of strings in 'A'.

The next 'N' lines contains a string each, which are the elements of the array 'A'.

Output Format
For each test case print the count of good strings in a new line.

Example 1
Input:

1
abc
4
ab
abd
cacb
cabef
Output:

2
Explanation:

Only 'ab' and 'cacb' are good strings. Rest of the strings contain characters apart from 'abc'.

Example 2
Input:

1
pq
3
pqqqpp
abc
rst
Output:

1
Explanation:

Only 'pqqqpp' is a good string.

Constraints
1 <= T <= 10

1 <= |S| <= 26

1 <= N <= 1000

1 <= |A[i]| <= 1000

Topics
Strings - Basics
Arrays
Array - Basics
Strings
