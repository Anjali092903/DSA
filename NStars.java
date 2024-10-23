import java.util.*; // Importing the utility package for Scanner class to handle input
import java.lang.*; // Importing the lang package (not necessary here as it's automatically imported)
import java.io.*; // Importing the I/O package (not used here but commonly included)

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Input n (number of stars to print)
        int n = sc.nextInt(); // Read an integer input from the user

        // Print n stars horizontally
        for (int i = 0; i < n; i++) { // Loop n times
            System.out.print("* "); // Print a star followed by a space
        }
        System.out.println(); // Move to the next line after printing stars

        // Print n stars vertically
        for (int j = 0; j < n; j++) { // Loop n times
            System.out.println("*"); // Print a star on a new line
        }
    }
}
