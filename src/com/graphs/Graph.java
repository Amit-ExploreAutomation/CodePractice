package com.graphs;

import java.util.*;

class GraphNode {

	protected int label;
	protected String data = "";
	protected List<GraphNode> neighbors = new LinkedList<>();
	protected boolean visited = false;

	//Constructor, Time O(1), Space O(1)
    public GraphNode(int index, String value) {
        this.label = index;
        this.data = value;
    }

    //Constructor, Time O(1), Space O(1)
    public GraphNode(int index) {
    	this.label = index;
    }

    //Add a neighbor, Time O(1), Space O(1)
    public void addNeighbor(GraphNode node) {
    	this.neighbors.add(node);
    }

    //Remove a neighbor, Time O(1), Space O(1)
    public void removeNeighbor(GraphNode node) {
    	this.neighbors.remove(node);
    }

  	//Remove all neighbors, Time O(n), Space O(1), n is number of neighbors
    public void removeAllNeighbors() {
    	for (GraphNode ne : neighbors)
    		ne.removeNeighbor(this);
    	neighbors.clear();
    }

    //Return next unvisited neighbor, Time O(n), Space O(1)
	public GraphNode getNextUnvisitedNode() {
		for (GraphNode ne : neighbors) {
			if (ne.visited == false)
				return ne;
		}
		return null;
	}

	//Print data and update status, Time O(1), Space O(1)
	public boolean visitNode() {
		if (visited == false) {
			visited = true;
			if (data.length() > 0)
				System.out.print(this.data + " ");
			else
				System.out.print(String.valueOf(label) + " ");
			return true;
		}
		return false;
	}

	//Override, Time O(1), Space O(1)
	public String toString() {
		if (data.length() > 0)
			return this.data + " ";
		else
			return String.valueOf(label) + " ";
	}
}

public class Graph {

	protected int maxSize;
	protected GraphNode vertices[];
	protected GraphNode root = null;
	protected int length = 0;

	//Constructor, Time O(1), Space O(1)
	public Graph(int size) {
		maxSize = size;
		vertices = new GraphNode[maxSize];
    }

	//Add a node, Time O(1), Space O(1)
    public void addNode(GraphNode node) {
	   	if (length < maxSize) {
			vertices[length] = node;
			length ++;
		} else
			System.out.print("Graph full");
		if (length == 1)
			root = vertices[0];  //root is vertices[0], first added node
    }

    //Remove a node, Time O(V+E), Space O(1), V is number of vertices in graph, E is number of edges
    public GraphNode removeNode(GraphNode node) {
    	List<GraphNode> list = Arrays.asList(vertices);
    	if (!list.contains(node))
    		return root;
    	node.removeAllNeighbors();
    	int i, pos = 0;
    	for (i = 0; i < length; i++) {
    		for (GraphNode ne : vertices[i].neighbors) {
    			if (ne.label == node.label)
    				vertices[i].removeNeighbor(ne);
    		}
            if (vertices[i].label == node.label)
            	pos = i;
        }
    	for (int j = pos; j < length-1; j++) //move rest
    		vertices[j] = vertices[j+1];
    	if (i == 0)
    		root = vertices[0];
    	length --;
    	return root;
    }

    //Add directed edge, Time O(1), Space O(1)
    public void addEdge(GraphNode u, GraphNode v) {
    	List<GraphNode> list = Arrays.asList(vertices);
    	if (list.contains(u) && list.contains(v))
    		u.addNeighbor(v);
    }

    //Remove directed edge, Time O(1), Space O(1)
    public void removeEdge(GraphNode u, GraphNode v) {
    	List<GraphNode> list = Arrays.asList(vertices);
    	if (list.contains(u) && list.contains(v))
    		u.removeNeighbor(v);
    }

    //Add undirected edge, Time O(1), Space O(1)
    public void addDoubleEdge(GraphNode u, GraphNode v) {
    	List<GraphNode> list = Arrays.asList(vertices);
    	if (list.contains(u) && list.contains(v)) {
    		u.addNeighbor(v);
	    	v.addNeighbor(u);
    	}
    }

