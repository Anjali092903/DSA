import java.util.*;
import java.io.*;

// Node class represents an individual node in the linked list
class Node {
    int data; // Value stored in the node
    Node next; // Reference to the next node in the linked list

    // Constructor to initialize a node with data
    Node(int data) {
        this.data = data;
        next = null;
    }
}

// LinkedList class to manage the linked list operations
class LinkedList {
    Node head; // Head of the linked list

    // Add a new node to the end of the linked list
    void add(int data) {
        Node new_node = new Node(data); // Create a new node with the given data
        if (head == null) { // If the linked list is empty, make the new node the head
            head = new_node;
            return;
        }
        Node curr = head; // Start from the head
        while (curr.next != null) // Traverse to the end of the linked list
            curr = curr.next;
        curr.next = new_node; // Attach the new node at the end
    }
}

// Solution class containing the logic to merge two sorted linked lists
class Solution {
    // Merge function to merge two sorted linked lists
    public static Node merge(Node l1, Node l2) {
        if (l1 == null) return l2; // If the first list is empty, return the second list
        if (l2 == null) return l1; // If the second list is empty, return the first list

        Node dummy = new Node(0); // Dummy node to simplify the merging logic
        Node tail = dummy; // Pointer to build the merged linked list

        // Loop until either of the lists is exhausted
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) { // Choose the smaller node
                tail.next = l1; // Attach l1 to the merged list
                l1 = l1.next; // Move to the next node in l1
            } else {
                tail.next = l2; // Attach l2 to the merged list
                l2 = l2.next; // Move to the next node in l2
            }
            tail = tail.next; // Move the tail pointer forward
        }

        // Attach the remaining nodes of the non-empty list
        if (l1 != null) {
            tail.next = l1; // Attach remaining nodes of l1
        } else {
            tail.next = l2; // Attach remaining nodes of l2
        }

        return dummy.next; // Return the merged list starting from the next node of dummy
    }
}

// Main class to handle input/output and invoke the merge operation
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Input first linked list
        int n = sc.nextInt(); // Read the size of the first linked list
        LinkedList l1 = new LinkedList();
        for (int i = 0; i < n; i++) {
            l1.add(sc.nextInt()); // Add elements to the first linked list
        }

        // Input second linked list
        int m = sc.nextInt(); // Read the size of the second linked list
        LinkedList l2 = new LinkedList();
        for (int i = 0; i < m; i++) {
            l2.add(sc.nextInt()); // Add elements to the second linked list
        }

        // Merge the linked lists
        Node head = Solution.merge(l1.head, l2.head);

        // Print the merged linked list
        while (head != null) { // Traverse and print each node
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(); // Print a newline at the end

        sc.close(); // Close the scanner
    }
}






Merge Two Sorted Linked Lists
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Input Format
The format for each test case is as follows:

The first line contains an integer n, the length of the first linked list.
The next line contain n integers, the elements of the linked list.
The next line contains an integer m , the length of the second linked list.
The next lines contain m integers, the elements of the second linked list.

Output Format
Output a single line of (n + m) integers consisting all elements of linked lists in sorted order.

Example 1


Input

3
1 2 4
3
1 3 4
Output

1 1 2 3 4 4
Explanation

Merge the two linked list

Example 2
Input

3
1 5 9
3
1 3 4
Output

1 1 3 4 5 9
Explanation

Merge the two linked list in sorted order

Constraints
The number of nodes in both lists is in the range [0, 50].

-100 <= Node.val <= 100

Both list1 and list2 are sorted in non-decreasing order.

Topics
Linked lists
Sorting
Companies
Samsung
Amazon
FactSet
Oracle
Flipkart
MakeMyTrip
Microsoft
Zoho
Accolite
Synopsys
