import java.util.*;

class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null; 
    }
}

class Main {
    
    public static Node addToTheLast(Node head, Node node) {
        if (head == null) {
            head = node;
            return head;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(Node head, Node res) {
        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        if (len1 != len2) return false;
        
        HashMap<Node, Node> a = new HashMap<>();
        
        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1 == temp2) return false;
            if (temp1.data != temp2.data) return false;
            if (temp1.random != null && temp2.random != null) {
                if (temp1.random.data != temp2.random.data) return false;
            } else if (temp1.random != null || temp2.random != null) {
                return false;
            }
            if (!a.containsKey(temp1)) {
                a.put(temp1, temp2);   
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        if (a.size() != len1) return false;
        
        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.random != null && temp2.random != null) {
                if (a.get(temp1.random) != temp2.random) return false;
            } 
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, head2 = null;
        int n = sc.nextInt();
        int q = sc.nextInt();

        int a1 = sc.nextInt();
        head = addToTheLast(head, new Node(a1));
        head2 = addToTheLast(head2, new Node(a1));
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            head = addToTheLast(head, new Node(a));
            head2 = addToTheLast(head2, new Node(a));
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Node tempA = head;
            Node temp2A = head2;
            int count = -1;

            while (tempA != null) {
                count++;
                if (count == a - 1) break;
                tempA = tempA.next;
                temp2A = temp2A.next;
            }
            Node tempB = head;
            Node temp2B = head2;
            count = -1;

            while (tempB != null) {
                count++;
                if (count == b - 1) break;
                tempB = tempB.next;
                temp2B = temp2B.next;
            }

            if (a <= n) {
                tempA.random = tempB;
                temp2A.random = temp2B;
            }
        }

        Solution g = new Solution();
        Node res = g.copyList(head);

        if (validation(head, res) && validation(head2, res))
            System.out.println("1");
        else
            System.out.println("0");
    }
}

class Solution {
    Node copyList(Node head) {
        if (head == null) return null;
        
        // Step 1: Create a copy of each node and insert it right after the original node
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.data);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        
        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3: Separate the original and copied lists
        Node dummy = new Node(0);
        Node copyCurr = dummy, copyHead = dummy;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead.next;
    }
}



Clone a Linked List with Next and Random Pointer
You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers, where you will be given M number of pairs denoting two nodes a and b i.e., a->random = b.

He has been given a task to copy the linked list. The copy should consist of exactly N new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

NOTE

If there is any node whose random pointer is not given, then it's NULL by default.

Input Format
The first line of input contains two integers, N and M.

The next line of input contains values of N nodes of the linked list.

The last line contains M pairs denoting arbitrary connecting nodes, for which each ith node is connected to any jth node. ( ith->arb = jth ).

Output Format
Return the head pointer of the new copied list. The driver code will return 1 if the copied linked list is a valid one else it will return 0.

Example 1
Input

4 2
1 2 3 4
1 2 2 4
Output

1
Explanation

The above-linked list looks like

     _________
    |         |
    |         |
1--->2--->3--->4--->null
|    ^         
|____|        

In this test case, there are 4 nodes in the linked list. Among these 4 nodes, 2 nodes have an arbitrary pointer set, rest two nodes have an arbitrary pointer as NULL. The second line tells us the value of four nodes. The third line gives information about arbitrary pointers. The first node arbitrary pointer is set to node 2. The second node arbitrary pointer is set to node 4.

Example 2
Input

4 2
1 3 5 9
1 1 3 4
Output

1
Explanation

The above-linked list looks like 

      
--->1--->3--->5--->9--->null
|   |         |    ^
|___|         |____|
We will have a clone in such a way that is similar to the above test case.

Constraints
1 <= N <= 100

1 <= M <= N

1 <= a, b <= 100

Topics
Linked lists
Companies
Amazon
Adobe
BankBazaar
Oyo Rooms
Flipkart
Snapdeal
MakeMyTrip
DE Shaw
Walmart Global Tech
Microsoft
Morgan Stanley
Ola
