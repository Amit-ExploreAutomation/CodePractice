package com.graphs;
/*
(Google) Given a Directed Graph and two vertices in it, check whether there is a path from the first given
vertex to second.
For example, in the following graph, there is a path from vertex 1 to 3.
there is no path from 3 to 0.
     	 0--->1
    	 |  /
    	 V <
    	 2--->3
  1->3 true
  3->0 false
*/
import java.util.*;

public class HasPathFromSrcToDest {

	//BFS + memoization , Time O(V+E), Space O(V), V is number of vertices, E is number of edges
	public static boolean hasPath(Graph g, GraphNode src, GraphNode dest) {
	    boolean[] visited = new boolean[g.size()];
	    Queue<GraphNode> q = new LinkedList<>();
	    visited[src.label] = true;
	    q.add(src);
	    while (!q.isEmpty()) {
	        GraphNode v = q.poll();
	        for (GraphNode ne : v.neighbors) {
	            if (ne == dest)
	                return true;
	            if (!visited[ne.label]) {
	                visited[ne.label] = true;
	                q.add(ne);
	            }
	        }
	    }
	    return false;
	}

    public static void main(String args[]) {
    	/*
    	 Directed graph
    	 0--->1
    	 |   /
    	 V <
    	 2--->3
    	 */
		int size = 4;
		Graph g = new Graph(size);
		GraphNode n0, n1, n2, n3;
		g.addNode(n0 = new GraphNode(0));
		g.addNode(n1 = new GraphNode(1));
		g.addNode(n2 = new GraphNode(2));
		g.addNode(n3 = new GraphNode(3));
		g.addEdge(n0, n1);
		g.addEdge(n0, n2);
		g.addEdge(n1, n2);
		g.addEdge(n2, n0);
		g.addEdge(n2, n3);
		g.addEdge(n3, n3);

		//Test case 1, return true
		GraphNode src = n1;
		GraphNode dest = n3;
        System.out.println("From node " + src.label + " to " + dest.label + ", has path? " + hasPath(g, src, dest));

		//Test case 2, Return false
        GraphNode src1 = n3;
		GraphNode dest1 = n0;
		System.out.println("From node " + src1.label + " to " + dest1.label + ", has path? " + hasPath(g, src1, dest1));
    }
}
