package com.graphs;
/*
(Bloomberg) Write code to print all different paths from a given source to destination with no loop.
Example:
Given directed graph
		 0--->3
	     ^    ^
	   	|| \  |
	   	V   >
	   	 2 -->1
Source 2, Destination 3
output:
2 0 1 3
2 0 3
2 1 3
*/
import java.util.*;

public class PrintAllPathsFromSrcToDest {

	//DFS Wrapper func, Time O(V+E), Space O(V), V is number of vertices, E is number of edges
	//It works for both directed and undirected graph
	public static void printAllPaths(GraphNode src, GraphNode dest) {
		Set<GraphNode> path = new LinkedHashSet<>();
	    helper(src, dest, path);
	}

	//Backtracking + memoization, Time O(V+E), Space O(V)
	private static void helper(GraphNode src, GraphNode dest, Set<GraphNode> path) {
	    if (path.contains(src))
	    	return;
	    if (dest.equals(src)) {
	        for (GraphNode v : path)
	            System.out.print(v);
	        System.out.println(dest);
	        return;
	    }
	    path.add(src);
	    for (GraphNode ne : src.neighbors)
	        helper(ne, dest, path);
	    path.remove(src);
	}

	public static void main(String a[])	{
		/*
		 Test case 1, Directed graph
		 0--->3
	     ^    ^
	   	|| \  |
	   	V   >
	   	 2 -->1
		*/
		int size = 4;
		Graph g = new Graph(size);
		GraphNode n0, n1, n2, n3;
		g.addNode(n0 = new GraphNode(0));
		g.addNode(n1 = new GraphNode(1));
		g.addNode(n2 = new GraphNode(2));
		g.addNode(n3 = new GraphNode(3));
		n0.addNeighbor(n2);
		n2.addNeighbor(n0);
		n0.addNeighbor(n3);
		n2.addNeighbor(n1);
		n1.addNeighbor(n3);
		n0.addNeighbor(n1);
        GraphNode s = n2;
        GraphNode d = n3;
		System.out.println("Directed graph, find path from " + s.label + " to " + d.label + ": ");
		printAllPaths(s, d);
		System.out.println();

		/*
		 Test case 2, Undirected graph
		 *  1-----2
		 *  |   / |
		 *  3  5  4
		 *  | / \ |
		 *  6-----7
		 */
		size = 10;
		Graph g1 = new Graph(size);
		GraphNode m1, m2, m3, m4, m5, m6,m7;
		g1.addNode(m1 = new GraphNode(1));
		g1.addNode(m2 = new GraphNode(2));
		g1.addNode(m3 = new GraphNode(3));
		g1.addNode(m4 = new GraphNode(4));
		g1.addNode(m5 = new GraphNode(5));
		g1.addNode(m6 = new GraphNode(6));
		g1.addNode(m7 = new GraphNode(7));
        g1.addDoubleEdge(m1, m2);
        g1.addDoubleEdge(m1, m3);
        g1.addDoubleEdge(m2, m4);
        g1.addDoubleEdge(m2, m5);
        g1.addDoubleEdge(m3, m6);
        g1.addDoubleEdge(m5, m6);
        g1.addDoubleEdge(m5, m7);
        g1.addDoubleEdge(m6, m7);
        g1.addDoubleEdge(m4, m7);
        GraphNode s1 = m1;
        GraphNode d1 = m7;
        System.out.println("Undirected graph, find path from " + s1.label + " to " + d1.label + ": ");
        printAllPaths(s1, d1);
	}
}
