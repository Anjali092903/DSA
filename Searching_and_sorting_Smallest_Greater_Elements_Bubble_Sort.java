import java.util.Scanner;

public class Main {

    // Function to find the smallest greater elements using Bubble Sort
    public static int[] SmallestGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Initialize the result array with a large value (-10000000)
        for (int i = 0; i < n; i++) {
            result[i] = -10000000;
        }

        // Bubble Sort to sort the array and track original positions
        // We will pair each element with its original index and sort the array based on values
        int[] sortedArr = arr.clone(); // Clone the array to sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) {
                    // Swap the elements if they are in the wrong order
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
        }

        // Now find the smallest greater element for each element in the original array
        for (int i = 0; i < n; i++) {
            int current = arr[i];

            // Find the next element in the sorted array that is greater than the current element
            for (int j = 0; j < n; j++) {
                if (sortedArr[j] > current) {
                    result[i] = sortedArr[j];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the function to find the smallest greater elements
        int[] ans = SmallestGreaterElements(arr);

        // Print the result array
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}



Smallest Greater Elements - Bubble Sort
Given an array arr of size n. You are required to find Smallest greater elements for all elements in arr. If there is no such element for some element in arr then put its smallest greater element as -10000000.

Note: You have to do this question using Bubble Sort

Input Format
First line contains an integer n which is the size of the array.

Second line contains n space separated integers of array arr

Output Format
Return an array of n elements which contains smallest greater elements of each of the n elements of arr

Example 1
Input

4
13 6 17 12
Output

17 12 -10000000 13
Example 2
Input

9
6 3 9 8 10 2 1 15 7
Output

7 6 10 9 15 3 2 -10000000 8
Constraints
1 <= n <= 10000

-106 <= arr[i] <= 106

Topics
Arrays
Array - Basics
Sorting
Companies
Wipro
Redbus
Accenture
Cisco
Nagarro
Microsoft
SAP
Huawei
