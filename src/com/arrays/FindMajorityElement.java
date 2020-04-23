package com.arrays;
/*
(Google) Given an array of size n, find the majority element.
The majority element is the element that appears more than n/2 times.
Example:
Input: [1, 2, 3, 4, 4, 4, 4]
Output: 4
*/

public class FindMajorityElement {

	//Wrapper func calls two methods, Time O(n), Space O(1)
	public static int MajorityElement(int[] a) {
        int major = findMajority(a);
        if (checkMajority(a, major))
            return major;
        else
            return -1;
    }

	//Find majority, Boyer Moore's voting algorithm, Time O(n), Space O(1), n is array length
	private static int findMajority(int[] a) {
		int major = a[0], count = 1;
		for (int i = 1; i < a.length; i++) {
	        if (count == 0) {
	            count++;
	            major = a[i];
	        } else if (major == a[i])
	            count++;
	        else
	        	count--;
	    }
	    return major;
	}

	//Check whether it appears more than n/2, Time O(n), Space O(1)
	private static boolean checkMajority(int a[],  int major) {
		int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)  {
            if (a[i] == major)
                count++;
        }
        return (count > n/2)? true : false;
    }


    public static void main (String[] args){
    	//Test case 1, Find majority element
        int arr[] = {4, 1, 4, 2, 4, 3, 4, 4};
        System.out.print("Input: ");
        Array.print(arr);
        int b = MajorityElement(arr);
        if (b != -1)
        	System.out.println("Find majority element: " + b);
        else
        	System.out.println("Cannot find majority element.");
        System.out.println();

        //Test case 2, There is no majority element
        int arr1[] = {1, 3, 3, 1, 2};
        System.out.print("Input: ");
        Array.print(arr1);
        int b1 = MajorityElement(arr1);
        if (b1 != -1)
        	System.out.println("Find majority element: " + b1);
        else
        	System.out.println("Cannot find majority element.");
    }
}
