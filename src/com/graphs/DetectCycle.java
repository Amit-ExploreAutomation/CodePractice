package com.graphs;
/*
(Amazon) Check if there is a cycle in an undirected and directed graph.
For example:
Input: undirected graph
 0--2---3
 | /
 1
Output: true

Input: directed graph
 a ---> b
 |     |
 |     |
 v---->v
 c     d
Output: false
*/

public class DetectCycle {

	//Undirected DFS wrapper func, Time O(V+E), Space O(V), V is number of vertices, E is number of edges
	public static boolean isCyclicUndirected(Graph g) {
		int n = g.size();
	    boolean[] visited = new boolean[n];
	    for (int i = 0; i < n; i++) {
	        if (!visited[i])
	            if (helperU(g, i, -1, visited))
	                return true;
	    }
	    return false;
	}

	//Undirected helper, DFS + memoization, Time O(V+E), Space O(V)
	private static boolean helperU(Graph g, int i, int prev, boolean[] visited) {
	    visited[i] = true;
	    for (GraphNode ne : g.vertices[i].neighbors) {
	        if (!visited[ne.label]) {
	            if (helperU(g, ne.label, i, visited))
	                return true;
	        } else if (ne.label != g.vertices[prev].label)
	        	return true;
	    }
	    return false;
	}

	//Directed, DFS wrapper func, Time O(V+E), Space O(V)
	public static boolean isCyclicDirected(Graph g) {
		int n = g.size();
	    boolean[] visited = new boolean[n];
	    boolean[] backtrack = new boolean[n];
	    for (int i = 0; i < n; i++) {
	        if (helperD(g, i , visited, backtrack))
	            return true;
	    }
	    return false;
	}

	//Directed helper, Backtracking + memoization, Time O(V+E), Space O(V)
	private static boolean helperD(Graph g, int i, boolean[] visited, boolean[] backtrack) {
	    if (backtrack[i])
	    	return true;
	    if (visited[i])
	    	return false;
	    visited[i] = true;
	    backtrack[i] = true;
	    for (GraphNode ne : g.vertices[i].neighbors) {
	        if (helperD(g, ne.label, visited, backtrack))
	            return true;
	    }
	    backtrack[i] = false;
	    return false;
	}

	public static void main(String a[])	{
		/*
		 Test case 2, Undirected graph
			 0- 2 --3
			 | /
			 1
		 */
		int size = 4;
		Graph g1 = new Graph(size);
		GraphNode m0, m1, m2, m3;
		g1.addNode(m0 = new GraphNode(0));//index is the same as their label
		g1.addNode(m1 = new GraphNode(1));
		g1.addNode(m2 = new GraphNode(2));
		g1.addNode(m3 = new GraphNode(3));
		g1.addDoubleEdge(m0, m1);
		g1.addDoubleEdge(m0, m2);
		g1.addDoubleEdge(m1, m2);
		g1.addDoubleEdge(m2, m3);
		System.out.print("Undirected graph nodes: ");
		g1.dfs(g1.root);
		System.out.println("\nHas cycle: " + isCyclicUndirected(g1) + "\n");

		/*
		Test case 1, Directed graph
		 a ---> b
		 |    |
		 |    |
		 v--->v
		 c    d
		*/
		Graph g = new Graph(size);
		GraphNode n0, n1, n2, n3;
		g.addNode(n0 = new GraphNode(0, "a"));
		g.addNode(n1 = new GraphNode(1, "b"));
		g.addNode(n2 = new GraphNode(2, "c"));
		g.addNode(n3 = new GraphNode(3, "d"));
		g.addEdge(n0, n1);
		g.addEdge(n0, n2);
		g.addEdge(n1, n3);
		g.addEdge(n2, n3);
		System.out.print("Directed graph nodes: ");
		g.dfs(g.root);
		System.out.println("\nHas cycle: " + isCyclicDirected(g));
		System.out.println();
	}
}
