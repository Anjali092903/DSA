import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Size of the array
        int x = sc.nextInt(); // Minimum distance for swaps
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Read the array elements
        }
        
        System.out.println(canSortArray(arr, n, x) ? "YES" : "NO");
        sc.close();
    }

    public static boolean canSortArray(int[] arr, int n, int x) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr); // Get the sorted version of the array

        // Check if we can reach the sorted state by swaps at interval x
        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArr[i]) {
                // If an element is out of place, it must be swappable via x distance swaps
                if (i - x < 0 && i + x >= n) {
                    return false; // If no possible swaps available, sorting is impossible
                }
            }
        }

        return true;
    }
}




Array Swaps
Hitesh has an array A of N integers. He wants his friend to sort the array in the non-decreasing order. Since it would be a too easy problem, Hitesh allows him to use only the following operation:

Choose indices i and j such that 1 ≤ i, j ≤ n, and |i−j|≥X. Then, swap elements A[i] and A[j].

Can you tell if there is a way to sort the array in the non-decreasing order by using the operation written above some finite number of times (possibly 0)?

Input Format
The first line contains two integers, N and X.

The second line contains N space-separated integers.

Output
If you can sort the array in non-decreasing order using the operation written above, output "YES" (without quotes). Otherwise, output "NO" (without quotes).

Example 1
Input

3 3
3 2 1
Output

NO
Explanation

You can not do any operations.
Example 2
Input

5 2
5 1 2 3 4
Output

YES
Explanation

In this test case, you can do the operations as follows:

-   [5,1,2,3,4], swap(a1,a3)
-   [2,1,5,3,4], swap(a2,a5)
-   [2,4,5,3,1], swap(a2,a4)
-   [2,3,5,4,1], swap(a1,a5)
-   [1,3,5,4,2], swap(a2,a5)
-   [1,2,5,4,3], swap(a3,a5)
-   [1,2,3,4,5]

(Here, swap(ai, aj) refers to swapping elements at positions i, j).
Constraints
1 ≤ X ≤ N ≤10⁵

1 ≤ A[i] ≤ 10⁹

Topics
Arrays
Array - Basics



  
