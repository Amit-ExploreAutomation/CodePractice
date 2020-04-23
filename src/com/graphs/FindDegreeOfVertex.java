package com.graphs;
/*
(Google) Find the degree of vertex in graph.
The degree of a vertex in an undirected graph is the number of edges associated with it.
In a directed graph, the in-degree of a vertex denotes the number of edges coming to this vertex.
The out-degree of a vertex is the number of edges leaving the vertex.
For example:
0---1
|\  |
| \ |
2---3
Input : node 0  Output : 3
Input: node 1 output: 2
*/

public class FindDegreeOfVertex {

	//Undirected graph, Return degree, Time O(V), Space O(V), V is number of vertices
	public static int findDegreeUndirected(Graph g, GraphNode v) {
		int n = g.size();
	    int degree[] = new int[n];
	    for (int i = 0; i < n; i++)
	        degree[i] = g.vertices[i].neighbors.size();
	    return degree[v.label]; //return degree
	}

	//Directed graph, Return indegree and outdegree, Time O(V*E), Space O(V), E is number of edges
	public static int[] findDegreeDirected(Graph g, GraphNode v) {
		int n = g.size();
	    int indegree[] = new int[n];
	    int outdegree[] = new int[n];
	    for (int i = 0; i < n; i++) {
	        outdegree[i] = g.vertices[i].neighbors.size();
	        for (GraphNode ne : g.vertices[i].neighbors)
	        	indegree[ne.label]++;
	    }
	    return new int[]{indegree[v.label], outdegree[v.label]}; //return in-degree and outdegree
	}

    public static void main(String args[]) {
    	/*
    	Test case 1, Undirected graph
    	0-----1
		|\    |
		|  \  |
		|    \|
		2-----3
    	*/
		Graph g = new Graph(4);
		GraphNode n0 = new GraphNode(0);
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		g.addNode(n0);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
        g.addDoubleEdge(n0, n1);
        g.addDoubleEdge(n0, n2);
        g.addDoubleEdge(n1, n3);
        g.addDoubleEdge(n2, n3);
        g.addDoubleEdge(n0, n3);
        System.out.println("Undirected graph: ");
        GraphNode key = n0;
        System.out.println("Find node " + key.label + " degree: "  + findDegreeUndirected(g, key));
        key = n1;
        System.out.println("Find node " + key.label + " degree: "  + findDegreeUndirected(g, key));
        System.out.println();

        /*
        Test case 2, Directed graph
           3-->1<--4
           |       |
           V       V
           2<--5-->0
        */
        Graph g1 = new Graph(6);
		GraphNode m0 = new GraphNode(0);
		GraphNode m1 = new GraphNode(1);
		GraphNode m2 = new GraphNode(2);
		GraphNode m3 = new GraphNode(3);
		GraphNode m4 = new GraphNode(4);
		GraphNode m5 = new GraphNode(5);
		g1.addNode(m0);
		g1.addNode(m1);
		g1.addNode(m2);
		g1.addNode(m3);
		g1.addNode(m4);
		g1.addNode(m5);
		m3.neighbors.add(m2);
		m3.neighbors.add(m1);
		m4.neighbors.add(m0);
		m4.neighbors.add(m1);
		m5.neighbors.add(m2);
		m5.neighbors.add(m0);
		System.out.println("Directed graph: ");
		key = m1;
		int[] b1 = findDegreeDirected(g1, key);
		System.out.println("Find node " + key.label + " indegree: " + b1[0] + " outdegree: " + b1[1]);
		key = m4;
		int[] b2 = findDegreeDirected(g1, key);
		System.out.println("Find node " + key.label + " indegree: " + b2[0] + " outdegree: " + b2[1]);
    }
}
