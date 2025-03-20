import java.util.*;

class Solution {
    public long MinimumPages(int[] A, int B) {
        int n = A.length;
        
        // If the number of students is greater than the number of books, return -1 (invalid case)
        if (B > n) return -1;

        // Finding the search range for binary search
        long maxPages = 0, sumPages = 0;
        for (int pages : A) {
            maxPages = Math.max(maxPages, pages); // Largest single book
            sumPages += pages; // Total sum of pages
        }

        // Binary search range
        long low = maxPages, high = sumPages, result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2; // Middle value for checking allocation

            if (isPossible(A, B, mid)) {
                result = mid; // Valid allocation, try minimizing
                high = mid - 1;
            } else {
                low = mid + 1; // Not possible, increase min limit
            }
        }

        return result;
    }

    // Check if books can be allocated such that no student gets more than 'maxPages'
    private boolean isPossible(int[] A, int students, long maxPages) {
        int count = 1; // Start with the first student
        long currentPages = 0; // Pages assigned to the current student

        for (int pages : A) {
            if (currentPages + pages > maxPages) { 
                // Assign a new student if adding this book exceeds maxPages
                count++;
                currentPages = pages; // Assign new student this book
                if (count > students) return false; // More students than allowed
            } else {
                currentPages += pages; // Continue assigning to current student
            }
        }

        return true; // Successfully allocated within maxPages constraint
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Number of books
        int B = sc.nextInt(); // Number of students
        int[] A = new int[N]; // Array to store book pages

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A, B)); // Output minimum pages allocated
    }
}






Allocate Minimum Number Of Pages
You are given N number of books. Every ith book has A[i] number of pages.

You have to allocate contagious books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book

Input Format
First line contains a two integers N denoting number of books and M number of students

Second Line contains N integers where ith integer denotes number pages in ith book

Output Format
Print minimum value of maximum number of pages allocated to any one student

Example 1
Input

4 2
12 34 67 90
Output

113
Explanation

Allocation can be done in following ways: {12} and {34, 67, 90} Maximum Pages = 191

{12, 34} and {67, 90} Maximum Pages = 157 {12, 34, 67} and {90}  Maximum Pages =113

Therefore, the minimum of these cases is 113, which is selected as the output.

Constraints
1 <= N <= 100000

1 <= A[i] <= 1000000

1 <= M <= 100000

Topics
Binary Search
Heaps
Companies
Amazon
Infosys
Codenation
Google
Microsoft
