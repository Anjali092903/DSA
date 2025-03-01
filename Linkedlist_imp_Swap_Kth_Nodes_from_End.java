import java.util.*;

class Node {
    int data;    // Data value of the node
    Node next;   // Pointer to the next node

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
    // Function to swap Kth node from start and Kth node from end
    Node swapkthnode(Node head, int N, int K) {
        // Edge case: If K is invalid or the linked list is empty
        if (head == null || K > N) return head;

        // If Kth from start and Kth from end are the same, no need to swap
        if (2 * K - 1 == N) return head;

        // Find Kth node from start
        Node firstK = head, prevFirstK = null;
        for (int i = 1; i < K; i++) {
            prevFirstK = firstK;
            firstK = firstK.next;
        }

        // Find Kth node from end (N-K+1 from start)
        Node lastK = head, prevLastK = null;
        Node temp = head;
        for (int i = 1; i < N - K + 1; i++) {
            prevLastK = lastK;
            lastK = lastK.next;
        }

        // Adjust previous pointers to swap nodes
        if (prevFirstK != null) prevFirstK.next = lastK;
        if (prevLastK != null) prevLastK.next = firstK;

        // Swap next pointers
        Node tempNext = firstK.next;
        firstK.next = lastK.next;
        lastK.next = tempNext;

        // If head needs to be updated
        if (K == 1) head = lastK;
        if (K == N) head = firstK;

        return head;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        LinkedList list = new LinkedList();

     
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            list.add(x);
        }

        
        Solution obj = new Solution();
        list.head = obj.swapkthnode(list.head, n, k);
        Node curr = list.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}



Swap Kth Nodes from End
Given a singly linked list of size N, and an integer K. You need to swap the Kth node from beginning and Kth node from end in linked list.

Note: You need to swap the nodes through the links and not changing the content of the nodes.

Input Format
The first line contains N, number of nodes in linked list and K, the nodes to be swapped.\

The second line contains the elements of the linked list.

Output Format
Print the linked list in a new line.

Example 1
Input

5 3
1 2 3 4 5
Output

1 2 3 4 5 
Explanation

Here k = 3, hence after swapping the 3rd node from beginning and end the new list will be 1 2 3 4 5.

Example 2
Input

4 4
1 2 3 4
Output

4 2 3 1
Explanation

Here k = 4, hence after swapping the 4th node from beginning and end the new list will be 4 2 3 1.

Constraints
1 <= N <= 10^3

1 < K < N

Topics
Linked lists
Companies
Amazon
Morgan Stanley
