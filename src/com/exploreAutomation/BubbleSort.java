package com.exploreAutomation;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class BubbleSort {

 public static void bubbleSort(int[] arr){
    boolean isSorted = false;
    while (!isSorted){
      isSorted=true;
      for(int i = 0; i< arr.length-1; i++){
        if(arr[i]>arr[i+1]){
          int temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = temp;
          isSorted = false;
        }
      }
    }

    for(int i : arr){
      System.out.println(i);
    }
  }

  public static void bubbleSortwithForloop(int[] arr){

    for(int i =0; i < arr.length-1; i++){
      for(int j = 0; j < arr.length -i- 1; j++){    // here -i represents no of iterations completed and sorted as with each iteration we will have highest element at end.
        if(arr[j] > arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

    for(int i : arr){
      System.out.println(i);
    }

  }


  public static void main(String[] args){
    int[] arr = {3,7,2,1};

    System.out.println("****** Before Sorting *********");
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }

    System.out.println("****** After Sorting *********");
    bubbleSortwithForloop(arr);

    System.out.println("****** After Sorting *********");
    bubbleSort(arr);
    /*OR

    for(int i : arr){
      System.out.println(i);
    }*/

  }

}
