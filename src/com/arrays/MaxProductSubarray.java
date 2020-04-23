package com.arrays;
/*
(Microsoft) Find max product of continuous subarray with negative and positive integers.
For example, given the array [1, -2, -3, 0],
the contiguous subarray [-2,-3] has the largest product = 6.
*/

public class MaxProductSubarray {

	//Two passes, Time O(n), Space O(1), n is array length
	public static int maxProduct(int[] a) {
		int n = a.length;
		int max = Integer.MIN_VALUE, prod = 1;
		for (int i = 0; i < n; i++) {
			prod *= a[i];
			max = Math.max(prod, max);
		    if (a[i] == 0) prod = 1; //when 0, product reset to 1
		}
		prod = 1;
		for (int i = n-1; i >= 0; i--) {
			prod *= a[i];
			max = Math.max(prod, max);
		    if (a[i] == 0) prod = 1; //when 0, product reset to 1
		}
		return max;
	}

	public static void main(String args[]) {
		int[] arr = {1, -2, -3, 0, 7, -8, -2};
    	System.out.print("Input: ");
    	Array.print(arr);
        System.out.println("The max product of subarray: " + maxProduct(arr));
    }
}
