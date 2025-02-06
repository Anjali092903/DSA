import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int q = sc.nextInt();
            Solution g = new Solution();
            while (q > 0) {
                int qt = sc.nextInt();
                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    System.out.print(g.pop() + " ");
                } else if (qt == 3) {
                    System.out.print(g.getMin() + " ");
                }
                q--;
            }
            System.out.println();
            T--;
        }
        sc.close();
    }
}

class Solution {
    Stack<Integer> mainStack;  // Stack to store elements
    Stack<Integer> minStack;   // Stack to track minimum values

    Solution() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int x) {
        mainStack.push(x); // Push element onto the main stack
        // If minStack is empty or x is smaller than the current min, push onto minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    int pop() {
        if (mainStack.isEmpty()) return -1; // If stack is empty, return -1
        int popped = mainStack.pop();
        // If popped element is the current minimum, pop from minStack as well
        if (popped == minStack.peek()) {
            minStack.pop();
        }
        return popped;
    }

    int getMin() {
        if (minStack.isEmpty()) return -1; // If stack is empty, return -1
        return minStack.peek(); // Return the top element of minStack, which is the minimum
    }
}






Minimum Stack
Design a stack that supports push, pop and retrieving the minimum element in constant time.

You are required to complete the three methods push() which take one argument an integer 'x' to be pushed into the stack, pop() which returns a integer poped out from the stack and getMin() which returns the minimum element from the stack. (-1 will be returned if for pop() and getMin() the stack is empty.)

Input Format:
You just need to complete the three function provided to you.

Output Format:
You need to return one integer in case of pop() and getMin() function representing the top element of the stack and minimum element in the stack respectively.

Example 1:
Input:

push(2)
push(3)
pop()
getMin()
push(1)
getMin()
Output:

3 2 1
Explanation:

The first two operation pushes 2 and 3 into the stack. The minimum element currently is 2 and top element is 3.

Next operation pops the top element in the stack which is 3 and return it.

Next operation returns the minimum element in the stack which is 2.

Now we push 1 into the stack.

Next operation returns the minimum element in the stack which is 1.

Example 2:
Input:

push(5)
push(8)
push(4)
push(6)
getMin()
pop()
pop()
getMin()
Output:

4 6 4 5
Explanation:

In first four operation we push 5 8 4 6 into the stack.

In next operation we will get minimum element of the stack which is 4.

In next two operation we will pop the top element of the stack. We will get two integers which are 6 and 4.

In last operation we will get minimum of the stack which is 5.

Constraints:
1 <= T <= 10

1 <= Number of queries <= 100

1 <= values of the stack <= 100
Topics
Stacks
Companies
Amazon
One 97
Goldman Sachs
FactSet
Kuliza
Flipkart
Snapdeal
Sapient
DE Shaw
Walmart Global Tech
Microsoft
SAP
GreyOrange
