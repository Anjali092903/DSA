import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        // Input the number and type of balls in the first box
        int firstBox = sc.nextInt();

        // Input the number and type of balls in the second box
        int secondBox = sc.nextInt();

        // Determine the chamber based on the sign of the balls in both boxes
        if (firstBox > 0 && secondBox > 0) {
            // Both boxes have blue balls
            System.out.println(1);
        } else if (firstBox < 0 && secondBox > 0) {
            // First box has red balls, second box has blue balls
            System.out.println(2);
        } else if (firstBox < 0 && secondBox < 0) {
            // Both boxes have red balls
            System.out.println(3);
        } else if (firstBox > 0 && secondBox < 0) {
            // First box has blue balls, second box has red balls
            System.out.println(4);
        }
 
    }
}




Quadrants
Four friends are in a mystery room and they aim to get out of the mystery room by cracking the final trail. The mystery room is divided into four chambers and each chamber will have two boxes storing balls. Now if both the boxes have blue balls, it must belong to chamber 1. Similarly if the first box has red balls and second box has blue balls, they must belong to chamber 2. If both the boxes have red balls, they must belong to chamber 3. Finally if the first box has blue balls and second box has red balls, it must belong to chamber 4.

You are given number of balls in each box and if the number has a negative sign it means the balls are red else the balls are blue if the sign is positive. Determine the chamber the two boxes belong to given the number and type of balls in each box.

Note: Assume there will always be non-zero number of balls in each box.

Input
The input consists of two lines.

The first line of input denotes the number and type of balls in the first box.

The second line of input denotes the number and type of balls in the second box.

Output
Output the chamber number (1, 2, 3 or 4) for the given count of balls in each box.

Example 1
Input

10
6
Output

1
Explanation: The first box has 10 blue balls and the second box has 6 blue balls hence it belongs to chamber 1.

Example 2
Input

9
-13
Output

4
Explanation: The first box has 9 blue balls and the second box has 13 red balls hence it belongs to chamber 4.
