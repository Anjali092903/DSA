import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // Length of the string
        input.nextLine();
        String str = input.nextLine(); // Input string

        solve(str);

        input.close();
    }

    // Function to check if a number is an AJ number
    public static boolean isAJNumber(long num) {
        if (num < 2) return false; // 0 and 1 are not AJ numbers
        int[] ajNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int aj : ajNumbers) {
            if (num == aj) return true; // Direct match with AJ numbers
            if (num % aj == 0) return false; // Divisible by an AJ number
        }
        return true; // Not divisible by any AJ numbers
    }

    // Function to find the maximum number of AJ numbers using backtracking
    public static int findMaxAJNumbers(String str, int index, List<Long> chosen) {
        if (index == str.length()) {
            return chosen.size();
        }

        int maxCount = 0;
        for (int i = index; i < str.length(); i++) {
            String subStr = str.substring(index, i + 1);

            // Skip substrings starting with zero (except "0" itself)
            if (subStr.length() > 1 && subStr.startsWith("0")) continue;

            long num = Long.parseLong(subStr); // Convert substring to number

            // Check if the substring is an AJ number
            if (isAJNumber(num)) {
                // Add the current AJ number to the chosen list
                chosen.add(num);

                // Recursively find maximum AJ numbers
                maxCount = Math.max(maxCount, findMaxAJNumbers(str, i + 1, chosen));

                // Backtrack and remove the last chosen number
                chosen.remove(chosen.size() - 1);
            }
        }

        // Return the maximum count
        return Math.max(maxCount, findMaxAJNumbers(str, index + 1, chosen));
    }

    public static void solve(String str) {
        List<Long> chosen = new ArrayList<>(); // To track the chosen AJ numbers
        System.out.println(findMaxAJNumbers(str, 0, chosen)); // Output the result
    }
}






AJ Number
Deepak and Gautam are having a discussion on a new type of number that they call AccioJob Number or AJ Number. They use following criteria to define a AJ Number.

0 and 1 are not a AJ number.

2,3,5,7,11,13,17,19,23,29 are AJ numbers.

Any number not divisible by the numbers in point 2( Given above) are also AJ numbers.

Deepak said he loved AJ numbers.Hearing it, Gautam throws a challenge to him.

Gautam will give Deepak a string of digits. Deepak's task is to find the number of AJ numbers in the string.

AJ number once detected should not be sub-string or super-string of any other AJ number.

Ex- In 4991, both 499 and 991 are AJ numbers but you can choose either 499 or 991, not both.

Further, the AJ number formed can only be a sub-string of the string.

Ex - In 481, you can not take 41 as AJ number because 41 is not a sub-string of 481.

As there can be multiple solutions, Gautam asks Deepak to find the maximum number of AJ numbers that can be formed from the given string.

Deepak has to take class of Launchpad students. Help him by solving Gautam's challenge.

Input Format
The first line of input contains n, the size of string.

The second line of input contains a string of digits str.

Output Format
Maximum number of AJ numbers that can be formed.

Example 1
Input

5
81615
Output

2
Explanation

61 and 5 are two AJ numbers.

Example 2
Input

2
10
Output

0
Explanation

There is 0 AJ number in this string of numbers.

Constraints
1 <= N <= 17

Topics
Strings - Basics
Strings
