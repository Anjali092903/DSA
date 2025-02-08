import java.io.*;
import java.util.*;

class myStack {
    LinkedList<Integer> mainQ = new LinkedList<>();
    LinkedList<Integer> helperQ = new LinkedList<>();

    // Push function to add an element to the stack
    void push(int a) {
        mainQ.addLast(a);
    }

    // Pop function to remove and return the top element of the stack
    int pop() {
        if (mainQ.size() == 0) {
            return -1; // Stack is empty
        }

        // Move elements to helperQ except the last one
        while (mainQ.size() > 1) {
            helperQ.addLast(mainQ.removeFirst());
        }

        // Last element is the one to pop
        int removedVal = mainQ.removeFirst();

        // Move elements back to mainQ
        while (!helperQ.isEmpty()) {
            mainQ.addLast(helperQ.removeFirst());
        }

        return removedVal;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        myStack st = new myStack(); // Declare stack before loop
        
        int q = sc.nextInt();
        while (q > 0) {
            int QueryType = sc.nextInt();
            if (QueryType == 1) {
                int a = sc.nextInt();
                st.push(a); // Call push function
            } else if (QueryType == 2) {
                int val = st.pop(); // Call pop function
                System.out.print(val + " ");
            }
            q--;
        }
    }
}



Implement Stack using Queue-push O(1)
Implement stack using two queues. You need to complete the push and pop function of stack class. You are given 2 types of queries-

'1' which represents that we need to push an integer into the stack.

'2' which represents that we need to pop the top element from the stack. If there is no top element simply return -1.

Note: Make the push operation O(1).

Input Format
First line contains q of queries.

Followed by q lines.

Query of type 1 is followed by an integer x to push element in the stack.

Query of type 2 is for pop the top value from the stack and print it.

Output Format
Print the value for pop operations in the query given.

Example 1
Input

5
1 2
1 3
2
1 4
2
Output:

3 4
Explanation:

First we push 2 , then for second query we push 3, for third query we pop 3 and print, for 4th query we push 4 and for 5th query we pop 4.

Example 2
Input

3
2
1 2
2
Output:

-1 2
Explanation:

In the first query we dont have any element but we use pop query so we print -1, in the 2nd query we push 2 and in the 3rd we pop 2 and print 2.

Constraints
1 <= Total number of queries <= 100

1 <= value in each query <= 100

Topics
Stacks
Queues
Companies
Amazon
CISCO
Oracle
Adobe
Oyo Rooms
Snapdeal
DE Shaw
Microsoft
Accolite
