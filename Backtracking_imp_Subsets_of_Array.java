import java.util.*; 

class Main {

   
    public static void sort2DArrayList(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> sublist1, ArrayList<Integer> sublist2) {
                // Compare values up to the minimum of their sizes
                int minLength = Math.min(sublist1.size(), sublist2.size());
                for (int i = 0; i < minLength; i++) {
                    int valueComparison = Integer.compare(sublist1.get(i), sublist2.get(i));
                    if (valueComparison != 0) {
                        return valueComparison;
                    }
                }

              
                return Integer.compare(sublist1.size(), sublist2.size());
            }
        });
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        CalcSubset(0, arr, new ArrayList<>(), main); // Generate subsets using recursion
        return main;
    }

        // Recursive function to calculate subsets
    public static void CalcSubset(int idx, int[] arr, ArrayList<Integer> ssf, ArrayList<ArrayList<Integer>> main) {
        // Base case: if index equals array length, add the current subset and return
        if (idx == arr.length) {
            main.add(new ArrayList<>(ssf));
            return;
        }
        // Include the current element in the subset
        ssf.add(arr[idx]);
        CalcSubset(idx + 1, arr, ssf, main);

        // Exclude the current element from the subset
        ssf.remove(ssf.size() - 1);
        CalcSubset(idx + 1, arr, ssf, main);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            Arrays.sort(A);

            // Generate all subsets
            ArrayList<ArrayList<Integer>> res = subsets(A, n);

            // Sort the subsets lexicographically
            sort2DArrayList(res);

            // Print the sorted subsets
            for (ArrayList<Integer> subset : res) {
                for (int elem : subset) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        }
    }
}





Subsets of Array
Given an array 'A' with 'N' distinct positive integers.

Your task is to find all subsets of the given array.

Input Format
The first line contains an integer 'N' denoting the number of elements.

The second line contains 'N' space-separated integers denoting the elements of the array 'A'.

Output Format
For each test case return an array of arrays, denoting all possible subsets of the array in lexicographically sorted order.

Example 1
Input

3
10 15 20
Output


10 
10 15 
10 15 20 
10 20 
15
15 20 
20
Explanation

All possible subsets of the array have been printed.

Example 2
Input

2
1 2
Output


1
1 2
2
Explanation

All possible subsets of the array have been printed.

Constraints
1 <= N <= 10

1 <= A[i] <= 20

Topics
Recursion - Basics
Recursion
Arrays
Bit Manipulation
Companies
Microsoft
