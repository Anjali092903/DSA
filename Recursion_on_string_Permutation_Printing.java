import java.util.*;
class Accio {
    
    public void printPermutations(String str) {
        
        printPermutation(str, ""); // Start recursive process
    }
    public void printPermutation(String str, String psf){
        // Base Case: If no characters are left, print the accumulated permutation
        if(str.length() == 0){ 
            System.out.println(psf); // Print the completed permutation
        }

     char prev = ' ';  // To track previously processed characters

          // Loop through each character in the string
           for(int i=0; i < str.length(); i++){
           char ch = str.charAt(i); // Current character
             // Skip duplicate characters
           if(prev == ch){
            continue;
           }
           prev = ch;  // Update the previous character

        // Generate the remaining string by excluding the current character
            String left = str.substring(0,i);  // Characters before `ch`
            String right = str.substring(i+1, str.length());
            String ros = left + right; // Remaining string after removing `ch`
             // Recursive call with the updated remaining string and partial solution
            printPermutation(ros, psf + ch);
    }

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Accio Obj = new Accio();
        Obj.printPermutations(str);
    }
}



Permutation Printing
You are given a string str.

Complete the body of permutationPrint function - without changing signature - to calculate and print all permutations of str. Print the unique permutations in lexicographic order.

Use sample input and output to take idea about permutations.

Note

The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
The first line of input contains a string str.

Output Format
Print all the permutations of the given string.

Example 1
Input

abc
Output

abc
acb
bac
bca
cab
cba
Explanation

The given string abc has 6 permutations, abc,acb,bac,bca,cab,cba.

Example 2
Input

ab
Output

ab
ba
Explanation

The given string ab has 2 permutations ab and ba.

Constraints
1 <= |str| <= 5

Topics
Recursion
