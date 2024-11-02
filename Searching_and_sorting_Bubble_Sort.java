
  import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the size of the array
        int N = sc.nextInt();

        // Initialize the array with size N
        int arr[] = new int[N];

        // Input elements into the array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Call bubbleSort to sort the array in descending order
        bubbleSort(N, arr);
        
        // Print the sorted array
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Function to perform bubble sort in descending order
    public static void bubbleSort(int n, int[] arr) {
        // Bubble Sort: Each pass moves the largest element to the correct position
        
        for (int itr = 0; itr < arr.length - 1; itr++) {
            int rightRange = n - itr - 1;  // Range shrinks with each pass
            
            for (int i = 0; i < rightRange; i++) {
                int val1 = arr[i];
                int val2 = arr[i + 1];
                
                // Swap if the next element is smaller (for descending order)
                if (val1 < val2) {  
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}







Bubble Sort
Given an Integer N and a list arr. Sort the array using bubble sort algorithm.. First take input of size of the array i.e. N, followed by N numbers which represent the array elements.

Note: Use of inbuilt sort function is not permitted.

Time complexity: There are N elements in the array and for every element we make N iterations , hence N*N iterations which gives us a Time complexity of O(N^2) in the worst case.

Space Complexity: Since this algorithm works without the use of any additional storage space apart from the input, we can say that the Space Complexity will be O(1)

Input Format
First line contains integer N denoting the size of array arr[]

Second line contains N array integers each separated by a space denoting elements of arr[]

Output Format
Output N integers of the sorted array separated by a space in a single line

Example 1
Input

5
1 4 3 7 2
Output

1 2 3 4 7
Explanation

1<2<3<4<7


