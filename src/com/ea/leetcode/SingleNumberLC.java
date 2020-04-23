/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Example 1:
Input: [2, 2, 1]
Output: 1

Example 2:
Input: [4, 1, 2, 1, 2]
Output: 4
*/

package com.ea.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberLC {

  public static int singleNumberBruteForce(int[] nums) {

    for(int i=0;i<nums.length;i++) {
      boolean found = false;
      int curNum = nums[i];

      for (int j = 0; j < i; j++) {
        if (curNum == nums[j]) {
          found = true;
        }
      }
      for (int k = i + 1; k < nums.length; k++) {
        if (curNum == nums[k]) {
          found = true;
        }
      }
      if (!found) {
        return nums[i];
      }
    }
    return 0;
  }

  public static int singleNumberHashMap(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int num=0;
    for (int i=0; i< nums.length; i++){
      if(map.containsKey(nums[i])){
        map.put(nums[i],map.get(nums[i])+1);
      }else{
        map.put(nums[i],1);
      }
    }

    for (Map.Entry<Integer,Integer> entry: map.entrySet()){
      if(entry.getValue() == 1){
        num=entry.getKey();
      }
    }
    return num;
  }

  public static int singleNumberTwo(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int num=0;
    for (int i=0; i< nums.length; i++){
      if(map.containsKey(nums[i])){
        map.put(nums[i],map.get(nums[i])+1);
      }else{
        map.put(nums[i],1);
      }
    }

    for (int i: nums){
      if(map.get(i) == 1){
        return i;
      }
    }
    return 0;
  }

  public static int singleNumberXOR(int[] nums) {
    int num=0;

    for (int i: nums){
      num = num^i;
    }
    return num;
  }


  public static void main(String[] args){

    int[] array1 = new int[]{2,2,1};
    int[] array2 = new int[]{4,1,2,1,2};
    int[] array3 = new int[]{4,1,2,1,2,4,6};

    System.out.println(singleNumberHashMap(array1));
    System.out.println(singleNumberTwo(array2));
    System.out.println(singleNumberXOR(array3));
    System.out.println(singleNumberBruteForce(array3));
  }

}
