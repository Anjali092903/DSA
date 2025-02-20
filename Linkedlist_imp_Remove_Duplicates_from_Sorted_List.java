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
    static Node temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Read the number of nodes
        int a1 = sc.nextInt(); // Read the first element
        head = null;
        temp = null;
        addToTheLast(a1); // Add first node

        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            addToTheLast(data); // Add subsequent nodes
        }

        Solution ans = new Solution();
        Node node = ans.solve(head); // Call function to remove duplicates
        printList(node); // Print the modified linked list
        System.out.println();
        sc.close();
    }

    // Function to add a node to the end of the linked list
    public static void addToTheLast(int data) {
        if (head == null) {
            head = new Node(data);
            temp = head;
        } else {
            Node new_node = new Node(data);
            temp.next = new_node;
            temp = temp.next;
        }
    }

    // Function to print the linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

// Solution class to remove duplicate nodes from a sorted linked list
class Solution {
    public Node solve(Node head) {
        if (head == null) return null; // If list is empty, return null

        Node current = head;

        // Traverse through the linked list
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // Skip duplicate node
            } else {
                current = current.next; // Move to the next distinct node
            }
        }

        return head; // Return the modified head
    }
}




Remove Duplicates from Sorted List
You are given the head node of sorted linked list, your task is to delete all duplicates such that each element appears only once, return the head node once you delete duplicate nodes.

Input Format
The first line of input contains a single integer n.

The second line of input contains n space seperated integer.

Output Format
Return the head node of linked list after removing duplicates.

Example 1
Input

3
1 1 2
Output

1 2
Explanation

The linked list given is 

1->1->2

after removing the duplicate element we get 1->2
Example 2
Input

5
1 1 2 3 3
Output

1 2 3
Explanation

The linked list given are 

1->1->2->3->3

after removing duplicate elements we get 1->2->3
Constraints
1 <= n <= 300

-100 <= node.value <= 100

Topics
Linked lists
Companies
Visa
Oracle
Adobe
Oyo Rooms
Myntra
Microsoft
