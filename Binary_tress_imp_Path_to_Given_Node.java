import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    
	public static void main (String[] args) throws IOException{
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            sc.nextLine();
			String s = sc.nextLine();
            int b=sc.nextInt();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans=tree.solve(root,b);
            for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");

            System.out.println();

            sc.close();			
	}
}
  


class Solution{
    
   public ArrayList<Integer> solve(Node root,int b)
	{
        // your code here
        if(root == null){
            return new ArrayList<>();
             }

        if(root.data == b){ // checking with target value is threre or not
        ArrayList<Integer> li = new ArrayList<>();
        li.add(root.data);
        return li;
        
        }

        ArrayList<Integer> left = solve(root.left, b);
        if(left.size() != 0){
            left.add(0, root.data);
            return left;
        }
        
        ArrayList<Integer> right = solve(root.right, b);
        if(right.size() != 0){
         right.add(0, root.data);
         return right;
        }

          return new ArrayList<>();
          
    }
}



Path to Given Node
Given the root node of a binary tree containg n nodes and an integer b, you need to find the path from root to given node b.

Input Format
The first line of input contains a number n.

The second line of input contains n space seperated integer.

The third line of input contains a single integer b.

Output Format
Return the path from root to the given node b.

Example 1
Input

7
1 2 3 4 5 6 7
5
Output

1 2 5
Explanation

The given binary tree is 
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
the path from 1 to 5 is {1,2,5}.
Example 2
Input

5
1 2 3 4 5
1
Output

1
Explanation

The given tree is
            1
          /   \
         2     3
        / \  
       4   5 
Constraints
1 <= n <= 105

1 <= b <= n

Topics
Recursion
Trees
Companies
Facebook
Amazon
Flipkart
Google
Microsoft
