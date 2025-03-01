import java.util.*;
import java.io.*;


class Node {
    int data;   
    Node next; 
    Node prev;  

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
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
        new_node.prev = current;
    }
}

class Solution {
    // Function to insert a node at the head of the doubly linked list
    static Node insertAtHead(Node head, int K) {
        // Create a new node with the given value K
        Node new_node = new Node(K);
        
        // If the list is empty, the new node becomes the head
        if (head == null) {
            return new_node;
        }

        // Connect the new node to the existing head
        new_node.next = head;
        head.prev = new_node;

        // Return the new head of the list
        return new_node;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of nodes (N) and the value to be inserted (K)
        int N = sc.nextInt();
        int K = sc.nextInt();
    
        LinkedList list = new LinkedList();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        Node head = Solution.insertAtHead(list.head, K);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}




Insert node in a doubly linked list
You are given a Doubly linked list and an integer K where every node in the linked list contains two pointers next and prev which point to the next node and previous node in the list respectively. Your task is to insert the integer K at the head of the given linked list.

You have to complete insertAtHead function which contains head node and integer K i.e. value to be added as inputs and you have to return new linkedlist formed after adding node

Input Format
The first line contains an integer N and K.

The next line contains N integers, the elements of the Doubly linked list.

Output Format
Print the updated Doubly linked list in new line.

Example 1
Input

5 2
1 2 3 4 5
Output

2 1 2 3 4 5
Explanation

The initial linked list is 1->2->3->4->5. Insert 2 at the position 0 i.e. head, which currently 1 has in it. The updated linked list is 2->1->2->3->4->5

Example 2
Input

6 8
7 6 1 5 4 9 
Output

8 7 6 1 5 4 9
Explanation

The initial linked list is 7->6->1->5->4->9. Insert 8 at the position 0 i.e. head, which currently 7 has in it. The updated linked list is 8->7->6->1->5->4->9

Constraints
1 <= N <= 1000

1 <= K <= 1000

Topics
Linked lists
Companies
Visa
Goldman Sachs
Rubrik
Morgan Stanley
