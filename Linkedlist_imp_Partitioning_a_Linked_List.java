import java.io.*;
import java.util.*;


class Node {
    int data;
    Node next;

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

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Solution class containing the partition function
class Solution {
    public Node partition(Node head, int x) {
        // Dummy nodes to track the start of 'less than x' and 'greater/equal to x' partitions
        Node beforeHead = new Node(0); // Dummy node for 'less than x'
        Node before = beforeHead; // Pointer to track the last node of 'before' list
        Node afterHead = new Node(0); // Dummy node for 'greater/equal to x'
        Node after = afterHead; // Pointer to track the last node of 'after' list

        Node current = head;

        // Traverse the original list and partition nodes into 'before' and 'after' lists
        while (current != null) {
            if (current.data < x) { // If the node value is less than x
                before.next = current; // Append to 'before' list
                before = before.next;
            } else { // If the node value is greater than or equal to x
                after.next = current; // Append to 'after' list
                after = after.next;
            }
            current = current.next; // Move to the next node
        }

        // Connect the two partitions
        after.next = null; // Ensure the last node of 'after' list does not link back
        before.next = afterHead.next; // Merge the two lists

        return beforeHead.next; // Return the head of the modified linked list
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

        int x = sc.nextInt(); 
        Solution ob = new Solution();
        l1.head = ob.partition(l1.head, x); 
        l1.printList(); 
    }
}





Partitioning a Linked List
The task is to reorganize the elements in a linked list such that all elements with a value less than a certain number x come before all elements with a value greater than or equal to x. The relative order of the elements within each partition should be preserved.

Input Format
First line contains n, number of nodes in the linked list.

Second line contains the nodes of the linked list.

Output Format
Print the reorganized linked list.

Example 1
Input

6
1 6 2 5 3 4
3
Output

1 2 6 5 3 4
Example 2
Input

5
1 5 2 4 3
4 
Output

1 2 3 5 4
Constraints
1 <= n <= 1000

Topics
Linked lists
Companies
Microsoft
