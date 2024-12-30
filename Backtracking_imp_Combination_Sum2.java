import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    // Method to find all unique combinations that sum to the target
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int sum) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();  // List to store the final result
        
        Collections.sort(a);  // Sorting the input array to maintain non-descending order in combinations
        solve(al, a, new ArrayList<Integer>(), 0, sum);  // Start solving the combination problem
        return al;  // Return the list of combinations
    }

    // Recursive helper method to find all possible combinations
    public static void solve(ArrayList<ArrayList<Integer>> al, ArrayList<Integer> in, ArrayList<Integer> op, int i, int sum) {
        
        // If the sum becomes negative, no need to proceed, as the combination cannot sum to the target anymore
        if (sum < 0) return;

        // If we've considered all elements
        if (i == in.size()) {
            // If we've reached the target sum (sum == 0), add the current combination (op) to the result list
            if (sum == 0) al.add(new ArrayList<Integer>(op));
            return;
        }
     // Case 1: Include the current number (in.get(i)) in the combination
        ArrayList<Integer> op1 = new ArrayList<Integer>(op);  // Create a copy of the current combination
        op1.add(in.get(i));  // Add the current number to the combination
        solve(al, in, op1, i + 1, sum - in.get(i));  // Recursively call with the remaining sum reduced by in.get(i)

       
        // Case 2: Don't include the current number (in.get(i)) in the combination, but skip all duplicates of the current number
        // This ensures that we don't generate duplicate combinations
        if (!(op.size() != 0 && in.get(i) == op.get(op.size() - 1))) {
            ArrayList<Integer> op2 = new ArrayList<Integer>(op);  // Create a new copy of the combination
            solve(al, in, op2, i + 1, sum);  // Call solve with the next element and the same sum
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>(); 
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int sum = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = combinationSum(a, sum);
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
          
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i).compareTo(o2.get(i));
                }
                return o1.size() > o2.size() ? 1 : 0;
            }
        });
        for (ArrayList<Integer> A : ans) {
            for (Integer B : A) {
                System.out.print(B + " ");
            }
            System.out.println();  
        }
    }
}





Combination Sum 2
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C

where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

The solution set must not contain duplicate combinations.

Print Answer in sorted Manner.

Input format:
the first line contains integer n denoting number of elements in array

the second line denotes the array space separated

the third line denotes the target sum

Output format:
all combinations space separated and in sorted order

Example 1:
Input:

7
10 1 2 7 6 1 5
8
output:

1 1 6
1 2 5
1 7
2 6
Example 2:
Input:

5
2 5 2 1 2
5
output:

1 2 2
5
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Constraints:
1 <= candidates.length <= 100

1 <= candidates[i] <= 50

1 <= target <= 30

Topics
Recursion
Companies
Amazon
Microsoft
