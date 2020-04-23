package com.graphs;
/*
(Facebook) Given the source node of undirected graph, return a deep copy (clone) of the graph.

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Output: new graph's source node
*/
import java.util.*;

public class CloneGraph {

	//Solution 1, DFS wrapper func, Time O(V+E), Space O(V), V is number of vertices, E is number of edges
	public static GraphNode cloneDFS(GraphNode src) {
		HashMap<GraphNode, GraphNode> map = new HashMap<>(); //stores (original node, copy node) pair
	    return helper(src, map);
	}

	//DFS + memoization, Time O(V+E), Space O(V)
	private static GraphNode helper(GraphNode v, HashMap<GraphNode, GraphNode> map) {
	    if (v == null)
	    	return null;
	    if (map.containsKey(v))
	        return map.get(v);
	    GraphNode clone = new GraphNode(v.label);
	    map.put(v, clone);
	    for (GraphNode ne : v.neighbors)
	        clone.neighbors.add(helper(ne, map));
	    return clone;
	}

	//Solution 2, BFS + memoization, Time O(V+E), Space O(V)
	public static GraphNode cloneBFS(GraphNode src) {
	    if (src == null)
	    	return null;
	    Map<GraphNode, GraphNode> map = new HashMap<>(); //stores (original node, copy node) pair
	    Queue<GraphNode> q = new LinkedList<>();
	    q.add(src);
	    map.put(src, new GraphNode(src.label));
	    while (!q.isEmpty()) {
	    	GraphNode v = q.poll();
	    	for (GraphNode ne : v.neighbors) {
	    		if (!map.containsKey(ne)) {
	    			map.put(ne, new GraphNode(ne.label));
	    			q.add(ne);
	    		}
	    		map.get(v).neighbors.add(map.get(ne));
	    	}
	    }
	    return map.get(src);
	}

	public static void main(String args[]) {
		/*
		Undirected graph
		       1
		      / \
		     /   \
		    0 --- 2
		         / \
		         \_/
		 */
		int size = 3;
		Graph g = new Graph(size);
		GraphNode n0, n1, n2;
		n0 = new GraphNode(0);
		n1 = new GraphNode(1);
		n2 = new GraphNode(2);
		g.addNode(n0);
		g.addNode(n1);
		g.addNode(n2);
		n0.neighbors.add(n1);
		n1.neighbors.add(n0);
		n0.neighbors.add(n2);
		n2.neighbors.add(n0);
		n1.neighbors.add(n2);
		n2.neighbors.add(n1);
		n2.neighbors.add(n2);
        GraphNode root = n0;

        //Solution 1, DFS
        System.out.print("Clone graph (DFS): ");
        GraphNode root1 = cloneDFS(root);
        g.dfs(root1);
        System.out.println();

        //Solution 2, BFS
        System.out.print("Clone graph (BFS): ");
        GraphNode root2 = cloneBFS(root);
        g.bfs(root2);
        System.out.println();
    }
}
