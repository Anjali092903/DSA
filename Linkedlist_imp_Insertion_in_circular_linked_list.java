
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
     // Method to add a node at the end of the circular linked list
    void add(int data){
          // write your code here
          Node newNode = new Node(data);

        // If the list is empty, initialize head and point it to itself
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link to itself
            return;
        }
           // Traverse to the last node in the circular linked list
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }

        // Insert the new node at the end and make it circular
        current.next = newNode;
        newNode.next = head;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList ll = new LinkedList();
        for(int i = 0; i < n; i++){
            ll.add(input.nextInt());
        }
        ll.add(input.nextInt());
        Node head = ll.head;
        do{
            System.out.print(head.data + " ");
            head = head.next;
        }while(head != ll.head);
    }
}




Insertion in circular linked list
Given a circular linked list consisting of N nodes and an integer K, your task is to add the integer K at the end of the list.

Input Format
The first line contains an integer N, the length of the circular linked list.
The next line contains N integers, the elements of the circular linked list.
The last line contains K, the value of the node to be added to the end of the list.

Output Format
Print the updated circular linked list in the new line.

Example 1
Input

3
1 2 3
4
Output

1 2 3 4
Example 2
Input

4
1 2 3 4
1
Output

1 2 3 4 1
Constraints:
1 <= N <= 1000
1 <= list[i] <= 1000, where list[i] is the ith element of the list.

Topics
Linked lists
Companies
Microsoft
