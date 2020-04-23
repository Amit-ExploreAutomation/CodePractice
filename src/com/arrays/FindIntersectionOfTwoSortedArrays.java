package com.arrays;
/*
(Google) Given N arrays with size of N, and they are all sorted, if it does not allow you to use extra space,
how will find their common data efficiently or with less time complexity?
Example:
Given nums1 = [4,5,9], nums2 = [4,4,8,9,9], return [4,9].
Note: Each element in the result should appear as many times as it shows in both arrays.
*/

public class FindIntersectionOfTwoSortedArrays {

	//Input arrays are sorted, Time O(m+n), Space O(1), m and n are the lengths of two arrays
	public static void findIntersection(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				System.out.print(b[j] + " ");
				i++;
				j++;
			} else if (a[i] < b[j])
				i++;
			else
				j++;
		}
		System.out.println();
	}

    public static void main(String[] args) {
    	int[] a = {4, 5, 9};
    	System.out.print("Array 1: ");
    	Array.print(a);
		int[] b = {4, 4, 8, 9, 9};
		System.out.print("Array 2: ");
		Array.print(b);
		System.out.print("Find intersection: ");
		findIntersection (a, b);
    }
}
