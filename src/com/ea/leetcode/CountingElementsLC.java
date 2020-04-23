
/*
Given an integer array arr, count element x such that x + 1 is also in arr.
If there're duplicates in arr, count them seperately.

Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.

Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
*/



package com.ea.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountingElementsLC {

  public static int countElementsBruteForce(int[] arr) {

    int count =0;

    for(int i=0;i<arr.length;i++){
      int curNum = arr[i];
      int curNumPlusOne = curNum+1;
      boolean found = false;

      for(int j=0;j<i;j++){
        if(curNumPlusOne == arr[j]){
          found = true;
        }
      }

      for(int k=i+1;k < arr.length;k++){
        if(curNumPlusOne == arr[k]){
          found = true;
        }
      }

      if(found){
        count=count+1;
      }

    }
    return count;
  }

  public static int countElementsTwo(int[] arr) {

    Set<Integer> set = new HashSet<>();

    for(int i : arr){
      set.add(i);
    }
    int count =0;

    for(int i=0; i<arr.length;i++){
        if(set.contains(arr[i]+1))
          count++;
      }
    return count;
  }

  public static void main(String[] args){
    int[] input1 = new int[]{1,2,3};
    int[] input2 = new int[]{1,3,2,3,5,0};
    int[] input3 = new int[]{1,1,2,2};

    System.out.println(countElementsTwo(input2));
    System.out.println(countElementsBruteForce(input3));
  }

}
