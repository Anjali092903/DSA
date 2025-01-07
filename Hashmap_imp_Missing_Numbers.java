import java.util.*; // Importing all utility classes including HashMap, ArrayList, etc.

class Solution {

    static void missingNums(int n, int arr1[], int m, int arr2[]) {
        // Create a HashMap to store the frequency of elements in the first array (arr1).
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            // For each element in arr1, update its frequency in map1.
            // If the element is already in the map, increment its count. Otherwise, set count to 1.
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
        }

        // Create a HashMap to store the frequency of elements in the second array (arr2).
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
        }

        // Create a list to store the elements that are "missing" or have a different frequency.
        ArrayList<Integer> missingNums = new ArrayList<>();
        for (int key : map2.keySet()) {
            // For each element in map2, compare its frequency in map1 and map2.
            int freq1 = map1.getOrDefault(key, 0); // Get frequency from map1; default to 0 if not found.
            int freq2 = map2.get(key); // Get frequency from map2 (always exists because we are iterating map2 keys).

            // If the frequency differs or the element is not in map1 (freq1 == 0), it's a "missing" number.
            if (freq1 != freq2) {
                missingNums.add(key);
            }
        }

        // Sort the missing numbers in ascending order to satisfy the output requirements.
        Collections.sort(missingNums);

        // Print the sorted list of missing numbers, or -1 if no numbers are missing.
        if (missingNums.size() > 0) {
            for (int num : missingNums) {
                // Print each missing number followed by a space.
                System.out.print(num + " ");
            }
        } else {
            // If no missing numbers, print -1 as per the problem statement.
            System.out.println(-1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner to read input from the user.

        // Read the size of the first array.
        int n = sc.nextInt();
        int arr1[] = new int[n]; // Initialize the first array.
        for (int i = 0; i < n; i++) {
            // Fill the first array with input values.
            arr1[i] = sc.nextInt();
        }

        // Read the size of the second array.
        int m = sc.nextInt();
        int arr2[] = new int[m]; // Initialize the second array.
        for (int i = 0; i < m; i++) {
            // Fill the second array with input values.
            arr2[i] = sc.nextInt();
        }

        // Create an object of the Solution class and call the missingNums method.
        Solution Obj = new Solution();
        Obj.missingNums(n, arr1, m, arr2); // Pass the input arrays and their sizes to the method.
    }
}










Missing Numbers
Given two arrays of integers, find which elements in the second array are missing from the first array. If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number. Return the missing numbers sorted in ascending order. Only include a missing number once, even if it is missing multiple times.

Note

If there is no element that is to be printed, print -1.

Input Format
There will be four lines of input:

n - the size of the first array arr,

The next line contains n space-separated integers arr[i]

m - the size of the second array brr,

The next line contains m space-separated integers brr[i]

Output Format
Output array of integers (in increasing order) which tells you elements of second array not present in the first array

Example 1
Input

10 
203 204 205 206 207 208 203 204 205 206 
13 
203 204 204 205 206 207 205 208 203 206 205 206 204
Output

204 205 206
Explanation

203 is in both arr and brr and its frequency is 2 in both arrays, hence it is not included in output

204 is included in both arrays but have different frequency hence, it is included in output

Similarly other numbers are considered

Example 2
Input

4
1 1 2 5
4
1 2 3 4
Output

1 3 4
Explanation

1 is in both arrays but frequency of 1 in both arrays is different, hence included in output

2 is in both arrays and have same frequency, hence not included in output

3 is in second array but not first, hence included in output

4 is in second array but not first, hence included in output

5 is in not in second array, hence not included in output

Constraints:
1 <= n, m <= 2 * 10^5

1 <= arr[i], brr[i] <= 10^4

Topics
Arrays
Hashing
Companies
Snapdeal
Microsoft
Zoho
Accolite
