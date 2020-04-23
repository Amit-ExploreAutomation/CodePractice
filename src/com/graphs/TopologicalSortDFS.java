package com.graphs;
/*
(Amazon) Suppose you have a list of tasks which need to be executed. Some of these tasks have
dependencies which must be executed before they are.
Write a method in which, when given a list of tasks with dependencies, return a valid ordering.
Example:
Input: [ A, B, C, D ]
A <- B, C
B <- C, D
D <- C
Return: [ C, D, B, A ]
*/
import java.util.*;

public class TopologicalSortDFS {

	//DFS wrapper func, Time O(V+E+k) ~ O(V+E), Space O(V+k) ~ O(V),
	//V is number of vertices, E is number of edges, k is output length
	public static List<GraphNode> topoSort(Graph g) {
		int n = g.size();
		boolean[] visited = new boolean[n];
		Stack<GraphNode> path = new Stack<>(); //stores partial result
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				dfs(g, i, path, visited);
		}
		List<GraphNode> res = new ArrayList<>();
		while (!path.isEmpty()) //output new order
			res.add(path.pop());
		return res;
	}

	//DFS + memoization, Time O(V+E), Space O(V)
	private static void dfs(Graph g, int i, Stack<GraphNode> path, boolean[] visited) {
		visited[i] = true;
		for (GraphNode ne : g.vertices[i].neighbors) {
			int j = ne.label;
			if (!visited[j])
				dfs(g, j, path, visited);
		}
		path.push(g.vertices[i]);
	}

	public static void main(String[] args) {
		/*
		Input: [ A, B, C, D ]
				A <- B, C
				B <- C, D
				D <- C
		*/
		int size = 4;
		Graph g = new Graph(size);
		GraphNode m1, m2, m3, m4;
		g.addNode(m1 = new GraphNode(0, "A"));
		g.addNode(m2 = new GraphNode(1, "B"));
		g.addNode(m3 = new GraphNode(2, "C"));
		g.addNode(m4 = new GraphNode(3, "D"));
		g.addEdge(m2, m1); //B->A
		g.addEdge(m3, m1); //C->A
		g.addEdge(m3, m2); //C->B
		g.addEdge(m4, m2); //D->B
		g.addEdge(m3, m4); //C->D
		System.out.print("Topological sort: "+ topoSort(g));
	}
}
