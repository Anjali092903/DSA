import java.util.*;

class Solution {
    static LinkedListNode sort01(LinkedListNode head){
        // Write your code here
         if (head == null || head.next == null) return head;
        
        int count0 = 0, count1 = 0;
        LinkedListNode temp = head;
        
        // Count number of 0s and 1s
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else {
                count1++;
            }
            temp = temp.next;
        }
        
        // Overwrite the linked list with sorted values
        temp = head;
        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        
        return head;
    }
}

class LinkedListNode  {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data)  {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedListNode head = new LinkedListNode(sc.nextInt());
        LinkedListNode a = head;
        for(int i=1;i<n;i++) {
            LinkedListNode temp = new LinkedListNode(sc.nextInt());
            a.next = temp;
            a = temp;
        }
        LinkedListNode ans = Solution.sort01(head);
        for(int i=0;i<n;i++) {
            if(i == n-1) {
                System.out.println(ans.data);
            }
            else {
                System.out.print(ans.data + " ");
            }
            ans = ans.next;
        }
    }
}



Sort a linked list of 0s and 1s.
Given a linked list consisting of only 0 and 1, sort it.

Input Format
First line contains a single integer N, denoting size of linked list.

Second line contains N space separated integers.

Output Format
Print the sorted linked list

Example 1
Input

5
0 1 0 1 0
Output

0 0 0 1 1 
Explanation

Sorted linked list would be 0 0 0 1 1

Example 2
Input

8
0 1 0 1 0 1 1 0
Output

0 0 0 0 1 1 1 1 
Explanation

Sorted linked list would be 0 0 0 0 1 1 1 1

Constraints
1 < N <=100000

0 <= elements of linked list <= 1

Topics
Linked lists
Companies
Amazon
MakeMyTrip
Microsoft
