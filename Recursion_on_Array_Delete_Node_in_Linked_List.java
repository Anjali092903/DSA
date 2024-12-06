import java.util.*;

class Node {
    int data;
    Node next;
    
    Node(int d) {
        data = d;
        next = null;
    }
}

class Main {
    Node head;

    // Print the list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add node at the end of the list
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main llist = new Main();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            llist.addToTheLast(new Node(a));
        }
        int x = sc.nextInt();  // the node value to be deleted
        Node node = head;
        
        // Find the node to be deleted
        while (node != null) {
            if (node.data == x)
                break;
            node = node.next;
        }
        
        // Call the delete function
        Solution g = new Solution();
        g.deleteNode(node);
        
        // Print the updated list
        llist.printList(llist.head);
    }
}

class Solution {
    void deleteNode(Node node) {
        // Copy the data of the next node to the current node
        node.data = node.next.data;
        
        // Link the current node to the next of the next node
        node.next = node.next.next;
    }
}





Delete Node in Linked List
There's a singly linked list and a node node in it. Delete the given node in the given linked list.

You are given the node to be deleted node, and not the first node of linked list.

All the values of the linked list are unique, and it is guaranteed that the given node is not the last node in the linked list.

By deleting the node, we do not mean removing it from the memory.

We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before `node` should be in the same order.
All the values after `node` should be in the same order.
Input Format
The first line of the input contains an integer n representing the number of nodes in the linked list.

The second line of the input contains n integers representing the linked list values.

The last line of the input contains an integer representing the node to be deleted.

Output Format
Return the list after deleting the given node.

Example 1
Input

4
5 1 9 4
5
Output

1 9 4
Explanation

After deleting 5, the linked list remains 1 9 4.

Example 2
Input

5
1 2 3 4 5
3
Output

1 2 4 5 
Constraints
2 <= n <= 1000

-10^6 <= Node.data <= 10^6

Topics
Linked lists
