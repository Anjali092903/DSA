import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SubtractLinkedLists {
    // Function to reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Function to subtract two linked lists
    public static Node subtract(Node l1, Node l2) {
        // Reverse both lists to process from least significant digit
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Ensure l1 is the larger number, swap if needed
        if (isSmaller(l1, l2)) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node result = null, tail = null;
        int borrow = 0;

        // Perform digit-wise subtraction
        while (l1 != null) {
            int diff = l1.data - (l2 != null ? l2.data : 0) - borrow;
            borrow = (diff < 0) ? 1 : 0;
            if (borrow == 1) diff += 10;

            Node newNode = new Node(diff);
            if (result == null) result = tail = newNode;
            else {
                tail.next = newNode;
                tail = tail.next;
            }

            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Reverse the result back and remove leading zeros
        return removeLeadingZeros(reverse(result));
    }

    // Function to check if first number is smaller than the second
    private static boolean isSmaller(Node l1, Node l2) {
        int len1 = getLength(l1), len2 = getLength(l2);
        if (len1 != len2) return len1 < len2;

        while (l1 != null) {
            if (l1.data != l2.data) return l1.data < l2.data;
            l1 = l1.next;
            l2 = l2.next;
        }
        return false;
    }

    // Function to get the length of a linked list
    private static int getLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Function to remove leading zeros from the linked list
    private static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) head = head.next;
        return (head == null) ? new Node(0) : head; // Return at least one zero if all are removed
    }
}

public class Main {
    // Function to build a linked list from an array
    private static Node buildList(int[] arr) {
        Node head = null, tail = null;
        for (int num : arr) {
            Node newNode = new Node(num);
            if (head == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    // Function to print a linked list
    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read first linked list
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        Node l1 = buildList(arr1);

        // Read second linked list
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();
        Node l2 = buildList(arr2);

        // Get the result of subtraction
        Node result = SubtractLinkedLists.subtract(l1, l2);

        // Print the final linked list
        printList(result);
    }
}




Subtract Linked Lists
You are given two linked lists, L1 and L2. Both the linked lists represent a positive integer. You have to subtract the smaller valued linked list from the larger one. Return the head of the resultant list.

Note Complete the given function. The input and output would be handled by the driver code.

Your answer should not have leading zeroes. In case both lists are equal, return a node with the value 0.

Input Format
The first line contains a single integer N representing the size of L1.

The following line contains N integers of the list L1.

The next line contains a single integer M representing the size of L2.

The following line contains M integers of the list L2.

Output Format
Print the resultant list.

Example 1
Input

3
4 2 0
2
6 9
Output

3 5 1
Explanation

The list L1 4->2->0 represents the integer 420, and the list L2 6->9 represents the integer 69.

420 - 69 = 351. Thus, our output is the list 3->5->1.

Example 2
Input

1
4
1
6
Output

2
Explanation

The list L1 4 represents the integer 4, and the list L2 6 represents the integer 6.

6 - 4 = 2. Thus, our output is the list 2.

Constraints
1 <= N, M <= 10000

Topics
Linked lists
Companies
Amazon
