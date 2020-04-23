package com.arrays;
/*
(Google) Find all pairs of integers within an array which sum to a specified value.
For example: Given array [1, 2, 3, 4, 5] Sum : 6
Output: pair of numbers from an array whose sum equals 6 are (2,4)(1,5)
*/
import java.util.*;

public class TwoSum {

	//Solution 1, Use HashSet, Time O(n), Space O(n), n is array length
	public static List<List<Integer>> twoSum(int[] a, int target) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> res = new ArrayList<>();
		for (int x : a) {
			int num = target - x;
			if (set.contains(num))
				res.add(Arrays.asList(x, num));
			set.add(x);
		}
		return res;
	}

	//Solution 2, Sort first, Time O(n*logn), Space O(1), no extra space needed except for result
	public static List<List<Integer>> twoSumSort(int[] a, int target) {
	    Arrays.sort(a);
	    int low = 0;
	    int high = a.length - 1;
	    List<List<Integer>> res = new ArrayList<>();
	    while (low < high) {
	        int sum = a[low] + a[high];
	        if (sum == target)
	            res.add(Arrays.asList(a[low++], a[high--]));
	        else if (sum < target)
	        	low++;
	        else
	        	high--;
	    }
	  	return res;
	}

    public static void main(String[] args) {
    	int[] arr = {1, 2, 3, 4, 5};
    	int sum = 6;
    	System.out.print("Input: ");
    	Array.print(arr);
        System.out.println("Sum: " + sum);
	    System.out.println("Two sum (set): " + twoSum(arr, sum));
        System.out.println("Two sum (sort): " + twoSumSort(arr, sum));
    }
}
