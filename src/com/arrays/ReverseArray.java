package com.arrays;
/*
Reverse the array.
Example:
input: [1,2,3,4], return: [4,3,2,1]
*/

public class ReverseArray {

	//Solution 1, Iteration, Reverse in place, Time O(n), Space O(1), n is array length
	public static void reverse(int[] a, int low, int high) {
		while (low < high) {
	        int tmp = a[low];
	        a[low] = a[high];
	        a[high] = tmp;
	        low++;
	        high--;
	    }
	}

	//Solution 2, Recursion, Time O(n), Space O(n)
	public static void reverseRec(int[] a, int low, int high) {
	    if (low >= high)
	        return;
	    int tmp = a[low];
	    a[low] = a[high];
	    a[high] = tmp;
	    reverseRec(a, low+1, high-1);
	}

	public static void main(String[] args) {
		//Solution 1, Iteration
		int[] arr = {1, 2, 3, 4, 5, 6};
		System.out.print("Input: ");
		Array.print(arr);
		reverse(arr, 0, arr.length-1);
		System.out.print("After reverse (ite): ");
		Array.print(arr, arr.length);
		System.out.println();

		//Solution 2, Recursion
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		System.out.print("Input: ");
		Array.print(arr1);
		reverseRec(arr1, 0, arr1.length-1);
		System.out.print("After reverse (rec): ");
		Array.print(arr1, arr1.length);
	}
}
