package com.arrays;
/*
(Facebook) Given array, find all possible subarrays of elements which add up to a given integer K.
Examples:
Input: [1,3,2,-1]  k=4;
Return [[1, 3], [3, 2, -1]]
*/
import java.util.*;

public class SubarraySumToK {

	//Solution 1, Use map to save partial results, Time O(n+k) ~ O(n), Space O(m+k) ~ O(n),
	//n is array length, k is subarray length, m is map size
	public static List<List<Integer>> subarraySumToKMap(int[] a, int k) {
		int n = a.length;
	    int sum = 0, start = 0, end = -1;
	    List<List<Integer>> res = new ArrayList<>();
	    HashMap<Integer, Integer> map = new HashMap<>();  //stores (partial sum, index) pair
	    for (int i = 0; i < n; i++) {
	        sum = sum + a[i];
	        if (sum == k) {
	            start = 0;
	            end = i;
	            res.add(formList(a, start, end));
	        }
	        if (map.containsKey(sum-k)) {
	            start = map.get(sum-k) + 1;
	            end = i;
	            res.add(formList(a, start, end));
	        }
	        map.put(sum, i);
	    }
	    return res;
	}

	//Form list by indices, Time O(k), Space O(k),  k is return subarray length
	private static List<Integer> formList(int[] a, int start, int end) {
	    List<Integer> list = new ArrayList<>();
	    for (int k = start; k <= end; k++)
	    	list.add(a[k]);
	    return list;
	}

	//Solution 2, No extra space, Time O(n^2), Space O(1), no extra space needed except for result
	public static List<List<Integer>> subarraySumToK(int[] a, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < a.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				list.add(a[j]);
				if (sum == target) {
					res.add(list);
					break;
				}
			}
		}
		return res;
	}

    public static void main(String args[]) {
    	//Test case 1, given sum
    	int[] arr = {6, 3, 9, 11, 1, 3, 5, 10};
    	int sum = 15;
    	System.out.print("Input: ");
    	Array.print(arr);
    	System.out.println("Sum: " + sum);
    	System.out.println("Subarray sum to " + sum + " (map): " + subarraySumToKMap(arr, sum));
    	System.out.println("Subarray sum to " + sum + " (no extra space): " + subarraySumToK (arr, sum));
    	System.out.println();

        //Test case2, sum to 0
        int[] arr1 = {4, 2, -3, 1, 6};
        sum = 0;
    	System.out.print("Input: ");
    	Array.print(arr1);
        System.out.println("Sum: " + sum);
    	System.out.println("Subarray sum to 0 (map): " + subarraySumToKMap(arr1, sum));
    	System.out.println("Subarray sum to 0 (no extra space): " + subarraySumToK(arr1, sum));
    }
}
