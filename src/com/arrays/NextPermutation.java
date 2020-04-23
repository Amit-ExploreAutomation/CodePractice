package com.arrays;
/*
(Facebook) Given list of numbers, rearrange numbers into the lexicographically next greater permutation of numbers.
The replacement must be in-place, do not allocate extra memory.
Example:
1,2,3 -> 1,3,2
*/

public class NextPermutation {

    //Call reverse and swap, In place, Time O(n), Space O(1), n is array length
	public static void nextPermutation(int[] a) {
	    if (a == null || a.length <= 1) return;
	    int n = a.length, i = n - 2;
	    while (i >= 0 && a[i] >= a[i+1])
	    	i--;
	    if (i >= 0) {
	        int j = n - 1;
	        while (j >= 0 && a[j] <= a[i])
	        	j--;
	        Array.swap(a, i, j);
	    }
	    ReverseArray.reverse(a, i+1, n-1);
	}

    public static void main(String args[]) {
    	int[] arr = {1, 2, 3};
        System.out.print("Input: ");
        Array.print(arr);
        nextPermutation(arr);
        System.out.print("Next permutation: ");
        Array.print(arr);
    }
}
