package com.exploreAutomation;

public class MergeSortedArray {

  public static void mergeArrays(int[] nums1, int m, int[] nums2, int n){

    int i=0;
    int j=0;


    while(i < m-1){
      if(nums1[i] <= nums2[j]){
        nums1[i] = nums1[i];
        i++;
      }else{
        nums1[i] = nums2[j];
        i++;
        j++;
      }
    }
  }

  public static void main(String[] args){
    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    int m = nums1.length;
    int n = nums2.length;
    mergeArrays(nums1, m, nums2, n);
  }


}
