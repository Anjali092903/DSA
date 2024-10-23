Conditional Problem 1
Given an integer n. Your task is to write a program to use switch case as follows :

if the input number is 28, print i am young.
else print i am not young.
Input Format
First line contains an integer n.

Output Format
Print the statement based on value of n as given above.

Example 1
Input

28
Output

i am young
Example 2
Input

30
Output

i am not young




import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Read the input integer n
        int n = sc.nextInt();

         // Use switch case to check the value of n
        switch (n) {
            case 28:
                System.out.println("i am young");
                break;
            default:
                System.out.println("i am not young");
                break;
        }
        
    }
}


Conditional Problem 2
You are given a number N. Write a program using If Else such that if N is less than 30 then the output will be "less important" otherwise the output will be "more important".

Input Format
The first line contains an integer.

Output Format
If the number is less than 30 then "less important" will be printed. If the number is not less than 30 then "more important" will be printed.

Example 1
Input

30
Output

more important
Explanation

Since 30 is not less than 30 answer is "more important".

Example 2
Input

23
Output

less important
Explanation

Since 23 is less than 30 answer is "less important".


  import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{   //creating scanner object for taking input
		Scanner sc= new Scanner(System.in);
		//taking user input
		int n=sc.nextInt();
		 // Close the scanner object
        sc.close();

		// Use if-else to determine the output based on the value of N
        if (n < 30) {
            System.out.println("less important");
        } else {
            System.out.println("more important");
        }
        
	}
}



Conditional Problem 3
You are provided with a number n.

Your task is to return a string according to the following conditions:

If the number is greater than 1, then return You entered more
If the number is less than or equal to 1 then return You entered less

Input Format
First line contains a positive integer n.

Output Format
Return the output as per instruction in the input.

Example 1
Input

1
Output

You entered less
Explanation

Since 1 = 1, you entered less is printed.

Example 2
Input

5
Output

You entered more
Explanation

Since 5 > 1, you entered more is printed.


  import java.util.*;
public class Main {

    public static void main(String[] args) throws Throwable {
    
        //creating scanner object for taking input
		Scanner sc= new Scanner(System.in);
		//taking user input
		int n=sc.nextInt();
		 // Close the scanner object
        sc.close();

         // Use if-else to determine the output based on the value of N
        if (n <= 1) {
            System.out.println("You entered less ");
        } else {
            System.out.println("You entered more");
        }

    }
}



  Conditional Problem 5
Given a number n, If the number is divisible by 6 then print Divisible else Not divisible.

Input Format
First line contains an integer.

Output Format
If the number is divisible by 6 then Divisible will be printed. If the number is not divisible by 6 then Not divisible will be printed.

Example 1
Input

28
Output

Not divisible
Explanation

28 is not divisible by 6.

Example 2
Input

24
Output

Divisible
Explanation

24 is divisible by 6.



  import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);

         // Read the integer input
        int n = sc.nextInt();

        // Check if the number is divisible by 6
        if (n % 6 == 0) {
            System.out.println("Divisible");
        } else {
            System.out.println("Not divisible");
        }
        
       

    }
}


Conditional Problem 6
You are given two integers a and b. You need to perform the following operations

If both integers are odd, print `we are odd`.
Else print `we are simple`.
Input Format
First line contains two variables a and b.

Output Format
Output will be "we are odd" if both the variables are odd numbers. Otherwise output will be "we are simple".

Example 1
Input

1 3
Output

we are odd
Example 2
Input

2 5
Output

we are simple



  import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        
        // Read two integers a and b
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Check if both a and b are odd
        if (a % 2 != 0 && b % 2 != 0) {
            System.out.println("we are odd");
        } else {
            System.out.println("we are simple");
        }
    }
}
