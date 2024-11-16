import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the size of the array
        int n = sc.nextInt();
        int array[] = new int[n];

        // Populate the array with input values
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        // Call the insertionSort function to sort the array
        insertionSort(array, n);
        
        // Close the scanner
        sc.close();
    }

    static void insertionSort(int a[], int n) {
        // Iterating from the second element to the end of the array
        for (int itr = 1; itr < n; itr++) {
            int i = itr;
            
            // Shifting elements greater than the current element to the right
            while (i >= 1 && a[i - 1] > a[i]) {  // Corrected `arr` to `a`
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                i--;
            }
        }
        
        // Printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");  // Corrected `system` to `System`
        }
    }
}








Insertion Sort
Implement insertion sort.

Input Format
The first line  contains one space separated integer N denoting the number of elements.

The Second line  contains N space separated integers denoting the elements of the array.

You need to complete insertionSort function which contains a array of size n and print the final sorted array in this function only.

Output Format
Print the array in sorted fashion in sorted fashion.

Example 1
Input

 6
 7 6 8 5 4 9
Output

 4 5 6 7 8 9
Explanation

Printed sorted array.

Example 2
Input

 5
 11 5 12 6 13
Output

5 6 11 12 13
Explanation

Printed sorted array.

Constraints
0 <= nums.length <= 10^4

-10^9 <= nums[i] <= 10^9
