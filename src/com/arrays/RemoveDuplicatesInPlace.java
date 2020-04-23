package com.arrays;
/*
(Amazon) Given a sorted array, remove the duplicates in place such that each element appear only once and
return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input [0,2,2,6,6,10],
Your function should return length = 4
*/

public class RemoveDuplicatesInPlace {

	//Input array is sorted, Time O(n), Space O(1), n is array length
	public static int removeDup(int[] a) {
		if (a.length == 0)
			return 0;
	    int i = 0;
	    for (int x : a) {
	        if (i == 0 || x > a[i-1])
	            a[i++] = x;
	    }
	    return i;
	}

    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 6, 6, 10};
        System.out.print("Input: ");
        Array.print(arr);
        int k = removeDup(arr);
        System.out.println("Length: " + k);
        System.out.print("After remove duplicats: ");
        Array.print(arr, k);
    }
}
