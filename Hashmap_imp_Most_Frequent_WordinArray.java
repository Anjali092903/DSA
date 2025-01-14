import java.io.*;
import java.util.*;

class Solution {
    public void mostFrequent(String[] arr, int n) {
        // HashMap to store the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        // LinkedHashMap to maintain the last occurrence of each word
        Map<String, Integer> lastOccurrenceMap = new LinkedHashMap<>();
        
        // Populate the maps
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            lastOccurrenceMap.put(word, i); // Record the last occurrence
        }
        
        String mostFrequentWord = null;
        int maxFrequency = 0;
        int latestOccurrence = -1;
        
        // Find the word with the highest frequency
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            int occurrence = lastOccurrenceMap.get(word);
            
            // Update the most frequent word based on conditions
            if (frequency > maxFrequency || (frequency == maxFrequency && occurrence > latestOccurrence)) {
                mostFrequentWord = word;
                maxFrequency = frequency;
                latestOccurrence = occurrence;
            }
        }
        
        // Print the result
        System.out.print(mostFrequentWord);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.next();
        }
        Solution Obj = new Solution();
        Obj.mostFrequent(arr, n);
        System.out.println();
    }
}




Most Frequent Word in Array
Given an array arr containing N words consisting of lowercase characters. Your task is to find the most frequent word in the array. If multiple words have same frequency, then print the word whose first occurence occurs last in the array as compared to the other strings with same frequency.

Input Format
Input consist of two lines. The first line contains a number N representing the size of the array. Next line consists of N words separated by space.

Output Format
Print a single word which is the most frequent word in the array.

Example 1
Input

3
geeks for geeks
Output

geeks
Explanation

"geeks" comes 2 times.

Example 2
Input

2
hello world
Output

world
Explanation

"hello" and "world" both have 1 frequency. We print "world" as its first occurrence comes last in the input array.

Constraints
1 <= N <= 50000

1 <= |each string| <= 50

Note: Sum of length of all strings does not exceed 5*10^5

Topics
Hashing
Companies
Citrix
Adobe
Microsoft
