package com.arrays;
/*
(Amazon) Find all triplets in array so that a+b+c = k, k is given number along with array.
For example, given array S = [2,0,4,5,1,3], k = 6
solution sets are [0, 1, 5], [0, 2, 4], [1, 2, 3]
*/
import java.util.*;

public class ThreeSum {

	//Sort first, Time O(nlogn + n^2) ~ O(n^2), Space O(1),
	//n is array length, no extra space needed except for result
	public static List<List<Integer>> threeSum(int[] a, int target) {
	    List<List<Integer>> res = new ArrayList<>();
	    Arrays.sort(a);
	    for (int i = 0; i < a.length-2; i++) {
	        if (a[i] > target)
	        	break;
	        if (i > 0 && a[i] == a[i-1]) //skip dup to reduce time
	        	continue;
	        int low = i + 1, high = a.length - 1;
	        int sum = target - a[i];
	        while (low < high) {
	            if (a[low] + a[high] == sum) {
	                res.add(Arrays.asList(a[i], a[low++], a[high--]));
	                while (low < high && a[low] == a[low-1]) //skip dup to reduce time
	                	low++;
	                while (low < high && a[high] == a[high+1]) //skip dup to reduce time
	                	high--;
	            } else if (a[low] + a[high] > sum)
	                high--;
	             else
	                low++;
	        }
	    }
	    return res;
	}

	public static void main(String args[]) {
		//Test case 1, Given sum
		int[] arr = {2, 26, 5, 6, 7, 9, 11, 1, 18, 28};
		int sum = 22;
        System.out.print("Array 1: ");
        Array.print(arr);
    	System.out.println("Sum: " + sum);
        System.out.println("Three sum to " + sum + ": " + threeSum(arr, sum));
        System.out.println();

        //Test case 2, Sum to 0
        int[] arr1 = {0, -1, 2, -3, 1};
        System.out.print("Array 2: ");
        Array.print(arr1);
    	System.out.println("Sum: 0");
        System.out.println("Three sum to 0: " + threeSum(arr1, 0));
    }
}
