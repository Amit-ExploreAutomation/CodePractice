package com.graphs;
/*
(Facebook) There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 1 you have to first take course 0, which is expressed as a pair: [1,0]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
Example:
Input: 4, [1,0],[2,0],[3,1],[3,2]
Output: [0,1,2,3]
*/
import java.util.*;

public class CoursesOrder {

	//Topological sort with Kahn's algorithm, Time O(n), Space O(n), n is course number
	@SuppressWarnings("unchecked")
	public static int[] coursesOrder(int[][] courses) {
		int n = courses.length;
	    List<Integer>[] graph = new ArrayList[n];
	    Queue<Integer> q = new LinkedList<>();
	    int[] indegree = new int[n];
	    for (int i = 0; i < n; i++)
	    	graph[i] = new ArrayList<>();
	    for (int[] edge : courses) { //build graph
	        graph[edge[1]].add(edge[0]); //add (prerequisite, follower) in graph
	        indegree[edge[0]]++; //follower's all prerequisites
	    }
	    for (int i = 0; i < indegree.length; i++) {
	        if (indegree[i] == 0)
	        	q.add(i); //put no incoming vertex in the queue
	    }
	    int count = 0;
	    int[] res = new int[n];
	    while (!q.isEmpty()) {
	    	int i = q.poll();
	        res[count++] = i;
	        for (int j : graph[i]) {
	        	indegree[j]--; //remove outgoing edges
	            if (indegree[j] == 0)
	            	q.add(j); //put no incoming vertex in the queue
	        }
	    }
	    if (count == n)
	    	return res; //return topological sort result
	    return new int[0]; //cannot sort successfully
	}

	public static void main(String args[]) {
		int[][] courses = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		System.out.print("Take courses in order: ");
		int[] d = coursesOrder(courses);
		for (int i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
	}
}
