package com.arrays;
/*
(Google) Given an array of numbers, replace each number with the product of all the numbers
in the array except the number itself without using division and in O(n).
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
*/

public class SelfExcludeProduct {

	//Two passes, Time O(n), Space O(1), n is array length, no extra space except for result
	public static int[] selfExclProd(int[] a) {
		int n = a.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i-1] * a[i-1];
		}
		int prod = 1;
		for (int i = n-1; i >= 0; i--) {
			res[i] = res[i] * prod;
			prod *= a[i];
		}
		return res;
	}

	public static void main(String args[]) {
        int[] arr = {3, 1, 4, 2};
        System.out.print("Input: ");
        Array.print(arr);
        System.out.print("The self exclude prodution array: ");
        int[] b = selfExclProd(arr);
        Array.print(b);

    }
}
