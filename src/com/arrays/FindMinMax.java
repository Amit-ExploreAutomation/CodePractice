package com.arrays;
/*
Find the largest and smallest element in one pass
Example
Input: [3, 5, 7, 11, 1, 9]
Output: min 1, max 11
*/

public class FindMinMax {

	//One pass, Time O(n), Space O(1), n is array length
	public static void findMinMax(int[] a) {
		int min = a[0];
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
			else if (a[i] > max)
				max = a[i];
		}
		System.out.println("Min: " + min + ", max: " + max);
	}

	public static void main(String[] args) {
        int[] arr = {3, 5, 7, 11, 1, 9};
        System.out.print("Input: ");
        Array.print(arr);
        findMinMax(arr);
	}
}
