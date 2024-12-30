import java.util.*;

class Solution {
    public static void coinChange2(int[] coins, int amt){
        // Call the recursive function to find all valid permutations
        generatePermutations(coins, amt, "", 0);
    }
   
    public static void generatePermutations(int[] coins, int target, String asf, int ssf){
        // Base case: if the sum of the current combination exceeds the target, stop the search
        if (ssf > target) {
            return;
        }
        
        // If we have reached the target amount, print the current combination
        if (ssf == target) {
            System.out.println(asf.trim()); // Remove trailing space before printing
            return;
        }
        
        // Try adding each coin to the current combination
        for (int i = 0; i < coins.length; i++) {
            // Add the current coin and continue the search with the same sum
            generatePermutations(coins, target, asf + coins[i] + " ", ssf + coins[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read inputs from the user
        Scanner sc = new Scanner(System.in);

        // Read the number of coins
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Read the target amount (amt)
        int amt = sc.nextInt();
        Solution Obj = new Solution();
        Obj.coinChange2(coins, amt);  // Start the process of finding permutations
    }
}






Coin Permutations - 2
You are given n coins of various denominations. Along with that you are also given amount amt.

You are required to calculate and print the permutations of the n coins (same coin can be used again any number of times) using which the amount amt can be paid.

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

3
2 3 5
7
Output

2 2 3
2 3 2
2 5
3 2 2
5 2
Example 2
Input

5
5 4 2 3 1
3
Output

2 1
3
1 2
1 1 1
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
