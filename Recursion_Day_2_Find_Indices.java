import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        // Input array elements
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Call the recursive function
        findX(arr, 0, x);
        
        sc.close();
    }

    // Recursive function to find and print indices of x
    static void findX(int arr[], int currentIndex, int x) {
        // Base case: if currentIndex is out of bounds, stop the recursion
        if (currentIndex == arr.length) {
            return;
        }
        
        // If the current element matches x, print the index
        if (arr[currentIndex] == x) {
            System.out.print(currentIndex + " ");
        }
        
        // Recursive call for the next index
        findX(arr, currentIndex + 1, x);
    }
}




Find Indices
Given an array arr of size N and an integer X. The task is to find all the indices of the integer X in the array recursively and print them.

Input Format
The first line of input is the size of array N and an integer X denoting the number whose indices need to be printed. the second line consists of N integers separated by space denoting array arr.

Output Format
print the indices where X is there in array in order

Example
Input

6 2
1 2 3 2 3 5
Output

1 3
Explanation

2 is present on index 1 and index 3 in the provided array

Constraints
1 <= N <= 1000
1 <= X <= 1000
-10^6 <= arr[i] <= 10^6

Topics
Recursion
Arrays
