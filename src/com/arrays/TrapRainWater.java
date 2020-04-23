package com.arrays;
/*
(Goldman Sachs) Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
Example:
Given [3, 0, 2, 4], return 4.
   |
|xx|
|x||
|x||
*/

public class TrapRainWater {

	//Two pointers, Time O(n), Space O(1), n is array length
	public static int totalWater(int[] a) {
		if (a.length == 0)
			return 0;
	    int low = 0, high = a.length - 1;
	    int maxL = 0, maxR = 0, total = 0;
	    while (low <= high) {
	        maxL = Math.max(maxL, a[low]);
	        maxR = Math.max(maxR, a[high]);
	        if (maxL < maxR) {
	            total += maxL - a[low];
	            low++;
	        } else {
	            total += maxR - a[high];
	            high--;
	        }
	    }
	    return total;
	}

    public static void main(String[] args) {
    	int[] hist = {3, 0, 2, 4};
    	System.out.print("Input: ");
    	Array.print(hist);
        System.out.println("Trap total water: " + totalWater(hist));
    }
}
