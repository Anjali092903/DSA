
import java.util.*;
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Main {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        addToTheLast(head);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            addToTheLast(new Node(a));
        }

        Solution abc=new Solution();
        Node node = abc.quickSort(head);

        printList(node);
        System.out.println();
    
        sc.close();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

class Solution {
    
    public static Node quickSort(Node head) {
        // Base case: if the list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Partition the list and get the pivot node
        Node pivot = head; // Choosing the first node as pivot
        Node leftHead = null, leftTail = null; // For nodes less than pivot
        Node rightHead = null, rightTail = null; // For nodes greater than pivot
        Node current = head.next; // Start from the second node

        // Partitioning the list
        while (current != null) {
            if (current.data < pivot.data) {
                // Add to left partition
                if (leftHead == null) {
                    leftHead = current;
                    leftTail = current;
                } else {
                    leftTail.next = current;
                    leftTail = leftTail.next;
                }
            } else {
                // Add to right partition
                if (rightHead == null) {
                    rightHead = current;
                    rightTail = current;
                } else {
                    rightTail.next = current;
                    rightTail = rightTail.next;
                }
            }
            current = current.next; // Move to the next node
        }

        // Terminate the left and right lists
        if (leftTail != null) {
            leftTail.next = null; // End the left list
        }
        if (rightTail != null) {
            rightTail.next = null; // End the right list
        }

        // Recursively sort the left and right partitions
        leftHead = quickSort(leftHead);
        rightHead = quickSort(rightHead);

        // Combine the sorted left partition, pivot, and sorted right partition
        if (leftHead == null) {
            pivot.next = rightHead; // If there is no left partition
            return pivot; // Return the pivot as the new head
        }

        // Find the end of the left partition
        Node temp = leftHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = pivot; // Connect the end of left partition to pivot
        pivot.next = rightHead; // Connect pivot to right partition

        return leftHead; // Return the new head of the sorted list
    }
}


Quick Sort on Linked List
Given the head node of a linked list, sort the list using quick sort.

Input Format
The first line of input contains a single integer n.

The second line of input contains n space seperated integers.

Output Format
Sort the given linked list, using quick sort.

Example 1
Input

3
1 6 2
Output

1 2 6
Explanation

After sorting the nodes, we have 1, 2 and 6.

Example 2
Input

4
1 9 3 8
Output

1 3 8 9
Explanation

After sorting the nodes, we have 1, 3, 8 and 9.

Constraints
1 <= n <= 2*104

Topics
Linked lists
Sorting
Companies
PayTM
