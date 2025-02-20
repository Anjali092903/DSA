import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    
    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add two linked lists
    static Node addTwoLists(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        
        Node result = null, temp = null, prev = null;
        int carry = 0;

        while (first != null || second != null || carry != 0) {
            int sum = carry;
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            if (second != null) {
                sum += second.data;
                second = second.next;
            }

            carry = sum / 10;
            temp = new Node(sum % 10);

            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
        }

        return reverse(result);
    }

    // Function to print linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to create a linked list from an array
    static Node createList(int[] arr) {
        Node head = null, temp = null, prev = null;
        for (int num : arr) {
            temp = new Node(num);
            if (head == null) {
                head = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read sizes of linked lists
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] list1 = new int[n];
        for (int i = 0; i < n; i++) {
            list1[i] = sc.nextInt();
        }

        int[] list2 = new int[m];
        for (int i = 0; i < m; i++) {
            list2[i] = sc.nextInt();
        }

        Node first = createList(list1);
        Node second = createList(list2);

        Node result = addTwoLists(first, second);
        printList(result);
        
        sc.close();
    }
}


Add two numbers represented by linked lists
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.

The sum list is a linked list representation of the addition of two input numbers from the last.

Input Format
The first line inputs N and M ,the size of two linked lists.

The second line inputs the value of N nodes of 1st linked list.

The third line inputs the value of M nodes of 2nd linked list.

Output Format
Print the sum list.

Example 1
Input

2 3
4 5 
3 4 5
Output

3 9 0
Explaination

For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2
Input

3 3
5 4 1 
7 2 5
Output

1 2 6 6 
Explaination

For the given two linked
list (5 4 1) and (7 2 5, after adding
the two linked list resultant linked
list will be (1 2 6 6 ).
Constraints:
1 <= N, M <= 5000

0<= |value of each node| <=9

Topics
Linked lists
Companies
Amazon
Flipkart
Snapdeal
MakeMyTrip
Qualcomm
Microsoft
Morgan Stanley
Accolite
