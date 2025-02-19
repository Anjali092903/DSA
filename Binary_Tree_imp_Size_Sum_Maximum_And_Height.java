import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        
       
        System.out.println(g.sizeOfTree(root1));   // Total number of nodes
        System.out.println(g.sumOfTree(root1));    // Sum of all nodes
        System.out.println(g.maxOfTree(root1));    // Maximum value in tree
        System.out.println(g.heightOfTree(root1)); // Height of tree
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    
    // Function to calculate the size (number of nodes) in the binary tree
    public int sizeOfTree(Node root) {
        if (root == null) {
            return 0; // Base case: If node is null, return 0
        }
        // Recursively get size of left and right subtrees and add 1 (for current node)
        return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
    }

    // Function to calculate the sum of all node values in the tree
    public int sumOfTree(Node root) {
        if (root == null) {
            return 0; // Base case: If node is null, return 0
        }
        // Recursively calculate the sum of left and right subtrees and add root data
        return sumOfTree(root.left) + sumOfTree(root.right) + root.data;
    }

    // Function to find the maximum value in the tree
    public int maxOfTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE; // Base case: If node is null, return smallest possible value
        }
        // Recursively find max in left and right subtree
        int leftMax = maxOfTree(root.left);
        int rightMax = maxOfTree(root.right);
        // Return the maximum among root data, left subtree max, and right subtree max
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // Function to find the height of the tree
    public int heightOfTree(Node root) {
        if (root == null) {
            return 0; // Base case: If node is null, return 0
        }
        // Recursively calculate the height of left and right subtrees
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        // The height of the tree is the max height of left/right subtree + 1 (for root node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}





Size, Sum, Maximum And Height Of A Binary Tree
Given a binary tree a, you need to compute the size, sum, maximum and height of the tree. You must complete the function bodies for each of these functions.

Input Format
The only line of the input contains the elements of the tree in level order form separated by a space. A null node is represented by the character N. The input ends when the last node is processed.

Output Format
The first line contains the size of the tree.

The second line contains the sum of the tree.

The third line contains the maximum value in the tree.

The fourth line contains the height of the tree.

Example 1
Input

1 2 3 4 5 N N N N N N
Output

5
15
5
3
Explanation

The tree looks like this:

        1
      /   \
     2     3
    / \
   4   5
The size of the tree is 5, the sum of the tree is 15, the maximum value in the tree is 5 and the height of the tree is 3.

Example 2
Input

1 2 N 3 N 4 N N N
Output

4
10
4
4
Constraints
1 <= n <= 10000
1 <= a[i] <= 10000
Topics
Recursion
Trees
