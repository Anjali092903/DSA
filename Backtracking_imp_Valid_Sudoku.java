
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    sc.close();
    if (isValidSudoku(board)) {
      System.out.println("correct");
    } else {
      System.out.println("incorrect");
    }
  }

  public static boolean isValidSudoku(char[][] board) {
    // Check each row
    for (int i = 0; i < 9; i++) {
      if (!isValidGroup(board[i])) {
        return false;
      }
    }

    // Check each column
    for (int j = 0; j < 9; j++) {
      char[] column = new char[9];
      for (int i = 0; i < 9; i++) {
        column[i] = board[i][j];
      }
      if (!isValidGroup(column)) {
        return false;
      }
    }

    // Check each 3x3 sub-box
    for (int boxRow = 0; boxRow < 3; boxRow++) {
      for (int boxCol = 0; boxCol < 3; boxCol++) {
        char[] subBox = new char[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            subBox[index++] = board[boxRow * 3 + i][boxCol * 3 + j];
          }
        }
        if (!isValidGroup(subBox)) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean isValidGroup(char[] group) {
    Set<Character> seen = new HashSet<>();
    for (char c : group) {
      if (c != '.' && !seen.add(c)) {
        return false;
      }
    }
    return true;
  }
}






Valid Sudoku
Determine if a 9 x 9 Sudoku board is valid. Check for only the filled cells with the rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
Input Format
Input consists of 9 rows:

In each row, there are 9 spaced characters representing the number at that position of the board

Output Format
If the sudoku is valid, print "correct" else print "incorrect"

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

The given grid follows the rules of a valid sudoku

Example 2
Input

. 5 9 1 2 . . 8 3 
. 5 . 3 6 7 2 . 9
3 . 2 5 8 . 6 1 7
1 2 5 9 . 3 8 . 6
. 3 . 8 1 . 9 2 4
4 9 . 2 7 6 3 5 1
. 1 . 6 9 8 7 3 5
9 . . 4 . . 1 6 8
5 8 6 7 3 1 4 9 2
Output

incorrect
Explanation

In the second column, 5 comes twice, hence the rule gets violated

Constraints
board[i][j] = '.' or 1 <= board[i][j] <= 9

Topics
2D-Arrays
Companies
Amazon
Google
