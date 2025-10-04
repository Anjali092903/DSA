Merge K sorted Lists
You are given an array of K sorted linked list. Merge them to form a single sorted linked list.

Note: use comparators.

Input Format
First line contains a single integer K, denoting number of linked list.

For next 2*K lines:

- First line denote the size of the linked list, N.

- Second line denote the elements of the linked list
Output Format
Print a single sorted linked list

Example 1
Input

2
2
4782 8352 
1
6523 
Output

4782 6523 8352
Explanation

We merged the two list in sorted manner.





  import java.util.*;

// 🔹 Node class for Linked List
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read number of linked lists (K)
        int K = sc.nextInt();

        // This will store all linked lists' head nodes
        List<Node> lists = new ArrayList<>();

        // Step 2: Take input for each linked list
        for (int i = 0; i < K; i++) {
            int n = sc.nextInt(); // size of current linked list
            Node head = null, tail = null;

            // Create the linked list of size n
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                Node newNode = new Node(val);

                // If first element → assign as head
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else { 
                    // Otherwise add at the end
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            // Add head of current list to list of lists
            lists.add(head);
        }

        // Step 3: Merge all K sorted linked lists using divide & conquer
        Node mergedHead = mergeKLists(lists, 0, lists.size() - 1);

        // Step 4: Print the final merged linked list
        while (mergedHead != null) {
            System.out.print(mergedHead.data + " ");
            mergedHead = mergedHead.next;
        }

        sc.close();
    }

    // 🔹 Function to merge K sorted lists using Divide & Conquer
    public static Node mergeKLists(List<Node> lists, int start, int end) {
        // If no list
        if (start > end) return null;

        // If only one list, return it directly
        if (start == end) return lists.get(start);

        // Divide lists into two halves
        int mid = (start + end) / 2;

        // Recursively merge left half and right half
        Node left = mergeKLists(lists, start, mid);
        Node right = mergeKLists(lists, mid + 1, end);

        // Merge the two sorted halves
        return mergeTwoLists(left, right);
    }

    // 🔹 Function to merge two sorted linked lists (like in merge sort)
    public static Node mergeTwoLists(Node l1, Node l2) {
        // Dummy node to simplify merging
        Node dummy = new Node(-1);
        Node current = dummy;

        // Compare nodes of both lists and pick smaller one
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next; // move forward
        }

        // Attach the remaining nodes (if any)
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        // Return merged list (ignoring dummy)
        return dummy.next;
    }
}



🔎 Easy Explanation of Flow:

Input Phase
Read K, then read each linked list and store the heads in a list.
Merge Phase (Divide & Conquer)
Recursively split lists into two halves until only one list remains.
Merge them pair by pair using mergeTwoLists.

  Merging Two Lists
Use a dummy node.
Compare values from both lists and connect the smaller node.
Attach leftover nodes at the end.
Output Phase
Print the merged linked list.
