package com.arrays;
/*
(Linkedin) Given an array with negative integers, find the contiguous subarray with the max sum. Print subarray and return the max sum.
For example, given the array [-3,1,2,4],
the contiguous subarray [1,2,4] has the largest sum = 7.
*/

public class MaxSumSubarray {

	//Kadane�s algorithm, DP, Time O(n), Space O(1), n is array length
	public static int maxSum(int[] a) {
		int n = a.length, start = 0, end = 0, tmp = 0;
	    int maxSum = Integer.MIN_VALUE, sum = 0;
	    for (int i = 0; i < n; i++)  {
	        sum += a[i];
	        if (maxSum < sum)  {
	            maxSum = sum;
	            start = tmp;
	            end = i;
	        }
	        if (sum < 0)  {
	            sum = 0;
	            tmp = i + 1;
	        }
	    }
	    System.out.print("The subarray is: [");
	    for (int i = start; i <= end; i++)
	    	System.out.print(a[i] + " ");
	    System.out.print("], ");
	    return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = {-2, 5, -3, 4, -1};
        System.out.print("Input: ");
        Array.print(arr);
		System.out.println("max sum: " + maxSum(arr));
	}
}
