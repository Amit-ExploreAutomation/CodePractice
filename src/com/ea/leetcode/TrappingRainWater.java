package com.ea.leetcode;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

/*
  Approach :
  1. We will take an array (left) which will store the height of tallest bar at the left of ith bar
  2. We will also take an array (right) which will store the height of tallest bar at the right of ith bar

  After filling the values in left and right array, we are ready to calculate the water above the ith bar

  3. First we will calculate the, minimum value between left and right values for ith bar
      minHeight = Math.min(left[i], right[i])

      Example : Input Array =  [3,0,0,2,0,4]
                Left max    =  [0,3,3,3,3,3]
                Right max   =  [4,4,4,4,4,0]
                Min Height  =  [0,3,3,3,3,0]
                Water       =  [0,3,3,1,3,0]
 */
public class TrappingRainWater {

  public static void main(String[] args){
    int[] arr = {3,0,0,2,0,4};
    System.out.println(waterArea(arr));
  }

  public static int waterArea(int[] arr){
    if(arr.length == 0){
      return 0;
    }

    // left[i]  -- store the height of tallest bar at the left of ith bar
    int[] left = new int[arr.length];

    // right[i]  -- store the height of tallest bar at the left of ith bar
    int[] right = new int[arr.length];


    //Fill Right array
    left[0] = 0;
    int leftMax = arr[0];
    for(int i = 1; i < arr.length; i++){
      left[i] = leftMax;
      leftMax = Math.max(leftMax,arr[i]);
    }

    //Fill right array
    right[arr.length-1] = 0;
    int rightMax = arr[arr.length-1];
    for(int i = arr.length -2; i >=0 ; i--){
      right[i] = rightMax;
      rightMax = Math.max(rightMax,right[i]);
    }

    int minHeight = 0;
    int water = 0;
    int totalWater = 0;

    for(int i = 0; i < arr.length; i++){
      minHeight = Math.min(left[i],right[i]);
      if(minHeight > arr[i]){
        water = minHeight - arr[i];
      }else{
        water = 0;
      }
      totalWater = totalWater + water;
    }
    return totalWater;
  }
}

// Time Complexity = O(n) {3 for loops , O(n), O(n) , O(n)}
// Space Complexity = O(n) {2 arrays (left and right) each od size n}
