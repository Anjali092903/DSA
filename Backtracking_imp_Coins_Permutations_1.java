import java.util.*;

class Solution {
    // Method to start the coin change solution
    public static void coinChange(int[] coins, int amt) {
        // Boolean array to track visited coins in the current permutation
        boolean[] visited = new boolean[coins.length];
        
        // Start generating permutations
        generatePermutation(coins, visited, amt, "", 0);
    }

    // Recursive method to generate permutations of coins that sum up to the target
    public static void generatePermutation(int[] coins, boolean[] visited, int target, String asf, int ssf) {
        // If the sum so far exceeds the target, terminate this branch
        if (ssf > target) {
            return;
        }
        
        // If the sum matches the target, print the solution and terminate this branch
        if (ssf == target) {
            System.out.println(asf.trim()); // trim() removes extra space at the end
            return;
        }

        // Loop through all coins to generate permutations
        for (int i = 0; i < coins.length; i++) {
            if (!visited[i]) { // Only use coins that haven't been used in the current sequence
                visited[i] = true; // Mark the coin as used
                generatePermutation(coins, visited, target, asf + coins[i] + " ", ssf + coins[i]);
                visited[i] = false; // Backtrack: Unmark the coin for other permutations
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the number of coins
        int n = sc.nextInt();
        int[] coins = new int[n];
        
        // Input coin denominations
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        
        // Input the target amount
        int amt = sc.nextInt();

        // Create an object of Solution and call the coinChange method
        Solution Obj = new Solution();
        Obj.coinChange(coins, amt);
    }
}




Coins Permutations - 1
You are given n coins of various denominations. Along with that you are also given amount amt.

You are required to calculate and print the permutations of the n coins (non-duplicate) using which the amount amt can be paid.

Note:

Print all the permutations following the order in which the coins are present.

Use the code snippet and follow the algorithm discussed in the question video. The judge can't force you, but the intention is to teach a concept. Play in the spirit of the question.

Input Format
First line contains the integer n

Second line contains n space separated integers representing various denominations

Third line contains an integer amt

Output Format
Print the various permutations in different lines, each element in a permutation should be space-separated.

Example 1
Input

5
2 3 5 6 7
12
Output

2 3 7
2 7 3
3 2 7
3 7 2
5 7
7 2 3
7 3 2
7 5
Example 2
Input

5
5 4 2 3 1
7
Output

5 2 
4 2 1 
4 3 
4 1 2 
2 5 
2 4 1 
2 1 4 
3 4 
1 4 2 
1 2 4 
Constraints
1 <= n <= 30

1 <= coin[i] <= 20

0 <= amt <= 50

Topics
Recursion
Companies
Samsung
PayTM
Amazon
Oracle
Snapdeal
Morgan Stanley
Accolite
