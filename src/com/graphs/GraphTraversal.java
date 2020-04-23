package com.graphs;
/*
(Amazon) Implement the graph DFS and BFS traversal.
 Example:
 1-- 3
 | / |
 2   4
Output: 1 3 2 4
*/
import java.util.*;

public class GraphTraversal {

	//Define a simplified GraphNode
	private static class GraphNode {
	    private int label;
	    private List<GraphNode> neighbors;

	    //Constructor, Time O(1), Space O(1)
	    public GraphNode(int val) {
	        this.label = val;
	        neighbors = new ArrayList<GraphNode>();
	    }
	}

	//Solution 1, DFS wrapper func, Time O(V+E), Space O(V),
	//V is number of vertices, E is number of edges
	public static void dfs(GraphNode src) {
		HashMap<GraphNode, Boolean> visited = new HashMap<>(); //stores (node, visit status) pair
	    helper(src, visited);
	}

	//DFS + memoization, Time O(V+E), Space O(V)
	private static void helper(GraphNode v, HashMap<GraphNode,Boolean> visited) {
	    visited.put(v, true);
	    System.out.print(v.label + " ");
	    for (GraphNode ne : v.neighbors) {
	        if (visited.get(ne) == null)
	            helper(ne, visited);
	    }
	}

	//Solution 2, BFS + memoization, Time O(V+E), Space O(V)
	public static void bfs(GraphNode src) {
	    Queue<GraphNode> q = new LinkedList<>();
	    HashMap<GraphNode, Boolean> visited = new HashMap<>(); //stores (node, visit status) pair
	    q.add(src);
	    visited.put(src, true);
	    while (!q.isEmpty()) {
	        GraphNode v = q.poll();
	        System.out.print(v.label + " ");
	        for (GraphNode ne : v.neighbors)  {
	            if (visited.get(ne) == null) {
	                q.add(ne);
	                visited.put(ne, true);
	            }
	        }
	    }
	    System.out.println();
	}

	public static void main(String args[]) {
		/*
		 Test case 1, Undirected graph
		 1-- 3
		 | / |
		 2   4
		*/
		GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        node1.neighbors.add(node3);
        node3.neighbors.add(node1);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        GraphNode root = node1;
        System.out.println("Undirected graph traversal: ");
        System.out.print("DFS: ");
        dfs(root);
        System.out.print("\nBFS: ");
        bfs(root);
        System.out.println();

        /*
        Test case 2, Directed graph
        1-->2
        |   |
        V   V
        3-->4
            |
            V
        5<--6
        */
    	GraphNode n1 = new GraphNode(1);
    	GraphNode n2 = new GraphNode(2);
    	GraphNode n3 = new GraphNode(3);
    	GraphNode n4 = new GraphNode(4);
    	GraphNode n5 = new GraphNode(5);
    	GraphNode n6 = new GraphNode(6);
		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		n2.neighbors.add(n4);
		n3.neighbors.add(n4);
		n4.neighbors.add(n6);
		n6.neighbors.add(n5);
		root = n1;
        System.out.println("Directed graph traversal:");
        System.out.print("DFS: ");
        dfs(root);
        System.out.print("\nBFS: ");
        bfs(root);
        System.out.println();
    }
}
