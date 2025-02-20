import java.util.*;

class Main {

    static Node head1 = null;
    static Node head2 = null;

    // Node structure for linked list
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Function to find the intersection node of two linked lists
    static Node intersectingNode(Node headA, Node headB) {
        Node a = headA, b = headB;

        // Traverse both lists. If any reaches null, point it to the other list’s head.
        // This way, the difference in length is adjusted, and they meet at the intersection point.
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either return the intersection node or null (if no intersection exists)
        return a;
    }

    // Function to create linked lists from input arrays
    static void formLinkList(int n, int m, int k, int[] a, int[] b) {
        head1 = new Node(a[0]); // First linked list
        Node temp = head1;
        int i = 1;
        Node need = null; // Intersection node

        // Construct the first linked list
        while (i < n) {       
            temp.next = new Node(a[i]);
            temp = temp.next;
            if (i == k) need = temp; // Store intersection point
            i++;
        }

        // Construct the second linked list
        head2 = new Node(b[0]);
        i = 1;
        temp = head2;
        while (i < m) {       
            temp.next = new Node(b[i]);
            temp = temp.next;
            i++;
        }

        // Connect the second list to the intersection point of the first list
        temp.next = need;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            head1 = null;
            head2 = null;

          
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

           
            formLinkList(n, m, k, a, b);

           
            Node intersection = intersectingNode(head1, head2);
            System.out.println((intersection != null) ? intersection.data : -1);
        }

        sc.close();
    }
}



Intersection of Two Linked Lists
Your are given two linked List consisting of N nodes and M nodes consisting of a common intersection point.

Your task is to find the value of the intersection point of the two linked list.

Input Format
The first line contains the number of test cases.

The first line of each test case has an integer containing the number of elements in first linked list , the number of elements in second linked list and a hidden integer k that is a random index of first linked list.

Next line denotes the elements of the linked list.

Next line denotes the elements of the next linked list.

All the elements of first list beyond the node with index k are appended to second list.

Output Format
For each test case print an integer in a new line, denoting the value of the intersection point.

Example 1
Input

1
5 1 3
3 6 9 15 30
10
Output

15
Explanation

L1: 3 - 6 - 9 - 15 - 30 

L2: 10 - 15 - 30

3
 \
  6
   \
    9    10   
     \  /
      15
      |
      30

The value of the intersection node is 15. Thus answer is 15

Example 2
Input

1
5 1 3
1 2 3 4 5
3
Output

4
Explanation

The value of intersection node is 4. Thus answer is 4.

Constraints
1 <= T <= 10

1 <= N <= 10000

1 <= M <= 10000

1 <= L1[i] <= 100000

1 <= L2[i] <= 100000

Topics
Linked lists
Companies
Visa
Amazon
Goldman Sachs
Adobe
MAQ Software
Flipkart
VMware
Snapdeal
MakeMyTrip
FactSet
DE Shaw
Qualcomm
Microsoft
Accolite
