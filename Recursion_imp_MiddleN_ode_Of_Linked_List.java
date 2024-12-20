import java.util.*;

// Main class to run the program
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in); // Scanner object to take input

        // Input the number of nodes in the linked list
        int n = sc.nextInt();
        
        // Create a new LinkedList object
        LinkedList llist = new LinkedList(); 
        
        // Read the first node value and create the head node
        int a1 = sc.nextInt();
        Node head = new Node(a1); 
        llist.addToTheLast(head); // Add the first node to the list

        // Read the rest of the node values and add them to the linked list
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
        }

        // Create a Solution object and find the midpoint of the linked list
        Solution A = new Solution();
        llist.head = A.midpointOfLinkedList(llist.head); 
        
        // Print the linked list starting from the midpoint
        llist.printList();
    }
}

// Class representing a single node in the linked list
class Node {
    int data; // Value stored in the node
    Node next; // Reference to the next node

    // Constructor to initialize a node
    Node(int d) {
        data = d;
        next = null;
    }
}

// Class representing the linked list
class LinkedList {
    Node head;  // Head of the linked list
    Node tail;  // Tail of the linked list

    // Method to add a node to the end of the linked list
    public void addToTheLast(Node node) {
        // If the list is empty, initialize both head and tail
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // Otherwise, add the node after the current tail and update the tail
            tail.next = node;
            tail = node;
        }
    }

    // Method to print the linked list from the head node to the end
    void printList() {
        Node temp = head; // Start from the head
        while (temp != null) {
            System.out.print(temp.data + " "); // Print the current node's data
            temp = temp.next; // Move to the next node
        }
        System.out.println();
    }
}

// Class containing the solution to find the midpoint of the linked list
class Solution {
    static Node midpointOfLinkedList(Node head) {
        // If the list is empty or has only one node, the head is the midpoint
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers, slow and fast
        Node slow = head; // Slow pointer moves one step at a time
        Node fast = head; // Fast pointer moves two steps at a time

        // Traverse the list until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one node
            fast = fast.next.next; // Move fast pointer by two nodes
        }

        // When the loop ends, slow will point to the midpoint of the linked list
        return slow;
    }
}







Middle Node Of Linked List
Given the head of a linked list, return the middle node of the linked list.

Linked List Structure:

public class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}   
public class LinkedList
{
    Node head;  
    Node tail;
}
Note:- You just need to complete midpointOfLinkedList() function and return the mid point. The driver code will print the second half of the linked list.

Example:

If your list is [5, 4, 3, 2], the function should return the node at index 2, i.e. value 3.

Input Format
You will be provided with an integer n, the number of elements in the linked list.

The next n integers denote the values of the nodes in the linked list.

Output Format
Print the linked list starting from the middle node.

Example 1
Input

4
5 4 3 2
Output:

3 2
Example 2
Input

3
5 7 1
Output:

7 1
Constraints
1 <= n <= 10^5

Topics
Linked lists
Companies
Wipro
Samsung
Amazon
Payu
Adobe
MAQ Software
Hike
Flipkart
VMware
Nagarro
Qualcomm
Microsoft
SAP
Zoho