    //Remove undirected edge, Time O(1), Space O(1)
    public void removeDoubleEdge(GraphNode u, GraphNode v) {
    	List<GraphNode> list = Arrays.asList(vertices);
    	if (list.contains(u) && list.contains(v)) {
    		u.removeNeighbor(v);
	    	v.removeNeighbor(u);
    	}
    }

    //Breath first search, Time O(V+E), Space O(V)
	public GraphNode search(GraphNode src, int key) {
		Queue<GraphNode> queue = new LinkedList<>();
		if (src.label == key)
			return src;
		src.visited = true;
		queue.add(src);
		while (!queue.isEmpty()) {
			GraphNode v = queue.poll();
			for (GraphNode ne : v.neighbors) {
				if (ne.label == key)
					return ne;
				if (ne.visited == false) {
					ne.visited = true;
					queue.add(ne);
				}
			}
		}
		return null;
	}

	//Depth first traversal, Time O(V+E), Space O(V)
	public void dfs(GraphNode src) {
		Stack<GraphNode> stack = new Stack<>();
		src.visitNode();
		stack.push(src);
		while (!stack.isEmpty()) {
			GraphNode v = (GraphNode)stack.peek();
			GraphNode ne = v.getNextUnvisitedNode();
			if (ne != null) {
				if (ne.visitNode())
					stack.push(ne);
			} else
				stack.pop();
		}
	}

	//Breath first traversal, Time O(V+E), Space O(V)
	public void bfs(GraphNode src) {
		Queue<GraphNode> queue = new LinkedList<>();
		src.visitNode();
		queue.add(src);
		while (!queue.isEmpty()) {
			GraphNode v = queue.poll();
			for (GraphNode ne : v.neighbors) {
				if (ne.visitNode())
					queue.add(ne);
			}
		}
	}

	//Reset visited status, Time O(V), Space O(1)
	public void clearVisited() {
		for (GraphNode v : vertices) {
			if (v != null)
				v.visited = false;
		}
	}

	//Return number of nodes in graph, Time O(1), Space O(1)
	public int size() {
		return length;
	}

	//Return root, Time O(1), Space O(1)
	public GraphNode getRoot() {
		return root;
	}

	public static void main(String a[])	{
		/* Directed
		 A(0)--->b(1)
		  |   /
		  v <
         C(2)--->D(3)
                 |
                 v
         E(4)<---F(5)
		 */
		//build graph
		int size = 10;
		Graph g = new Graph(size);
		GraphNode n0, n1, n2, n3, n4, n5;
		g.addNode(n0 = new GraphNode(0, "A"));
		g.addNode(n1 = new GraphNode(1, "B"));
		g.addNode(n2 = new GraphNode(2, "C"));
		g.addNode(n3 = new GraphNode(3, "D"));
		g.addNode(n4 = new GraphNode(4, "E"));
		g.addNode(n5 = new GraphNode(5, "F"));
		g.addEdge(n0, n1);
		g.addEdge(n0, n2);
		g.addEdge(n1, n2);
		g.addEdge(n2, n3);
		g.addEdge(n3, n5);
		g.addEdge(n5, n4);
		GraphNode root = g.getRoot();
		System.out.println("Graph size: " + g.size());
        for (int i = 0; i < g.length; i++) {
        	System.out.print(g.vertices[i]);
        	System.out.println(g.vertices[i].neighbors);
        }

        //Traversal and search
		System.out.print("DFS: ");
		g.dfs(root);
		g.clearVisited();
		System.out.print("\nBFS: ");
		g.bfs(root);
		g.clearVisited();
		System.out.println();
		int key = 3;
		GraphNode node = g.search(root, key);
		System.out.println("Found node by key " + key + ": " + node);
		System.out.println();

		//Remove a node
		GraphNode r1 = g.removeNode(n4);
		System.out.println("The size after remove " + n4 + ": " + g.size());
        for (int i = 0; i < g.length; i++) {
        	System.out.print(g.vertices[i]);
        	System.out.println(g.vertices[i].neighbors);
        }
        g.clearVisited();
        System.out.print("DFS: ");
		g.bfs(r1);
		g.clearVisited();
		System.out.print("\nBFS: ");
		g.bfs(r1);
		g.clearVisited();
	}
}

