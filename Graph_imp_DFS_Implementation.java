import java.util.*;

class Solution {

    // DFS function to traverse the graph
    public void dfs(ArrayList<Integer>[] graph, int vtx, boolean[] vis) {
        vis[vtx] = true;
        System.out.print(vtx + " ");

        ArrayList<Integer> nbrs = graph[vtx];
        for (int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);
            if (!vis[nbr]) {
                dfs(graph, nbr, vis);  // Recursive call
            }
        }
    }

    // Function to build graph and start DFS
    public void DFSTraversal(List<List<Integer>> edges, int n) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // Sort neighbors to ensure lexicographic traversal
        for (int i = 0; i < n; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of vertices
        int e = sc.nextInt(); // Number of edges

        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}


DFS Implementation
Given a connected undirected graph consisting of n vertices and e edges. All the edges are given in form of a 2-D matrix edges of size e * 2, where there is an undirected edge between edges[i][0] and edges[i][1] for all i ∈ {0, e-1}.

Perform a Depth First Traversal of the graph.

Note: When traversing the vertices of a graph, if vertex u is connected to a set of neighboring vertices {n1, n2, n3, ...}, then the traversal should proceed in the order of n1, n2, n3, ....; where n1 < n2 < n3 < ...

For example if vertex u has neighbours {3, 1, 4} then first traverse neighbouring node 1, then 3, and lastly 4 as 1 < 3 < 4.

Input Format
The First line contains two integers n and e which denotes the no of vertices and no of edges respectively.

Next e lines contains two integers u and v where there is an edge between u and v

Output Format
Complete the function DFSTraversal() which prints the vertices. Start the traversal for vertex with the smallest index.

Example 1
Input

3 4
1 2
0 2
0 1
0 1
Output

0 1 2
Explanation

The Graph looks like:
   0
 /   \
1 --- 2
So starting traversal from node 0, we first print 0. Then we go to the neighbours of 0 which are {1, 2}. Since 1 < 2, we first traverse node 1, then node 2 printing them both respectively

Example 2
Input

4 4
1 3
0 2
2 3
1 2
Output

0 2 1 3
Constraints
0 <= n <= 103

1 <= e <= 104

Topics
Graphs
Companies
Intuit
Samsung
Amazon
Accolite
