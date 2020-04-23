package com.arrays;
/*
Find the largest and second largest elements in one pass
Example:
Input: [3, 11, 5, 7, 1, 9]
Output: first 11, second 9
*/

public class FindTopTwo {

	//One pass, Time O(n), Space O(1), n is array length
	public static void findTopTwo(int[] a) {
		int first = a[0];
		int second = a[0];
	    for (int i = 1; i < a.length; i++) {
	        if (a[i] > first) {
	            second = first;
	            first = a[i];
	        } else if (a[i] > second)
	            second = a[i];
	    }
	    System.out.println("First: " + first + ", second: " + second);
	}

    public static void main(String[] args) {
        int[] arr = {3, 11, 5, 7, 1, 9};
        System.out.print("Input: ");
        Array.print(arr);
        findTopTwo(arr);
    }
}
