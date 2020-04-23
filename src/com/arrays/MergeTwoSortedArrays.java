package com.arrays;
/*
(Linkedin) Merge two sorted array into one sorted array. How to improve?
Example:
Input:  nums1 = [1,2,3], nums2 = [2,5,6],
Output: [1,2,2,3,5,6]
*/

public class MergeTwoSortedArrays {

	//Solution 1, Return new array, Time O(m+n), Space O(m+n),
	//m and n are the lengths of two arrays
	public static int[] mergeSortedArray(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				res[k++] = a[i++];
			else
				res[k++] = b[j++];
		}
		while (i < a.length)
			res[k++] = a[i++];
		while (j < b.length)
			res[k++] = b[j++];
		return res;
	}

	//Solution 2, Merge in place, Time O(m+n), Space O(1)
	public static void mergeInPlace(int[] a, int[] b, int m, int n) {
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (j >= 0 && i >= 0) {
			if (a[i] > b[j])
				a[k--] = a[i--];
			else
				a[k--] = b[j--];
		}
	}

	public static void main(String[] args) {
		//Solution 1, Return new array
		int[] a = {0, 4, 5, 19, 21, 33, 36, 38, 61};
    	System.out.print("Array 1: ");
    	Array.print(a);
		int[] b = {1, 2, 7, 30, 40};
    	System.out.print("Array 2: ");
    	Array.print(b);
		int[] res = mergeSortedArray(a, b);
		System.out.print("Merge (new array): ");
		Array.print(res);
		System.out.println();

		//Solution 2, Merge in place
		int[] a1 = {0, 4, 5, 19, 21, 33, 36, 38, 61, 0, 0, 0, 0, 0};
		int m = 9;
    	System.out.print("Array 1: ");
    	Array.print(a1);
		int[] b1 = {1, 2, 7, 30, 40};
    	int n = 5;
    	System.out.print("Array 2: ");
    	Array.print(b1);
		mergeInPlace(a1, b1, m, n);
		System.out.print("Merge (in place): ");
		Array.print(a1);
	}
}
