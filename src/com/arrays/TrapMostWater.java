package com.arrays;
/*
(Apple) Given an array which represents columns, find the position of two columns which when removed will
trap the maximum amount of water.
Input: [1,4,3,2]
Output: 4
  |
  |  |
  |x |x |
| |x |x |
*/

public class TrapMostWater {

	//Two pointers, Time O(n), Space O(1), n is array length
	public static int maxWater(int[] a) {
		int maxArea = 0, low = 0, high = a.length - 1;
		int start = 0, end = 0;
		while (low < high) {
			if (Math.min(a[low], a[high]) * (high-low) > maxArea) {
				maxArea =  Math.min(a[low], a[high]) * (high-low);
				start = low;
				end = high;
			}
			if (a[low] < a[high])
				low++;
			else
				high--;
		}
		System.out.println("Start column: " + start + ", end column: " + end);
		return maxArea;
	}

	public static void main(String args[]) {
		int[] arr = {1, 4, 3 ,2};
    	System.out.print("Input: ");
    	Array.print(arr);
        System.out.println("Trap max water: " + maxWater(arr));
	}
}
