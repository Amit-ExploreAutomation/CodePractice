package com.exploreAutomation;

public class SelectionSort {

  public static void selectionSort(int[] arr){

    for(int i = 0; i < arr.length-1; i++){
      int min = arr[i];
      int min_loc = i;
      for(int j = i+1;j < arr.length;j++){
        if(arr[j] < min){
          min_loc = j;
          min = arr[j];
        }
      }
      int temp = arr[i];
      arr[i] = arr[min_loc];
      arr[min_loc] = temp;
    }

    for(int i : arr){
      System.out.println(i);
    }
  }

  public static void main(String[] args){
    int[] arr = {10,8,99,7,1,5,88,9};
    System.out.println("******** After Sorting ************");
    selectionSort(arr);
  }

}
