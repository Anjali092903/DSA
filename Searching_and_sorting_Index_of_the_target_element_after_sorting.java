import java.util.Scanner;
import java.util.Arrays;

public class Main {
   
    // Function to find the index of target element after sorting the array
    static int findIndex(int[] arr, int n, int k) {
        // Step 1: Sort the array
        int[] sortedArr = Arrays.copyOf(arr, n);  // Copy the array to avoid modifying the original array
        Arrays.sort(sortedArr);  // Sort the array
        
        // Step 2: Find the index of the target element in the sorted array
        for (int i = 0; i < n; i++) {
            if (sortedArr[i] == k) {
                return i;  // Return the index of the target element
            }
        }
        
        return -1;  // Return -1 if element not found (though it's guaranteed to be found)
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the size of the array
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Step 2: Input elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Step 3: Input the target value
        int k = scanner.nextInt();

        // Step 4: Call the function to find the index of the target element
        int index = findIndex(arr, n, k);

        // Step 5: Output the result
        System.out.println(index);

        scanner.close();  // Close the scanner
    }
}






Index of the target element after sorting
You are given an array arr of length n. Your task is to print the index of the given target element after sorting the given array arr. Assume that the array contains only unique elements.

Input Format
The first line of input contains an integer n, size of the array.

The next line contains n space seperated integers denoting the elements of the array.

The next line contains the target element.

Output Format
The only line of output contains the index of the target element after sorting the array.

Example 1
Input

6
6 27 2 3 1 5
5
Output

3
Explanation

We have arr = [6 27 2 3 1 5]

After sorting arr = [1 2 3 5 6 27]

Index of 5 is 3

Example 2
Input

7
9 7 19 20 13 1 6
6
Output

1
Explanation

Sorted array = [1 6 7 9 13 19 20]

Index of 7 is 1

Constraints
1 <= n <= 10^6

0 <= arr[i] <= 10^9

Topics
Loops
