package com.graphs;
/*
(Google) You are given a weighted graph, write a method to find the shortest path from source to other vertices.
Example:
		      0
		   10/ \3
		    /   \
		   1--1--4
		 15|  8/ |2
		   | /   |
		   2--7--3
Shortest distance from node 2
2 to 0 is 11
2 to 1 is 9
2 to 2 is 0
2 to 3 is 7
2 to 4 is 8
Hint: This is a non-negative weighted graph, use Dijkstra's algorithm.
*/
import java.util.*;

public class ShortestPathDijkstra {

	//Define Edge class with weight
	protected static class Edge {
		private int next;
		private int weight;

		//Constructor, Time O(1), Space O(1)
		public Edge(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}

	//Define Simplified Graph class with Edge
	protected static class Graph {
	    private int maxSize;
	    private List<Edge>[] vertices;

	    //Constructor, Time O(V), Space O(1), V is number of vertices
	    @SuppressWarnings("unchecked")
		public Graph(int size) {
		    maxSize = size;
		    vertices = new ArrayList[maxSize];
		    for (int i = 0; i < maxSize; i++)
		    	vertices[i] = new ArrayList<>();
		}

	    //Add edge between two vertices (directed), Time O(1), Space O(1)
		public void addEdge(int u, int v, int w) {
		    vertices[u].add(new Edge(v, w));
		}
	}

	//Dijkstra's algorithm, Use PriorityQueue, Time O(V+E*LogV) ~ O(E*logV), Space O(V),
	//V is number of vertices, E is number of edges
	//It works for both undirected and directed graph
	public static int[] dijkstra(Graph g, int src) {
		int n = g.maxSize;
	    PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> a[0] - b[0]); //sort by distance, ascending
	    int[] dist = new int[n];
	    for (int i = 0; i < n; i++)
	    	dist[i] = Integer.MAX_VALUE;
	    pq.add(new int[] {0, src}); //int[] stores (distance, label) pair
	    dist[src] = 0;
	    while (!pq.isEmpty()) {
	        int i = pq.poll()[1]; //get smallest distance's label
	        for (Edge x : g.vertices[i]) {
	            int j = x.next;
	            int weight = x.weight;
	            if (dist[j] > dist[i] + weight) {
	                dist[j] = dist[i] + weight;
	                pq.add(new int[] {dist[j], j});
	            }
	        }
	    }
	    return dist;
	}

	public static void main(String[] arags) {

		/*
		Test case 1, Undirected and weighted graph
	      0
	   10/ \3
	    /   \
	   1--1--4
	 15|  8/ |2
	   | /   |
	   2--7--3
	   */
		int n = 5;
		Graph g = new Graph(n);
	    g.addEdge(0, 1, 10);  g.addEdge(1, 0, 10); //add both side edges, undirected
	    g.addEdge(0, 4, 3);   g.addEdge(4, 0, 3);
	    g.addEdge(1, 4, 1);   g.addEdge(4, 1, 1);
	    g.addEdge(1, 2, 15);  g.addEdge(2, 1, 15);
	    g.addEdge(2, 3, 7);   g.addEdge(3, 2, 7);
	    g.addEdge(2, 4, 8);   g.addEdge(4, 2, 8);
	    g.addEdge(3, 4, 2);   g.addEdge(4, 3, 2);
	    int src = 2;
	    System.out.println("Undirected graph:");
	    int[] r = dijkstra(g, src);
	    for (int i = 0; i < n; i++)
			System.out.println("The shortet distance from " + src + " to " + i + ": " + r[i]);

	    //Test case 2, Directed and weighted graph
		Graph g1 = new Graph(n);
	    g1.addEdge(0, 1, 10); //add one side edge, directed
	    g1.addEdge(0, 4, 3);
	    g1.addEdge(1, 2, 2);
	    g1.addEdge(1, 4, 4);
	    g1.addEdge(2, 3, 9);
	    g1.addEdge(2, 1, 5);
	    g1.addEdge(3, 2, 7);
	    g1.addEdge(3, 4, 3);
	    g1.addEdge(4, 1, 1);
	    g1.addEdge(4, 2, 8);
	    g1.addEdge(4, 3, 2);
	    int src1 = 2;
	    System.out.println("\nDirected graph:");
	    int[] r1 = dijkstra(g1, src1);
	    for (int i = 0; i < n; i++)
			System.out.println("The shortet distance from "+ src1 + " to " + i + ": " + r1[i]);
	}
}
