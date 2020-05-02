package com.exploreAutomation;

public class BinarySearch {

  public static void main(String[] args){

    int[] arr = {3,4,5,6,7,8,9};
    int x=8;

    int result = doBinary(arr,x,0,arr.length-1);
    System.out.println(result);
  }

  public static int doBinary(int arr[],int x, int low, int high){

    while(low <= high){

      int mid = low +(high-low)/2;

      if(arr[mid]==x)
        return mid;

      if(arr[mid] < x){
        low=mid+1;
      }else{
        high=mid-1;
      }

    }
    return -1;
  }
}
