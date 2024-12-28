import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];

    // Input the Sudoku board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0); // Read each character
      }
    }
    sc.close();

    // Solve the Sudoku and check validity
    if (solveSudoku(board)) {
      System.out.println("correct"); // Print "correct" if solved
    } else {
      System.out.println("incorrect"); // Print "incorrect" if unsolvable
    }
  }

  // Solves the Sudoku using backtracking
  public static boolean solveSudoku(char[][] board) {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        // If the cell is empty
        if (board[row][col] == '.') {
          // Try placing digits 1-9
          for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
              board[row][col] = num; // Place the number

              // Recursively try to solve the rest of the board
              if (solveSudoku(board)) {
                return true; // If solved, return true
              }

              // Backtrack: Undo the placement
              board[row][col] = '.';
            }
          }
          return false; // If no number fits, return false
        }
      }
    }
    return true; // If no empty cells are left, the board is solved
  }

  // Checks if placing a number is valid
  public static boolean isValid(char[][] board, int row, int col, char num) {
    // Check the row
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == num) {
        return false;
      }
    }

    // Check the column
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == num) {
        return false;
      }
    }

    // Check the 3x3 sub-box
    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;
    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        if (board[i][j] == num) {
          return false;
        }
      }
    }

    return true; // If all checks pass, the placement is valid
  }
}








Do you like this question ?
Question
hard
Max Score: 50
Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

Sudoku rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
Input Format
Input consists of 9 rows:

In each row, there are 9 spaced characters representing the number at that position of the board

Output Format
You just have to complete the function, the compiler will print correct if your result is valid else it prints incorrect.

Example 1
Input

. 6 9 1 2 . . 8 3 
. 5 . 3 6 7 2 . 9
3 . 2 5 8 . 6 1 7
1 2 5 9 . 3 8 . 6
. 3 . 8 1 . 9 2 4
4 9 . 2 7 6 3 5 1
. 1 . 6 9 8 7 3 5
9 . . 4 . . 1 6 8
5 8 6 7 3 1 4 9 2
Output

correct
Explanation

The solved sudoku will be:

7 6 9 1 2 4 5 8 3
8 5 1 3 6 7 2 4 9
3 4 2 5 8 9 6 1 7 
1 2 5 9 4 3 8 7 6
6 3 7 8 1 5 9 2 4
4 9 8 2 7 6 3 5 1
2 1 4 6 9 8 7 3 5
9 7 3 4 5 2 1 6 8
5 8 6 7 3 1 4 9 2
Example 2
Input

4 9 3 1 2 . 7 8 6 
5 1 . 7 . . 3 4 9
. 8 7 3 . 9 . . 2
3 4 5 9 1 2 8 6 7
1 2 8 4 . . 5 9 3
. 6 9 . 3 . 4 2 1
. 3 1 6 5 4 . . 8
2 5 6 8 7 3 9 1 4
. 7 . 2 9 1 . . 5
Output

correct
Explanation

The correct sudoku will be:

4 9 3 1 2 5 7 8 6 
5 1 2 7 8 6 3 4 9
6 8 7 3 4 9 1 5 2
3 4 5 9 1 2 8 6 7
1 2 8 4 6 7 5 9 3
7 6 9 5 3 8 4 2 1
9 3 1 6 5 4 2 7 8
2 5 6 8 7 3 9 1 4
8 7 4 2 9 1 6 3 5
Constraints
board[i][j] = '.' or 1 <= board[i][j] <= 9

Topics
Recursion
2D-Arrays
Companies
Amazon
Directi
Paypal
Oracle
MAQ Software
Flipkart
MakeMyTrip
Microsoft
Ola
Zoho
