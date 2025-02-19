import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class Main {
    // Function to build a tree from a level-order input string
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
            Node currNode = queue.poll();
            String currVal = ip[i];

            // Left child
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;

            // Right child
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
        System.out.println(g.diameter(root1));
    }
}

// Class representing a node of the tree
class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Solution class to compute the diameter
class Solution {
    static int maxDiameter = 0; // Stores the maximum diameter found so far.

    // Helper function to compute the height and update the diameter
    private static int height(Node root) {
        if (root == null) {
            return 0; // Height of an empty tree is 0.
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update the maximum diameter
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 1);

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to calculate the diameter of the binary tree
    public static int diameter(Node root) {
        maxDiameter = 0; // Reset before calculation
        height(root); // Calls height function which updates maxDiameter
        return maxDiameter;
    }
}



Diameter of a Binary Tree
Given a root of a binary tree, write a function to get the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Input Format
You are given a string s which describes the nodes of the binary tree. (The first element corresponds to the root, the second is the left child of the root and so on). In the function, you are provided with the root of the binary tree.

Output Format
Return the diameter of the binary tree.

Example 1
Input

8 2 1 3 N N 5
Output

5
Explanation

The longest path is between 3 and 5. The diameter is 5.

Example 2
Input

1 2 N
Output

2
Explanation

The longest path is between 1 and 2. The diameter is 2.

Constraints
1 <= N <= 10^5

1 <= Node Data <= 10^5

Topics
Recursion
Trees
Companies
Amazon
Oyo Rooms
Microsoft
