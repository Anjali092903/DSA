import java.util.*;

public class Main {

  static Node getNode(int data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) 
      root.left = LevelOrder(root.left, data);
    else 
      root.right = LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;
    for (int i = 0; i < n; i++) 
      root = LevelOrder(root, arr[i]);
    return root;
  }

  // ✅ Make isBalanced and checkHeight static
  public static boolean isBalanced(Node root) {
    return checkHeight(root) != -1;
  }

  private static int checkHeight(Node node) {  // ✅ Made static
    if (node == null) return 0;

    int leftHeight = checkHeight(node.left);
    if (leftHeight == -1) return -1; // Left subtree is unbalanced

    int rightHeight = checkHeight(node.right);
    if (rightHeight == -1) return -1; // Right subtree is unbalanced

    if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node is unbalanced

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) 
      tree[i] = sc.nextInt();
    sc.close();

    Node root = constructBst(tree, n);
    System.out.println(isBalanced(root) ? "true" : "false");
  }
}

class Node {
  int data;
  Node left, right;
}


Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

A height balanced tree is a tree in which absolute difference of the left and right subtrees for every node is less than or eual to 1.

Input Format
First line consists of an integer n, the number of nodes in the binary tree

The next line contains n spaced integers, representing the level order traversal of the binary tree

Output Format
Print true if the binary tree is height balanced else print false

Example 1
Input

5
3 9 20 15 7
Output

false
Explanation

Left and right subtree difference for atleast one node is > 1

Example 2
Input

7
1 2 2 3 3 4 4
Output

false
Explanation

Left and right subtree difference for node 1 itself is 2 (> 1)

Constraints
0 <= n <= 5000

-10^4 <= node.value <= 10^4

Topics
Trees
Companies
Facebook
Spotify
Amazon
Adobe
Uber
Google
