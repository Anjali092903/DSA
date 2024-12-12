import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    // Add a new node to the end of the linked list
    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

public class Main {
    // Function to reverse and print the linked list without using stack
    public static void reverse(Node curr) {
        if (curr == null) {
            return;
        }
        // Recursively print the next nodes
        reverse(curr.next);
        // Print the current node after recursive calls
        System.out.print(curr.data + " ");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        // Read the number of elements in the linked list
        int n = input.nextInt();
        
        // Read the elements and add them to the linked list
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            list.add(x);
        }

        // Print the linked list in reverse
        reverse(list.head);
        System.out.println("");
        
        input.close();
    }
}








Print in Reverse
Given an integer n denoting number of elements in linked list. And then we are given n integers where the ith integer denoted ith element of linked list. We need to print the linked list in reverse i.e from tail to head.

Your task is to complete the function reverse which receives the head of the linked list as parameter and prints the linked list in reverse order.

Input Format
The First line of input contains a single integer n denoting size of linked list The Second line contains n integers where ith integer denotes ith element of linked list

Output Format
Ouput linked list in reverse order i.e from last node(tail) to head node

Example 1
Input

5
2 6 8 10 1
Output:

1 10 8 6 2
Example 2
Input

6
1 2 3 4 5 6
Output:

6 5 4 3 2 1
Constraints:
1 <= n <= 5*10^3

Topics
Linked lists
Companies
Intuit
Samsung
PayTM
Amazon
Goldman Sachs
Adobe
Tech Mahindra
Cisco
VMware
Snapdeal
MakeMyTrip
DE Shaw
Qualcomm
Walmart Global Tech
Microsoft
SAP
Zoho
Accolite
Cognizant
