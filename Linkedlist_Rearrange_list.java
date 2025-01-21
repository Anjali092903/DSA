// Main.java
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node rearrangeList(Node head) {
        if (head == null || head.next == null) {
            return head;  // No need to rearrange if there's 1 or no nodes
        }
        
        // Step 1: Find the middle of the list using slow and fast pointers
        Node slow = head;
        Node fast = head;
        
        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Now slow is at the middle of the list
        Node mid = slow;
        
        // Step 2: Reverse the second half of the list
        Node secondHalf = mid.next;
        mid.next = null;  // Cut the list into two halves
        secondHalf = reverse(secondHalf);
        
        // Step 3: Merge the two halves
        Node firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            Node tmp1 = firstHalf.next;
            Node tmp2 = secondHalf.next;
            
            firstHalf.next = secondHalf;  // Link first half node to second half node
            if (tmp1 == null) break;  // If the first half is exhausted, exit
            secondHalf.next = tmp1;  // Link second half node to next node in first half
            
            firstHalf = tmp1;  // Move to the next node in the first half
            secondHalf = tmp2;  // Move to the next node in the second half
        }
        
        return head;
    }
    
    // Helper function to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (head == null) {
                    head = new Node(val);
                } else {
                    addHead(head, val);
                }
            }
            
            Solution sol = new Solution();
            head = sol.rearrangeList(head);
            printList(head);
        }
        
        sc.close();
    }
    
    public static void addHead(Node node, int val) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(val);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}




Rearrange list
You are given the head node of the linked list. You have to rearrange the nodes of the linked list in place.

If the original list was L0 -> L1 ->…-> Ln-1 -> Ln, the rearranged list should be L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2…

Note

You need to only complete the function. Don't worry about input; it is for internal reference.

Input Format
The first line contains the number of test cases.

For each test case: The first line of input contains N representing the number of nodes in linked list.

The second line of input contains N space seperated integers, representing elements in linked list.

Output Format
Return the head of the rearranged list.

Example 1
Input

1
3
1 2 3
Output

1 3 2
Explanation

We rearrange the order of nodes in said manner.

Example 2
Input

1
5
1 2 3 4 5
Output

1 5 2 4 3
Explanation

We rearrange the order of nodes in said manner.

Constraints
1 <= T <= 10

1 <= N <= 10000

1 <= A[i] <= 1000000

Topics
Linked lists
