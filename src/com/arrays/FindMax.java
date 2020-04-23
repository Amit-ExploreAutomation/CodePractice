package com.arrays;
/*
Find the largest and smallest element in array
Example:
Input: [3, 5, 30, 7, 1, 9]
Output: max 30, min 1
*/

public class FindMax {

	//Get maximum, Time O(n), Space O(1), n is array length
	public static int getMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	//Get minimum, Time O(n), Space O(1)
	public static int getMin(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}

	public static void main(String[] args) {
        int[] arr = {3, 5, 30, 7, 1, 9};
        System.out.print("Input: ");
        Array.print(arr);
        System.out.print("Max: " + getMax(arr));
        System.out.println(", min: " + getMin(arr));
	}
}
