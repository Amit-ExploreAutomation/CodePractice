package com.arrays;
/*
(Bloomberg) Given an array nums, write a function to move all 0's to the end of it while maintaining
the relative order of the non-zero elements. do this in-place without making a copy of the array.
For example,
Input [0, 0, 1, 2, 0]
Output [1, 2, 0, 0, 0]
*/

public class MoveAllZerosToEnd {

	//Two passes, Time O(n), Space O(1), n is array length
	public static void moveZerosToEnd(int[] a) {
	    int count = 0;
	    int n = a.length;
	    for (int i = 0; i < n; i++) {
	        if (a[i] != 0)
	            a[count++] = a[i];
	    }
	    for (int i = count; i < n; i++)
	        a[count++] = 0;
	}

    public static void main(String args[]) {
        int[] arr = {0, 0, 1, 2, 0, 5, 6, 7, 0};
        System.out.print("Input: ");
	    Array.print(arr);
        moveZerosToEnd(arr);
        System.out.print("After move 0s: ");
        Array.print(arr);
    }
}
