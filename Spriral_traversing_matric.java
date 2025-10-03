import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of rows and columns
        int r = sc.nextInt();
        int c = sc.nextInt();

        // Step 2: Create a 2D array (matrix)
        int[][] matrix = new int[r][c];

        // Step 3: Read the matrix elements from user
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Step 4: Call function to print spiral order
        printSpiral(matrix, r, c);

        sc.close();
    }

    // Function to print matrix elements in spiral order
    public static void printSpiral(int[][] matrix, int r, int c) {
        // Define the boundaries
        int top = 0;          // first row index
        int bottom = r - 1;   // last row index
        int left = 0;         // first column index
        int right = c - 1;    // last column index

        // Continue until all elements are traversed
        while (top <= bottom && left <= right) {

            // 1. Traverse from Left → Right along the top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++; // move top boundary down

            // 2. Traverse from Top → Bottom along the right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--; // move right boundary left

            // 3. Traverse from Right → Left along the bottom row
            // (only if there are rows left)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--; // move bottom boundary up
            }

            // 4. Traverse from Bottom → Top along the left column
            // (only if there are columns left)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++; // move left boundary right
            }
        }
    }
}

Spirally traversing a matrix
Given a matrix of size r*c, where r is number of rows and c is number of columns. Traverse the matrix in spiral form.

Input Format
Input consists of two lines

The first line contains two integers r and c which denotes number of rows and columns respectively.

The next r lines contains c spaced integers, which are the elements of the matrix.

Output Format
Print the spiral matrix.

Example 1
Input

4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Output

1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

We iterate spirally and print each element.

Example 2
Input

3 4  
1 2 3 4
5 6 7 8
9 10 11 12
Output

1 2 3 4 8 12 11 10 9 5 6 7


✅ Example Run
Input
Copy code
4 4
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
Step-by-step traversal
Left → Right: 1 2 3 4

Top → Bottom: 8 12 16
Right → Left: 15 14 13
Bottom → Top: 9 5
Left → Right (next layer): 6 7 11 10
Output
Copy code
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10








  Input Matrix
1   2   3   4
5   6   7   8
9  10  11  12
13 14  15  16

📌 Initial Boundaries

top = 0 (first row)

bottom = 3 (last row)

left = 0 (first column)

right = 3 (last column)

🔄 Step-by-Step Traversal
Step 1: Traverse Left → Right (top row)

Row = top = 0, Columns = 0 → 3

Print: 1 2 3 4

Update: top = 1

Step 2: Traverse Top → Bottom (right column)

Column = right = 3, Rows = 1 → 3

Print: 8 12 16

Update: right = 2

Step 3: Traverse Right → Left (bottom row)

Row = bottom = 3, Columns = 2 → 0

Print: 15 14 13

Update: bottom = 2

Step 4: Traverse Bottom → Top (left column)

Column = left = 0, Rows = 2 → 1

Print: 9 5

Update: left = 1

Now Boundaries:

top = 1, bottom = 2, left = 1, right = 2

Step 5: Traverse Left → Right (row = 1)

Row = top = 1, Columns = 1 → 2

Print: 6 7

Update: top = 2

Step 6: Traverse Top → Bottom (col = 2)

Column = right = 2, Rows = 2 → 2

Print: 11

Update: right = 1

Step 7: Traverse Right → Left (row = 2)

Row = bottom = 2, Columns = 1 → 1

Print: 10

Update: bottom = 1

Boundaries After Step 7

top = 2, bottom = 1, left = 1, right = 1
👉 Loop ends (top > bottom)

✅ Final Spiral Order
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

📊 Dry Run Table (for clarity)
Step	Direction	Elements Printed	New Boundaries (top, bottom, left, right)
1	Left → Right	1 2 3 4	top=1, bottom=3, left=0, right=3
2	Top → Bottom	8 12 16	top=1, bottom=3, left=0, right=2
3	Right → Left	15 14 13	top=1, bottom=2, left=0, right=2
4	Bottom → Top	9 5	top=1, bottom=2, left=1, right=2
5	Left → Right	6 7	top=2, bottom=2, left=1, right=2
6	Top → Bottom	11	top=2, bottom=2, left=1, right=1
7	Right → Left	10	top=2, bottom=1, left=1, right=1

👉 That’s the complete dry run for the spiral traversal.
