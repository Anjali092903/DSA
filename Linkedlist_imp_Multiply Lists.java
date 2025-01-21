Multiply Lists
You are given two integers whose digits are represented as a linked list. You have to multiply the given numbers.

Return the answer in the form of an integer. The answer can be very large, so use modulo with 1000000007.

Note Complete the given function. The input and output would be handled by the driver code.

Input Format
The first line contains an integer N, the number of digits of the first integer.

The next line contains N space-separated digits of the first integer.

The second line contains an integer M, the number of digits of the second integer.

The next line contains M space-separated digits of the second integer.

Output Format
Print the answer in a new line.

Example 1
Input

3
1 0 0
4
1 0 0 0
Output

100000
Explanation

The given lists are 1->0->0, and 1->0->0->0, which represent the integers 100 and 1000, respectively.

100 * 1000 = 100000

Example 2
Input

1
4
2
25
Output

100
Explanation

The given lists are 4, and 2->5, which represent the integers 4 and 25, respectively.

4 * 25 = 100

Constraints
1 <= N,M <= 10000

Topics
Linked lists
Companies
Amazon




import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node phead = null;

        int n = sc.nextInt();
        while (n-- > 0) {
            int n1 = sc.nextInt();
            if (head == null)
                head = new Node(n1);
            else
                addHead(head, n1);
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            int n1 = sc.nextInt();
            if (phead == null)
                phead = new Node(n1);
            else {
                addHead(phead, n1);
            }
        }

        Solution g = new Solution();
        System.out.println(g.multiplyLists(head, phead));
    }

    public static void addHead(Node node, int a) {
        if (node == null)
            return;
        if (node.next == null)
            node.next = new Node(a);
        else
            addHead(node.next, a);
    }
}

class Solution {
    private static final long MOD = 1000000007;

    public long multiplyLists(Node l1, Node l2) {
        long num1 = 0, num2 = 0;

        // Convert first linked list to a number
        while (l1 != null) {
            num1 = (num1 * 10 + l1.data) % MOD;
            l1 = l1.next;
        }

        // Convert second linked list to a number
        while (l2 != null) {
            num2 = (num2 * 10 + l2.data) % MOD;
            l2 = l2.next;
        }

        // Multiply the two numbers and take modulo
        return (num1 * num2) % MOD;
    }
}
