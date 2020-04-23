package com.arrays;
/*
(Amazon) Rotate a array close wise by N. N can be smaller or greater than the array length. e.g {0,1,2,4,5,6,7}
N=4 should return {4,5,6,7,0,1,2}.
*/

public class RotateArray {

	//Solution 1, Rotate in place, Call reverse, Time O(n), Space O(1), n is array length
	public static void rotate(int[] a, int k) {
		int n = a.length;
	    k %= n;
	    ReverseArray.reverse(a, 0, n-1);
	    ReverseArray.reverse(a, 0, k-1);
	    ReverseArray.reverse(a, k, n-1);
	}

	//Solution 2, Cyclic replacement, Time O(n), Space O(1)
	public static void rotateCyclic(int[] a, int k) {
		int n = a.length;
	    k %= n;
	    for (int i = 0, count = 0; count < n; i++) {
	        int curr = i;
	        int prev = a[i];
	        do {
	            int next = (curr+k) % n;
	            int tmp = a[next];
	            a[next] = prev;
	            prev = tmp;
	            curr = next;
	            count++;
	        } while (i != curr);
	    }
	}

    public static void main(String args[]) {
    	//Solution 1, Rotate in place
        int[] arr = {0, 1, 2, 4, 5, 6, 7};
        int k = 4;
        System.out.print("Input: ");
        Array.print(arr);
        rotate(arr, k);
        System.out.print("After rotate right by " + k + " (call reverse): ");
        for (int i = 0; i < arr.length; i++)
        	System.out.print(arr[i] + " ");
        System.out.println("\n");

        //Solution 2, Use extra space
    	int[] arr1 = {0, 1, 2, 4, 5, 6, 7};
        System.out.print("Input: ");
        Array.print(arr1);
        rotateCyclic(arr1, k);
        System.out.print("After rotate right by " + k + " (cyclic replace): ");
        for (int i = 0; i < arr1.length; i++)
        	System.out.print(arr1[i] + " ");
        System.out.println();
    }
}
