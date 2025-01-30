import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 

class Solution {
    int findCelebrity(int M[][], int n) {
        // Step 1: Use a stack to find the potential celebrity
        Stack<Integer> stack = new Stack<>();
        
        // Push all people onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        
        // Step 2: Narrow down the potential celebrity using the stack
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            // If a knows b, a cannot be the celebrity
            if (M[a][b] == 1) {
                stack.push(b);
            } else {
                // If a does not know b, b cannot be the celebrity
                stack.push(a);
            }
        }
        
        // Step 3: Check if the remaining person is a celebrity
        int candidate = stack.pop();
        
        // Verify if candidate is a celebrity
        for (int i = 0; i < n; i++) {
            // A celebrity should not know anyone else and everyone should know the celebrity
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1; // Candidate fails the celebrity condition
                }
            }
        }
        
        return candidate; // If all checks passed, this person is the celebrity
    }
}




Celebrity Problem
You are present in a party of N people. You have to find if a celebrity is present in the party or not.

A matrix M of size N * N is used to represent people at the party. If M[i][j] = 1, it means ith person knows jth person.

If a person is known to every other person at the party and he knows no one, he is a celebrity.

Here M[i][i] will always be 0.

Note Complete the given function. The input and output would be handled by the driver code.

Print the answer in 0-based indexing.

Input Format
The first line contains N.

The next N lines contains N integer each of matrix M.

Output Format
Print the index of the lowest numbered celebrity. If no celebrity is present, print -1.

Example 1
Input

2
0 1
0 0
Output

1
Explanation

The second person is know to the first but does not know the first person.

Example 2
Input

2
0 1
1 0
Output

-1
Explanation

Both the person know each other.

Constraints
2 <= N <= 300

0 <= M[i] <= 1

Topics
Stacks
Arrays
Companies
Visa
Apple
Google
