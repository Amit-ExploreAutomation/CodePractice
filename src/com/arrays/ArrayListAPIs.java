package com.arrays;

import java.util.*;
import java.util.concurrent.*;

public class ArrayListAPIs {

	public static void main(String[] args) {
		//Common methods
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(9);
		System.out.println("The array: " + arrayList);
		int size = arrayList.size();
		System.out.println("Size: " + size);
		int value = arrayList.get(1);
		System.out.println("Index 1's element: " + value);
		arrayList.set(1, 7);
		value = arrayList.get(1);
		System.out.println("After set, Index 1's element: " + value);
		boolean b = arrayList.contains(9);
		System.out.println("Contains 9: " + b);
		arrayList.remove(arrayList.indexOf(9));
		System.out.println("The array after remove 9: " + arrayList);
		System.out.println();

		//Sort
		int[] nums = {3, 5, 7, 2, 9};
		System.out.print("The array: ");
		Array.print(nums);
		Arrays.sort(nums);
		System.out.print("The array after sort: ");
		Array.print(nums);
		List<Integer> list = Arrays.asList(3, 5, 7, 2, 9);
		System.out.println("The ArrayList: " + list);
		Collections.sort(list);
		System.out.println("The ArrayList after sort: " + list);
		System.out.println();

		//Convert between array and ArrayList
		Integer[] nums1 = {3, 5, 7, 1, 9};
		List<Integer> list1 = Arrays.asList(nums1);
		System.out.println("After convert array to ArrayList: " + list1);
		List<Integer> list2 = Arrays.asList(3, 5, 7, 1, 9);
		Integer[] nums2 = list2.toArray(new Integer[0]);
		System.out.print("After convert ArrayList to array: ");
		for(int x : nums2)
			System.out.print(x + " ");
		System.out.println();

		//Iterator
		Iterator<Integer> iter = list2.iterator();
		System.out.print("Print with iterator: ");
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println("\n");

		//CopyOnWriteArrayList, Partial lock for better performance, Used for multi-threading.
		CopyOnWriteArrayList<Integer> cowArrayList = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
		cowArrayList.add(11);
		cowArrayList.add(1);
		System.out.println("CopyOnWriteArrayList: " + cowArrayList);
		cowArrayList.remove(1); //remove at index 1
		System.out.println("CopyOnWriteArrayList after remove index 1: " + cowArrayList);
	}
}
