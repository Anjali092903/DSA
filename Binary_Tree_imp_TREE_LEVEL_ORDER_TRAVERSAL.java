import java.util.*;

class Node {
    int val;
    Node left, right;
    
    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {
    
    // Function to perform Level Order Traversal of BST
    public static void levelOrderTraversal(Node root) {
        if (root == null) return;  // If tree is empty, return

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);  // Start with the root

        while (!queue.isEmpty()) {
            Node current = queue.poll();  // Remove front element from queue
            System.out.print(current.val + " "); // Print the value
            
            // Add left child if exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Add right child if exists
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // BST Class to handle insertion
    static class BST {
        Node root = null;

        Node insert(Node root, int val) {
            if (root == null) {
                return new Node(val);
            }
            if (val < root.val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  // Read number of nodes
        BST t = new BST();

        for (int i = 0; i < n; i++) {
            t.root = t.insert(t.root, input.nextInt());
        }

        levelOrderTraversal(t.root);  // Perform Level Order Traversal
        input.close();
    }
}





TREE LEVEL ORDER TRAVERSAL
You are given the number of nodes present in the tree. You have to input the nodes and form a Binary Search Tree (BST). After forming the BST, print the Level Order traversal of the BST.

Input
Line 1 contains integer n denoting number of nodes.

Line 2 contains n spaced integers denoting node values.

Output
Print a single line of space separated integers denoting Level Order traversal of tree.

Constraints
1<=n<=500

-1000<=value of node<=1000

Sample Input
6

1 2 5 3 4 6
Sample Output
1 2 5 3 6 4
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
We need to print the nodes level by level. We process each level from left to right.

Level Order Traversal: 1 -> 2 -> 5 -> 3 -> 6 -> 4.
Topics
Trees
Companies
Facebook
Adobe
Microsoft
