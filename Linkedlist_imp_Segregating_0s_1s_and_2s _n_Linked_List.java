import java.io.*;
import java.util.*;

// Node class to represent each element in the linked list
class Node {
    int data;
    Node next;
    
    // Constructor to initialize a node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    Node head;
    
    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
    }
    
    // Function to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Solution class to implement the segregation logic
class Solution {
    static void unfold(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Count the occurrences of 0s, 1s, and 2s
        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        // Step 2: Modify the linked list to reflect sorted order
        temp = head;
        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        while (count2-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1 = new LinkedList();
        
        
        for (int i = 0; i < n; i++) {
            l1.add(sc.nextInt());
        }
       
        Solution.unfold(l1.head);
    
        l1.printList();
    }
}




Segregating 0s, 1s, and 2s in a Linked List
The task is to rearrange the elements of a linked list such that all the 0s are at the beginning of the list, followed by the 1s, and then the 2s.

Input Format
First line contains n, number of nodes in the linked list.

Second line contains the nodes of the linked list.

Output Format
Print the reorganized linked list.

Example 1
Input

10
0 1 1 1 2 0 1 0 1 1
Output

0 0 0 1 1 1 1 1 1 2
Example 2
Input

5
0 1 2 0 1
Output

0 0 1 1 2
Constraints
1 <= n <= 1000

Topics
Linked lists
Companies
Amazon
MakeMyTrip
Microsoft
