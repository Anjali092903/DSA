import java.util.*;
import java.io.*;

class Solution {
    static boolean savePerson(int n, int[] vaccinePigment, int[] personPigment) {
        // Sort both arrays to match the smallest vaccine to the smallest patient need
        Arrays.sort(vaccinePigment);
        Arrays.sort(personPigment);

        // Compare sorted arrays
        for (int i = 0; i < n; i++) {
            // If any patient's pigment requirement exceeds the corresponding vaccine, return false
            if (vaccinePigment[i] <= personPigment[i]) {
                return false;
            }
        }

        // If all patients are covered
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] vaccinePigment = new int[n];
        int[] personPigment = new int[n];
        for (int i = 0; i < n; i++) {
            vaccinePigment[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            personPigment[i] = sc.nextInt();
        }
        if (Solution.savePerson(n, vaccinePigment, personPigment)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}




Save from the Disease
A new disease has infected a good amount population of a country. Scientists made vaccines which can cure this disease. Vaccine has various strength depending on a special pigment count. A person is cured only if pigment count in vaccine batch is more than pigment count of person. A hospital receives a new set of report which contains pigment count of each infected patient, hospital data department stores all vaccine doctor has and their pigment count. You need to determine if doctor can save all patients with the vaccines he has. The number of vaccines and patients are equal. Note that a vaccine can be given to one random patient and it doesn't have to be in the given order.

You have to complete save function which consists of vaccinePigment and personPigment arrays of size n as input and returns boolean answer as output

Input Format
First line contains the number of vaccines - N.

Second line contains N integers, which are pigment count of vaccines.

Third line contains N integers, which are pigment count of patients.

Output Format
Print a single line containing boolean 'true' or 'false'.

Example 1
Input

5
342 564 123 234 276
100 343 609 456 213
Output

false
Explanation

No matter how you give the vaccines, there will always be two patients who don't have correct vaccines.

Example 2
Input

4
546 454 742 456
328 248 689 200
Output

true
Explanation

Here, for each index, person's pigment count is less than vaccine's pigment count so doctor will save each and every patient.

Constraints
1 ≤ N ≤ 10

1 ≤ vaccinePigment[i], personPigment[i] ≤ 10^6
