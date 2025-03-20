import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of buckets
        int m = sc.nextInt();  // Minimum number of fruits Kevin wants to eat

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());  // Read the number of fruits in each bucket
        }

        int ans = Solution.getMaxMarker(arr, n, m);
        System.out.println(ans);
    }
}

class Solution {
    static int getMaxMarker(ArrayList<Integer> arr, int n, int m) {
        // Initialize binary search range
        int left = 0;                 // Minimum possible marker
        int right = Collections.max(arr);  // Maximum possible marker (largest bucket size)
        int result = 0;                // Store the best marker found

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle marker
            int fruitsEaten = 0; // Track the total fruits Kevin eats

            // Calculate how many fruits Kevin eats for the current marker
            for (int fruitCount : arr) {
                if (fruitCount > mid) { // Only eat from buckets with more than mid fruits
                    fruitsEaten += (fruitCount - mid);
                }
            }

            // If Kevin eats at least 'm' fruits, try a larger marker
            if (fruitsEaten >= m) {
                result = mid;  // Update the best possible marker
                left = mid + 1; // Increase the marker to see if we can get a higher one
            } else {
                right = mid - 1; // If Kevin eats too few fruits, lower the marker
            }
        }

        return result; // Return the maximum valid marker
    }
}







Kevin And His Fruits
Kevin has N buckets each consisting of some fruits. Kevin wants to eat at least M fruits and so, he decided to set a marker (integer) as maximum as possible such that if he eats number of fruits in the i-th bucket - marker fruits then it must be at least M.

Note Each bucket may not have the same amount of fruits. It is guaranteed that the sum of all fruits (including all the buckets) will be greater than M. Kevin can only eat fruits from a particular bucket if and only if the bucket has more fruits than the marker.

Input Format
The first line will contain two space-separated integers N and M where N is the total number of buckets, and M is the minimum number of fruits that Kevin wants to eat.

The second line will contain N space-separated integers which denote the number of fruits in the i-th bucket.

Output Format
Print the maximum possible value of the marker.

Example 1
Input

4 30
10 40 30 20
Output

20
Explanation

If we set the marker at 20 then Kevin can eat following fruits from each bucket: 0 (1st bucket) + 20 (2nd bucket) + 10 (3rd bucket) + 0 (4th bucket) = 30 (K).

Example 2
Input

4 16
5 8 20 1
Output

6
Explanation

If we set the marker at 6 then Kevin can eat following fruits from each bucket: 0 (1st bucket) + 2 (2nd bucket) + 14 (bucket) + 0 (4th bucket) = 16 (K)

Constraints
1 <= N <= 10^4

1 <= M <= 10^6

0 <= ARR[i] <= 10^4

Topics
Binary Search
Companies
Amazon
Apple
