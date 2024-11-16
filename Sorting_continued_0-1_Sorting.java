import java.util.*;

public class Main {
    // Function to sort an array with only 0s and 1s
    static int[] Sorting01(int n, int[] arr) {
        // Initialize two pointers: 
        // `i` - to keep track of the position where the next 0 should be placed.
        // `j` - to traverse the array.
        int i = 0; 
        int j = 0;

        // Traverse through the array
        while (j < arr.length) {
            if (arr[j] == 0) { 
                // If the current element is 0, swap it with the element at index `i`.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                // Increment both `i` and `j` since we placed a 0 at the correct position.
                i++;
                j++;
            } else {
                // If the current element is 1, just move to the next element.
                j++;
            }
        }

        // Return the sorted array.
        return arr;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);

        // Input the size of the array.
        int n = sc.nextInt();

        // Create an array and input its elements.
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        // Call the Sorting01 function to sort the array.
        int[] ans = Sorting01(n, arr);

        // Print the sorted array.
        for (int i = 0; i < n; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}




0-1 Sorting
You are given an array arr of length n containing only 0's and 1's. Your task is to segregate all the 0's to the left of the array and all the 1's to the right of the array.

Input Format
The first line of input contains an integer n, size of the array.

The next line contains n space seperated integers(0 or 1) denoting the elements of the array.

Output Format
Print n space seperated integers denoting the segregated array.

Example 1
Input

15
0 0 0 1 1 1 1 0 1 1 0 0 1 0 1
Output

0 0 0 0 0 0 0 1 1 1 1 1 1 1 1
Explanation

We have arr = [0 0 0 1 1 1 1 0 1 1 0 0 1 0 1]

Moving all the 0's in the beginning and all the 1's at the end.

The final segregated array is [0 0 0 0 0 0 0 1 1 1 1 1 1 1 1]

Example 2
Input

6
1 0 1 0 1 1
Output

0 0 1 1 1 1
Explanation

The sorted array is [0 0 1 1 1 1]

Constraints
1 <= n <= 10^6

0 <= arr[i] <= 1

Topics
2-Pointers
Arrays
Array - Basics
Sorting
Companies
Samsung
PayTM
Amazon
Adobe
MAQ Software
Hike
Oyo Rooms
Flipkart
Snapdeal
MakeMyTrip
Qual
