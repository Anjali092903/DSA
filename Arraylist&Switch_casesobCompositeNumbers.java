Composite Numbers
You are given an array A consisting of N integers. You have to remove all the composite numbers from the array.

Note Complete the given function and print the updated array. The input and output would be handled by the driver code. You have to return the final arraylist.

1 is neither prime nor composite.

Input Format
The first line an integer N.

The next line contains N integers.

Output Format
Return the updated arraylist.

Example 1
Input

4
3 12 13 15
Output

3 13
Explanation

12 and 15 are composite, thus, they are removed.

Example 2
Input

2
4 2
Output

2
Explanation

4 is the only composite number. It is removed. 




  import java.util.*;

class Main {
    
    // Function to check if a given number is prime
    public static boolean isPrime(int num) {
        // Loop from 2 to the square root of the number
        for (int i = 2; i * i <= num; i++) {
            // If num is divisible by any i, it's not prime
            if (num % i == 0) {
                return false; // Return false if a divisor is found
            }
        }
        return true; // Return true if no divisors were found, indicating num is prime
    }

    // Function to remove composite numbers from the array
    static ArrayList<Integer> removeComposite(int arr[], int len) {
        // Initialize an ArrayList to store non-composite (prime) numbers
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i]; // Get the current element
            boolean res = isPrime(element); // Check if the element is prime

            // If the element is prime, add it to the answer list
            if (res == true) {
                ans.add(element);
            }
        }
        return ans; // Return the list of non-composite numbers
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the size of the array from input
        int n = sc.nextInt();
        int[] arr = new int[n]; // Initialize the array of size n
        
        // Read each element of the array from input
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the removeComposite function and store the result in list
        ArrayList<Integer> list = removeComposite(arr, n);
        
        // Print each element in the resulting list (non-composite numbers)
        for (int val : list) System.out.print(val + " ");
    }
}
