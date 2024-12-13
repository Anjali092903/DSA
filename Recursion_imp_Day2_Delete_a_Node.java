import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            ll.add(x);
        }

        int size = n;
        int toRemove = input.nextInt();
        Solution s = new Solution();
        s.remove(ll, toRemove, size);
        Node curr = ll.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
        next = null;
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
    public static void remove(LinkedList ll, int toRemove, int size) {
        if (toRemove < 0 || toRemove >= size || ll.head == null) {
            return; // Invalid position or empty list
        }

        // If the node to be removed is the head
        if (toRemove == 0) {
            ll.head = ll.head.next;
            return;
        }

        Node prev = null;
        Node curr = ll.head;
        int index = 0;

        // Traverse to the node just before the target node
        while (index < toRemove) {
            prev = curr;
            curr = curr.next;
            index++;
        }

        // Remove the target node by updating the previous node's next pointer
        if (prev != null && curr != null) {
            prev.next = curr.next;
        }
    }

    public static void printLinkedList(LinkedList ll) {
        Node temp = ll.head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }
}





Delete a Node
Given a linked list and an index, write a function to delete the node at that index from the linked list.

Input Format
The first line of input contains an integer n, the number of elements in the linked list.

Each of the next n lines contains an integer, the node data values in order.

The last line contains an integer, the index of the node to delete. (0 <= position <= n-1)

Output Format
Output elements of the linked list after deleting the required node

Example 1
Input

8
20
6
2
19
7
4
15
9
3
Output

20 6 2 7 4 15 9
Explanation

After deleting the element at index 3 (with value 19), we obtain the linked list 20 -> 6 -> 2 -> 7 -> 4 -> 15 -> 9.

Example 2
Input

3
1
2
3
0
Output

2 3
Constraints
1 <= n <= 1000

1 <= llist[i] <= 1000, where llist[i] is the ith element of linked list

Topics
Linked lists
Companies
Samsung
