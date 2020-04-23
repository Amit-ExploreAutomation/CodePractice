package com.arrays;
/*
(Microsoft) In an array of integers from 1 to n, only one number is repeated. How can you tell what that number is?
Example:
Input: [2,4,1,3,4]
Output: 4
*/

public class FindDuplicateNumber {

	//Two pointers, Floyd's cycle detection algorithm, Time O(n), Space O(1), n is array length
	//Similar to linkedlist's loop detection
	public static int findDup(int[] a) {
		int slow = a[0];
	    int fast = a[0];
	    do {
	    	slow = a[slow]; //use element as index
	    	fast = a[a[fast]];
	    } while (slow != fast);
	    slow = a[0];
	    while (fast != slow) {
	        fast = a[fast];
	        slow = a[slow];
	    }
	    return fast;
	}

    public static void main(String[] args) {
    	int[] arr = {2, 4, 1, 3, 4};
    	System.out.print("Input: ");
    	Array.print(arr);
		System.out.println("Duplicate number: " + findDup(arr));
	}
}
