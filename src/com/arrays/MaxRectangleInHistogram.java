package com.arrays;
/*
(Facebook) Given n non-negative integers representing the histogram's bar height where
the width of each bar is 1, find the area of largest rectangle in the histogram.
For example,
Given heights = [2,1,2,3],
Return 4.
        _
  _   _|_|
 | |_|x|x|
_|_|_|x|x|__
*/
import java.util.Stack;

public class MaxRectangleInHistogram {

	//Solution 1, Use array simulate stack, Faster than solution 2,
	//Time O(n), Space O(n), n is array length
	public static int maxArea(int[] a) {
	    int n = a.length;
	    int[] stack = new int[n+1]; //array simulates stack, stores index
	    int maxArea = 0, top = -1;
	    for (int i = 0; i <= n; i++) {
	        int x = (i == n) ? 0 : a[i];
	        while (top != -1 && x < a[stack[top]]) {
	            int height = a[stack[top--]];
	            int width = (top == -1) ? i : i-stack[top]-1;
	            int area = height * width;
	            maxArea = Math.max(maxArea, area);
	        }
	        stack[++top] = i;
	    }
	    return maxArea;
	}

	//Solution 2, Use Stack, Time O(n), Space O(n)
	public static int maxAreaStack(int[] a) {
		int n = a.length;
		Stack<Integer> stack = new Stack<>(); //stores index
		int maxArea = 0;
		for (int i = 0; i <= n; i++) {
			int x = (i == n) ? 0 : a[i];
			while (!stack.isEmpty() && x < a[stack.peek()]) {
				int height = a[stack.pop()];
				int value = stack.isEmpty() ? -1 : stack.peek();
				int area = height * (i-value-1);
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		return maxArea;
	}

    public static void main(String[] args) {
    	int[] hist = {2, 1, 5, 6, 2, 3};
    	System.out.print("Input: ");
    	Array.print(hist);
        System.out.println("The max area in histogram (array): " +  maxArea(hist));
        System.out.println("The max area in histogram (stack): " +  maxAreaStack(hist));
    }
}

