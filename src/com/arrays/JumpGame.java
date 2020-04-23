package com.arrays;
/*
(Amazon) Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last.
A = [2,3,1,1,4], return true.

Variant: Return the minimum number of jumps to reach the end. Implement in O(n) complexity. if cannot, return -1
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2.
*/

public class JumpGame {

	//Check can reach end, Greedy, Time O(n), Space O(1), n is array length
	public static boolean canReachEnd(int[] a) {
		int max = 0, i, n = a.length;
	    for (i = 0; i < n && i <= max; i++)
	        max = Math.max(max, i + a[i]);
	    return i == n;
	}

	//Get minimum jumps, Greedy, Call canReachEnd first, Time O(n), Space O(1)
	public static int minJump(int[] a) {
		if (!canReachEnd(a))
			return -1;
	    int pos = 0, max = 0, count = 0;
	    for (int i = 0; i < a.length-1; i++) {
	    	max = Math.max(max, i + a[i]);
	        if (pos == i) {
	            count++;
	            pos = max;
	        }
	    }
	    return count;
	}

	public static void main(String args[]) {
		//Test case 1, Can reach the end
        int[] arr = {2, 3, 1, 1, 4};
        System.out.print("Input: ");
        Array.print(arr);
        System.out.println("Can reach to last? " + canReachEnd(arr));
        System.out.println("Min jumps: " + minJump(arr));
        System.out.println();

        //Test case 2, Cannot reach the end
        int[] arr1 = {3, 2, 1, 0, 4};
        System.out.print("Input: ");
        Array.print(arr1);
        System.out.println("Can reach to last? " + canReachEnd(arr1));
        System.out.println("Min jumps: " + minJump(arr1));
    }
}
