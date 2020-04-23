package com.arrays;
/*
(Google) Given an array of tasks with (runtime, finishByTime), start time at 0, return whether all the tasks can be finished.
For example,
tasks = [t1, t2, t3] t1=(100, 500), t2=(10, 40), t3=(20, 40),
Return true.
*/
import java.util.*;

public class TaskScheduler {

	//Greedy, Sort first, Time O(n*logn), Space O(1), n is the number of tasks
	public static boolean canFinishAll(int[][] tasks) {
		Arrays.sort(tasks, (x, y) -> y[1] - x[1]); //sort by finishByTime to get the max time limit, descending
		int maxTime = tasks[0][1];
		Arrays.sort(tasks, (x, y) -> x[0] - y[0]); //sort by runtime, start from the shortest task, ascending
		int timeLeft = maxTime;
		int timeUsed = 0;
		for (int[] x : tasks) {
			if (timeUsed + x[0] > x[1] || timeLeft < x[0])
				return false;
			timeLeft = timeLeft - x[0];
			timeUsed += x[0];
		}
		return true;
	}

	public static void main(String[] args) {
		//Test case 1, Can finish all tasks
		int[][] tasks = {{100, 500}, {10, 40}, {20, 40}};
        System.out.print("Tasks: ");
        for (int i = 0; i < tasks.length; i++)
        	System.out.print("(" + tasks[i][0] + ", " + tasks[i][1] + ") ");
        System.out.println();
		System.out.println("Can finish all? " + canFinishAll(tasks));
		System.out.println();

		//Test case 2, Unable to finish all tasks
		int[][] tasks1 = {{470, 500}, {10, 40}, {40, 60}};
		System.out.print("Tasks: ");
		for (int i = 0; i < tasks.length; i++)
			System.out.print("(" + tasks[i][0] + ", " + tasks[i][1] + ") ");
        System.out.println();
		System.out.println("Can finish all? " + canFinishAll(tasks1));
	}
}
