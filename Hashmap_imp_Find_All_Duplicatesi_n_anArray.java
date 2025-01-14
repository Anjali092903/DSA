import java.util.*;

class Solution {
    public void allDuplicates(int n, int[] arr) {
        // Step 1: Use a HashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Collect duplicates based on values (sorted order)
        List<Integer> duplicates = new ArrayList<>();
        for (int key : frequencyMap.keySet()) {
            int count = frequencyMap.get(key);
            if (count > 1) {
                // Add each duplicate the appropriate number of times
                for (int i = 0; i < count - 1; i++) {
                    duplicates.add(key);
                }
            }
        }

        // Step 3: Sort the duplicates in ascending order
        Collections.sort(duplicates);

        // Step 4: Print the sorted duplicates
        for (int num : duplicates) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read the size of the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr); // Call the method to find duplicates
        sc.close();
    }
}



Find All Duplicates in an Array
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice.

Return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

Input Format
The first line contains a single integer n (size of the array)

Second line contains n-spaced integers representing the array

Output Format
Print all the elements that appear twice in a sorted manner

Example 1
Input

8
4 3 2 7 8 2 3 1
Output

2 3
Explanation

2 and 3 are only the elements that are repeated twice

Example 2
Input

3
1 1 2
Output

1
Explanation

Only 1 is repeated twice

Constraints
1 <= n <= 10^5

0 <= arr[i] <= 10^9

Topics
Arrays
Companies
Facebook
Tencent
Amazon
Bloomberg
Adobe
Apple
Nagarro
Pocket Gems
Google
Microsoft
Docusign
