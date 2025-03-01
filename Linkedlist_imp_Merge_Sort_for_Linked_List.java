import java.util.*;

class Node {
    int data;  // Data value of the node
    Node next; // Pointer to the next node

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
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

class Solution {
    // Merge Sort function for Linked List
    public static Node mergesort(Node head) {
        // Base case: If the list is empty or has one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle of the linked list
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;

        // Break the list into two halves
        middle.next = null;

        // Step 2: Recursively sort the two halves
        Node leftHalf = mergesort(head);
        Node rightHalf = mergesort(nextToMiddle);

        // Step 3: Merge the sorted halves
        return merge(leftHalf, rightHalf);
    }

    // Function to find the middle of the linked list (using slow & fast pointers)
    private static Node getMiddle(Node head) {
        if (head == null) return head;
        
        Node slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;      // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }
        return slow; // Slow pointer is at the middle
    }

    // Function to merge two sorted linked lists
    private static Node merge(Node left, Node right) {
        // Dummy node to simplify merging
        Node dummy = new Node(-1);
        Node temp = dummy;

        // Merge two sorted lists
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        // Append remaining nodes if any
        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next; // The real head of the merged list
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList list = new LinkedList();

   
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }

        Solution obj = new Solution();
        list.head = obj.mergesort(list.head);
        Node curr = list.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}



Merge Sort for Linked List
Given a linked list of n nodes, the task is to sort the given linked list using Merge Sort.

Input Format
First line contains an integer n, which is the number of nodes

Second line contains n space separated integers

Output Format
Print the sorted list

Example 1
Input

5
3 5 2 4 1
Output

1 2 3 4 5
Explanation:

The sorted array is 1 2 3 4 5

Example 2
Input

6
3 5 2 4 1 6
Output

1 2 3 4 5 6
Explanation:

The sorted array is 1 2 3 4 5 6

Constraints
1 <= n <= 105

1 <= node.data <= 103

Topics
Linked lists
Sorting
Companies
PayTM
Amazon
Veritas
Adobe
MAQ Software
Microsoft
Accolite
