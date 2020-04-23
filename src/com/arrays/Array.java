package com.arrays;

public class Array<T> {

    private T[] array;
    private int maxSize ;
    private int length = 0;

    //Constructor, Time O(1), Space O(1)
    @SuppressWarnings("unchecked")
    public Array(int size) {
    	maxSize = size;
    	array = (T[]) new Object[maxSize];
    }

    //Add one element, Time O(1), Space O(1)
    public void insert(T value) {
        array[length] = value;
        length++;
    }

    //Delete by key, Time O(n), Space O(1), n is array length
    public void delete(T key) {
        int i, j;
        for (i = 0; i < length; i++) {
            if (array[i] == key)
            	break;
        }
        for (j = i; j < length; j++)
            array[j] = array[j+1];
        length--;
    }

    //Search by key, Time O(n), Space O(1)
    public int search(T key) {
        int i;
        for (i = 0; i < length; i++) {
            if (array[i] == key)
            	break;
        }
        if (i == length)
            return -1;
        else
            return i;
    }

    //Print array, Time O(n), Space O(1)
	public void print() {
		System.out.print("The array: ");
	    for (int i = 0; i < length; i++)
	        System.out.print(array[i] + " ");
	    System.out.println();
	}

	//Return length of array, Time O(1), Space O(1)
    public int size() {
    	return length;
    }

	//Print array, O(n) O(1)
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    //Print array by length, Time O(k), Space O(1), k is the input length
    public static void print(int[] a, int k) {
        for (int i = 0; i < k; i++)
            System.out.print(a[i] + " ");
        System.out.println("");
    }

	//Swap two elements by index, Time O(1), Space O(1)
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		//Initialize, insert, print and size
		Array<Integer> arr = new Array<>(10);
		arr.insert(3);
		arr.insert(5);
		arr.insert(7);
		arr.insert(1);
		arr.insert(9);
		arr.print();
		System.out.println("The length: " + arr.size());

		//Search and delete
		int key = 7;
		int pos = arr.search(key);
		System.out.println("The index of " + key + ": " + pos);
		key = 5;
		arr.delete (key);
		System.out.print("After delete " + key + ", ");
		arr.print();
		System.out.println("The new length: " + arr.size());
		key = 7;
		pos = arr.search(key);
		System.out.println("The index of " + key + ": " + pos);
	}
}
