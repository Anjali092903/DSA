import java.util.*; 
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] trips = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                trips[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
       
        Solution obj = new Solution();
        System.out.println(obj.carPooling(trips, k));
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Create an array to keep track of the passengers at each point (0 to 1000 km)
        int[] passengers = new int[1001]; // because maximum distance is 1000
        
        // Mark pick-ups and drop-offs
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            passengers[from] += numPassengers; // pick-up passengers
            passengers[to] -= numPassengers;   // drop-off passengers
        }
        
        int currCapacity = 0;
        // Traverse through the points from 0 to 1000
        for (int i = 0; i <= 1000; i++) {
            currCapacity += passengers[i];
            if (currCapacity > capacity) {
                return false; // capacity exceeded
            }
        }
        
        return true; // all trips handled successfully
    }
}






Car pooling
There is a car with k empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Input Format
The first line of input contains an integer n which represents the size of the array.

The next n lines contains 3 integers representing number of passengers, starting point and ending point respectively.

The next line contains an integer k which represents the capacity of the car.

Output Format
Print true or false whether it is possible to pick up and drop off all the passengers for all the given trips.

Example 1
Input

2
2 1 5
3 3 7
5
Output

true
Explanation

At first the car picks up 2 people at starting point 1 and at starting point 3 the car picks up 3 people. Hence the output is true as the car can deliver all the people at their desired location.

Example 2
Input

2
2 1 5
3 3 7
4
Output

false
Explanation

The capacity of the car is 4 therefore at starting point 3 the car cannot pickup all the 3 people hence the output is false.

Constraints
1 <= n <= 1000
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= k <= 10^5 
Topics
2D-Arrays
Heaps
Sorting
Prefix Sum
