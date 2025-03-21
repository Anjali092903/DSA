import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution {
    public static void letfView(Node root) {
        if (root == null) return; // If tree is empty, return

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // Print the first node of each level (Leftmost node)
                if (i == 0) {
                    System.out.print(current.val + " ");
                }

                // Add left and right children to the queue
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }
}





Left view of binary tree
Given the root node of a BST, print its left view i.e print all the nodes from top to bottom that will appear while looking the tree from left.

Input Format
The first line contains an integer n, the number of nodes.
The next line inputs the value of n nodes.

Output Format
Print the left view of the tree as a single line of space-separated values.

Example 1
Input

6
1 2 5 3 4 6
Output

1 2 5 3 4 
Explanation

The BST is like :-
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
So,the left view of tree results in 1,2,5,3,4 as the required result. only 6 is not visible from left view
Example 2
Input

3
1 2 3
Output

1 2 3
Explanation

The BST is like :-
       1
         \
           2
             \
              3
So,the left view will have all three nodes.
Constraints:
1 <= n <= 500
-100 <= val[node] <= 100
Topics
Coding
Trees
Companies
Samsung
PayTM
Amazon
Twitter
Adobe
Oyo Rooms
Flipkart
Snapdeal
MakeMyTrip
Qualcomm
Ola
Accolite
