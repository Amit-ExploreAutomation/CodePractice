package com.graphs;
/*
(Amazon) There are several bus lines, each line is a two-way line . Give a start and end,
find the path through the least station.
Example:
Given graph
    B---D   E
    |   | / |
    A   C - F
From A to E
The path through the least station is: [A , B , D , C , E]
Hint: This is a un-weighted and undirected graph, use BFS.
*/
import java.util.*;

public class ShortestPathBFS {

	//BFS Wrapper func, Time O(V+E+k) ~ O(V+E), Space O(V+k) ~ O(V),
	//V is number of vertices, E is number of edges, k is shortest path length
	public static List<GraphNode> leastStation(Graph g, GraphNode src, GraphNode dest) {
		int n = g.size();
		int[] dist = new int[n]; //distances
		GraphNode[] pred = new GraphNode[n]; //predecessors
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = null;
		}
		if (!bfs(g, src, dest, dist, pred))
			return null;
		List<GraphNode> path = new ArrayList<>();
		path.add(dest);
		int i = dest.label;
		while (pred[i] != null) { //output shortest path
			path.add(pred[i]);
			i = pred[i].label;
		}
		Collections.reverse(path);
		return path;
	}

	//BFS + memoization, Time O(V+E), Space O(V)
	private static boolean bfs(Graph g, GraphNode src, GraphNode dest, int[] dist, GraphNode[] pred) {
		int n = g.size();
		Queue<GraphNode> q = new LinkedList<>();
		boolean[] visited = new boolean[n]; //as memo
		visited[src.label] = true;
		dist[src.label] = 0;
		q.add(src);
		while (!q.isEmpty()) {
			GraphNode v = q.poll();
			for (GraphNode ne : g.vertices[v.label].neighbors) {
				int j = ne.label;
				if (!visited[j]) {
					visited[j] = true;
					dist[j] = dist[v.label] + 1;
					pred[j] = v;
					q.add(ne);
					if (j == dest.label) return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
        /*
         Undirected and un-weighted graph
            B---D   E
            |   | / |
            A   C - F
        */
		int size = 6;
		Graph g = new Graph(size);
		GraphNode n0, n1, n2, n3,n4,n5;
		g.addNode(n0 = new GraphNode(0, "A"));
		g.addNode(n1 = new GraphNode(1, "B"));
		g.addNode(n2 = new GraphNode(2, "C"));
		g.addNode(n3 = new GraphNode(3, "D"));
		g.addNode(n4 = new GraphNode(4, "E"));
		g.addNode(n5 = new GraphNode(5, "F"));
        g.addDoubleEdge(n0, n1);
        g.addDoubleEdge(n1, n3);
        g.addDoubleEdge(n3, n2);
        g.addDoubleEdge(n2, n4);
        g.addDoubleEdge(n2, n5);
        g.addDoubleEdge(n4, n5);
        GraphNode s = n0;
        GraphNode d = n4;
        System.out.println("The least station from " + s.data + " to " + d.data + ": " + leastStation(g, s, d));
	}
}
