package com.graphs;
/*
(Facebook) Given an undirected graph as input, write a method returning boolean true if the graph is bipartite, else false.
Bipartite graph is a graph whose vertices can be divided into two sets U and V.  Every edge connects a vertex in U to a vertex in V.
The two sets U and V may be thought of as a coloring of the graph with two colors.
Examples:
	   1--2
	 /     \
	6       3
	 \     /
	  5 -- 4
return true

	0--1
	|\ |
	| \|
	3--2
return false
*/

public class IsBipartite {

	//DFS wrapper func, Time O(V+E), Space O(V), V is number of vertices, E is number of edges
	public static boolean isBipartite(Graph g) {
		int n = g.size();
		boolean[] visited = new boolean[n];
	    boolean[] color = new boolean[n];
	    visited[0] = true;
	    return helper(g, 0, visited, color);
	}

	//DFS + memoization, Time O(V+E), Space O(V)
	private static boolean helper(Graph g, int i, boolean[] visited, boolean[] color) {
	    for (GraphNode ne : g.vertices[i].neighbors) {
	    	int j = ne.label;
	        if (visited[j] == false) {
	            visited[j] = true;
	            color[j] = !color[i];
	            if (!helper(g, j, visited, color))
	                return false;
	        } else if (color[j] == color[i])
	            return false;
	    }
	    return true;
	}

	public static void main(String args[])  {
		/* Test case1: return true
		  1 -- 2
		 /      \
		6        3
		 \      /
		  5 -- 4
		*/
	    int N = 10;
		GraphNode n1, n2, n3, n4, n5, n6;
	    Graph g = new Graph(N);
		g.addNode(n1 = new GraphNode(0));
		g.addNode(n2 = new GraphNode(1));
		g.addNode(n3 = new GraphNode(2));
		g.addNode(n4 = new GraphNode(3));
		g.addNode(n5 = new GraphNode(4));
		g.addNode(n6 = new GraphNode(5));
	    g.addDoubleEdge(n1, n2);
	    g.addDoubleEdge(n2, n3);
	    g.addDoubleEdge(n3, n4);
	    g.addDoubleEdge(n4, n5);
	    g.addDoubleEdge(n5, n6);
	    g.addDoubleEdge(n6, n1);
	    System.out.println("Is graph 1 bipartite? " + isBipartite(g)) ;

	    /*
		Test case 2, Return false
		0--1
		|\ |
		| \|
		3--2
		*/
	    N = 4;
	    Graph g1 = new Graph(N);
	    GraphNode m0, m1, m2, m3;
	    g1.addNode(m0 = new GraphNode(0));
		g1.addNode(m1 = new GraphNode(1));
		g1.addNode(m2 = new GraphNode(2));
		g1.addNode(m3 = new GraphNode(3));
	    g1.addDoubleEdge(m0, m1);
	    g1.addDoubleEdge(m0, m2);
	    g1.addDoubleEdge(m0, m3);
	    g1.addDoubleEdge(m1, m2);
	    g1.addDoubleEdge(m3, m2);
	    System.out.println("Is graph 2 bipartite? " + isBipartite(g1)) ;
	}
}
