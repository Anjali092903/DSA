import java.util.*;

class Solution {
    static int findMin(int arr[], int low, int high) {
        // If the array is not rotated
        if (arr[low] <= arr[high]) {
            return arr[low];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the mid element is the minimum
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            // Check if the element after mid is the minimum
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            // Decide the direction of binary search
            if (arr[mid] >= arr[low]) {
                // Minimum is in the right half
                low = mid + 1;
            } else {
                // Minimum is in the left half
                high = mid - 1;
            }
        }

        return -1; // This should not be reached
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}





Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.

[0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, print the minimum element of this array.

Note: Write an algorithm that runs in O(logn) time.

Input Format
The first line contains a single integer n, number of elements in the array.

The second line contains n space-separated integers representing array nums.

Output Format
Print a single number — the minimum element of this array.

Example 1
Input

5
3 4 5 1 2
Output

1
Explanation

The original array was [1,2,3,4,5] rotated 4 times.

Example 2
Input

7
4 5 6 7 0 1 2
Output

0
Explanation

The original array was [0, 1, 2, 4, 5, 6, 7] rotated 3 times.

Constraints
1 <= n <= 5000

-5000 <= nums[i] <= 5000

All the integers of nums are unique.

Topics
Binary Search
Companies
Samsung
Amazon
Adobe
Snapdeal
Microsoft
Morgan Stanley
