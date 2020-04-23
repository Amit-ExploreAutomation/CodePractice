package com.arrays;

public class SortedArray {

    private int[] array;
    private int maxSize;
    private int length = 0;

    //Constructor, Time O(1), Space O(1)
    public SortedArray(int size) {
    	maxSize = size;
    	array = new int[maxSize];
    }

    //Add one element, Time O(n), Space O(1), n is array length
    public void insert(int val) {
        int i;
        for (i = 0; i < length; i++) {
            if (array[i] > val)
            	break;
        }
        for (int j = length; j > i; j--)
            array[j] = array[j-1];
        array[i] = val;
        length++;
    }

    //Delete by key, Time O(n), Space O(1)
    public boolean delete(int key) {
        int i = binarySearch(key);
        if (i == length)
            return false;
        else {
            for (int j = i; j < length; j++)
                array[j] = array[j+1];
            length--;
            return true;
        }
    }

    //Binary search, Time O(logn), Space O(1)
	public int binarySearch(int key) {
		int low = 0;
		int high = length - 1;
		int mid;
		while (low <= high) {
			mid = low + (high-low)/2;
			if (array[mid] < key)
				low = mid + 1;
			else if (array[mid] > key)
				high = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	//Print array, Time O(n), Space O(1)
    public void print( ) {
    	System.out.print("The array: ");
        for (int i = 0; i < length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

	//Check sorted, Time O(n), Space O(1)
	public boolean isSorted() {
	    if (length == 0 || length == 1)
	        return true;
	    for (int i = 1; i < length; i++) {
	        if (array[i-1] > array[i])
	            return false;
	    }
	    return true;
	}

	//Return length of array, Time O(1), Space O(1)
	public int size() {
    	return length;
    }

	public static void main(String[] args) {
		//Initialize, insert, print and size
		SortedArray arr = new SortedArray(10);
        arr.insert(0);
        arr.insert(1);
        arr.insert(19);
        arr.insert(10);
        arr.insert(6);
        arr.print();
        System.out.println("The length: " + arr.size());

        //Search and delete
        System.out.println("Found 10 at position: " + arr.binarySearch( 10));
        arr.delete (10);
        System.out.print("After delete 10, ");
        arr.print();
        System.out.println("The length: " + arr.size());
        System.out.println("Is array sorted? " + arr.isSorted( ));
	}
}

