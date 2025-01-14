import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist = new LinkedList();
        
        // Read the linked list data and create nodes
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        llist.addToTheLast(head);
        
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            llist.addToTheLast(new Node(a));
        }
        
        // Check if the list is a palindrome
        Solution solution = new Solution();
        solution.checkLinkedListPalindrome(llist.head);
    }
}

class Node {
    int data;
    Node next;
    
    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // Method to print the list (for testing purposes)
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    // Function to check if the linked list is a palindrome
    static void checkLinkedListPalindrome(Node head) {
        if (head == null || head.next == null) {
            System.out.println("YES");
            return;
        }
        
        // Step 1: Find the middle using slow and fast pointers
        Node slow = head;
        Node fast = head;
        
        // Move slow to the middle and fast to the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Compare the first half and the reversed second half
        Node firstHalf = head;
        Node secondHalf = prev; // This is the reversed second half

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                System.out.println("NO");
                return;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // If we didn't find any mismatches, the list is a palindrome
        System.out.println("YES");
    }
}






Palindrome Linked List
Given the head of a linked list, check whether the linked list is palindromic or not.

Linked List Structure:

public class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}   
public class LinkedList
{
    Node head;  
    Node tail;
}
If your list is [5, 4, 4, 5], the output should be YES.

Input Format
The first integer denotes n, the number of elements in the linked list.

The next n space separated integers denote the elements of the linked list.

Output Format
Output YES if the list is palindromic, else output NO.

Example 1
Input

4
5 4 4 5
Output

YES
Explanation

The given list is a palindrome

Example 2
Input

2
5 7
Output

NO
Explanation

The given list is not a palindrome

Constraints
1 <= n <= 10^5

Topics
Linked lists
Companies
Facebook
Amazon
