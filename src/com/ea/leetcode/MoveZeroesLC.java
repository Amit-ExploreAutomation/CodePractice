/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

package com.ea.leetcode;

import java.util.Arrays;

public class MoveZeroesLC {

  public static String moveZeroes(int[] nums) {

    int counter = 0;

    for (int i=0;i<nums.length;i++){
      if(nums[i] != 0){
        nums[counter]=nums[i];
        counter = counter +1;
      }
    }

    for (int j = counter; j < nums.length; j++){
      nums[j] = 0;
    }

    return Arrays.toString(nums);
  }


  public static void main(String[] args){

      //int[] input1 = new int[]{0,1,0,3,12};
    int[] input1 = {0,1,0,3,12};
    System.out.println(Arrays.toString(input1));
    System.out.println(moveZeroes(input1));

  }

}
