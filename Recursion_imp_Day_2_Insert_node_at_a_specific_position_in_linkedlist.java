import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static Node insert(Node head, int n, int pos, int val) {
        // Write your code here.  
        Node newNode = new Node(val);
        
        // Case 1: If the position is at the head (position 0)
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
          // Case 2: If the position is somewhere else in the list
        Node current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            return head; // If position is out of bounds, return original list
        }


        // Insert the new node at the specified position
        newNode.next = current.next;
        current.next = newNode;
        
        return head;


    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int val = sc.nextInt();
        int pos = sc.nextInt();
        Node head = Solution.insert(list.head, n, pos, val);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}







Insert node at a specific position in a linked-list
Given a linked list and an integer to insert at a certain position, create a new node with the given integer as its data attribute, insert this node at the desired position and print the new linked list.

A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.

Input Format
The first line contains an integer n, the number of elements in the linked list.

The next line contains n spaced integers data of the nodes of the linked list.

The last line contains two spaced integers, the data of the new node to be inserted and the position at which it should be inserted.

Output Format
The only line contains (n+1) spaced integers, the new elements of the linked list, from head to tail.

Example 1
Input

3 
16 13 7 
1 2
Output

16 13 1 7
Explanation

The initial linked list is 16->13->7. Insert 1 at the position 2, which currently 7 has in it. The updated linked list is 16->13->1->7

Example 12
Input

5
1 2 3 5 6 
4 3
Output

1 2 3 4 5 6
Explanation

The initial linked list is 1->2->3->5->6. Insert 4 at the position 4, which currently 5 has in it. The updated linked list is 1->2->3->4->5->6

Constraints
1 <= n <= 100

1 <= data of node <= 1000

0 <= position <= n

Companies
Microsoft
