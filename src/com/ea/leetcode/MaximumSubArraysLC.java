/*

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/


package com.ea.leetcode;

import java.util.Arrays;

public class MaximumSubArraysLC {

  public static int maxSubArrayOne(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    for (int startpoint = 0; startpoint < nums.length; startpoint++){
      for (int grps = startpoint; grps <= nums.length; grps++) {
        int curSum = 0;
        for (int j = startpoint; j < grps;j++) {
          curSum=curSum+nums[j];
        }
        if(curSum > maxSum){
          maxSum = curSum;
        }
      }
    }
    return maxSum;
  }

  public static int maxSubArrayTwo(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int curSum = 0;

    for (int i = 0; i < nums.length; i++){
      curSum = curSum+nums[i];
      maxSum = Math.max(curSum,maxSum);
      curSum = Math.max(curSum,0);
    }
    return maxSum;
  }

  public static void main(String[] args){
    int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArrayOne(input));
    System.out.println(maxSubArrayTwo(input));
  }

}
