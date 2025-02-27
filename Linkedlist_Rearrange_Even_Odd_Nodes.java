import java.util.*;

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

class LinkedList {
    Node head, tail;

    void push(Node new_node) {
        if (head == null && tail == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node rearrangeList(Node head) {
        // If the list is empty or has only one node, return as it is
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy nodes to track even and odd lists
        Node evenHead = new Node(0); // Dummy node for even numbers
        Node oddHead = new Node(0);  // Dummy node for odd numbers

        // Pointers for even and odd lists
        Node even = evenHead;
        Node odd = oddHead;

        Node current = head; // Pointer to traverse the original list

        // Iterate through the list and separate even and odd nodes
        while (current != null) {
            if (current.val % 2 == 0) { // If value is even
                even.next = current; // Link to even list
                even = even.next;
            } else { // If value is odd
                odd.next = current; // Link to odd list
                odd = odd.next;
            }
            current = current.next; // Move to next node
        }

        // Connect even list to odd list
        even.next = oddHead.next;
        odd.next = null; // Prevent cycle

        return evenHead.next; // Return the new head (first even node)
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist = new LinkedList();
        int h1 = sc.nextInt();
        Node head = new Node(h1);
        llist.push(head);
        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            llist.push(new Node(data));
        }
    
        Solution Obj = new Solution();
        head = Obj.rearrangeList(head);
        llist.printList(head);
        sc.close();
    }
}



Rearrange Even Odd Nodes
Rewrite the given linked list such that all even numbers are placed before all odd numbers, while maintaining the original order of the numbers within each group.

Note

Do not create a new linked list, but modify the existing one.

Input Format
Input is handled by driver code you will be given the head of the linked list.

Output Format
Return the modified linked list's head.

Example 1
Input

5
1 2 3 4 5
Output

2 4 1 3 5
Explanation

We have rearranged the even nodes 2, 4 to come before the odd nodes 1, 3, 5.
Example 2
Input

10
2 4 6 8 10 1 3 5 7 9
Output

2 4 6 8 10 1 3 5 7 9
Explanation

The nodes are already arranged as required.
Constraints
1 <= n <= 10^5

1 <= nodes.val <= 10^5

Topics
Linked lists
2-Pointers
