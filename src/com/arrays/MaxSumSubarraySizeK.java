package com.arrays;
/*
(Facebook) Given an array with negative integers, find the maximum sum of subarray of size K in the array.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4], k=3
the contiguous subarray [4,-1,2] has the largest sum = 5.
*/

public class MaxSumSubarraySizeK {

	//Sliding window, Time O(n), Space O(1), n is array length
	public static int maxSumSizeK(int[] a, int k) {
		if (k >= a.length)
			return 0;
		int sum = a[0];
		for (int i = 1; i < k; i++)
			sum += a[i];
		int maxSum = sum;
		for (int i = k; i < a.length; i++) {
			sum = sum - a[i-k] + a[i];
			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int k = 3;
        System.out.print("Input: ");
        Array.print(arr);
        System.out.println("Size: " + k);
		System.out.println("Max sum of subarray with size " + k + ": " + maxSumSizeK(arr, k));
	}
}
