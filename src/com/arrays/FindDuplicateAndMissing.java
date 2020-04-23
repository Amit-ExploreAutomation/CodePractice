package com.arrays;
/*
(Amazon) In an unsorted array of first N natural numbers(1~N), the array contains a number which is duplicated
and one is missing. Find both numbers. Could you do it without extra space and in O(n) runtime?
Example:
Input: [8,2,3,4,6,7,2,1]
Output: duplicate 2, missing 5
*/

public class FindDuplicateAndMissing {

	//Two passes, Time O(n), Space O(1), n is array length
	public static void findDupAndMiss(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int idx = Math.abs(a[i]) - 1; //use element as index
			if (a[idx] > 0)
				a[idx] = -a[idx];
			else
				System.out.print("Duplicate: " + Math.abs(a[i]));
		}
		for (int i = 0; i < n; i++) {
			if (a[i] > 0)
				System.out.println(", missing: " + (i+1));
		}
	}

	public static void main(String[] args) {
		int arr[] = {8, 2, 3, 4, 6, 7, 2, 1};
		System.out.print("Input: ");
		Array.print(arr);
	    findDupAndMiss(arr);
    }
}
