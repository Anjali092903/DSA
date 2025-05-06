import java.io.*;
import java.util.*;

class Solution {
    // Helper DFS function to detect cycle
    public static boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true; // mark current node as visited

        // Traverse all neighbors
        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                // If neighbor not visited, do DFS on it
                if (dfs(nbr, node, vis, adj)) {
                    return true;
                }
            } else if (nbr != parent) {
                // If neighbor is visited and not parent => cycle found
                return true;
            }
        }

        return false; // No cycle found
    }
// Main function to detect cycle in any component
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] vis = new boolean[V]; // visited array

        // Handle disconnected components
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj)) {
                    return true;
                }
            }
        }

        return false; // No cycle in any component
    
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}



Detect cycle in an undirected graph
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Input Format
First line contains two integers V and E. Here V represent number of vertices and E represents number of edges.

Next E lines contain two integers representing an edge between them.

Output Format
For each student, standing at index i print the distance between the ith student and the student having height greater than ith student and standing towards the right of him/her.

Example 1
Input

5 5
1 0
0 2
2 1 
0 3
3 4
Output

1
Example 2
Input

3 2
0 1
1 2
Output

0
Constraints
1 ≤ V, E ≤ 200

Topics
Graphs
DFS
Companies
Samsung
Amazon
Oracle
Adobe
Flipkart
MakeMyTrip
