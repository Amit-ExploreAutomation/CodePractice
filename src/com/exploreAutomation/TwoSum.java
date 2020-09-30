package com.exploreAutomation;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSumForLoop(int[] arr, int complement){

    for(int i=0;i<arr.length;i++){
      for(int j= i+1; j<arr.length;j++){
        if(arr[j]==complement-arr[i]){
          System.out.println(i+" "+j);
          return new int[]{i,j};
        }
      }
    }
    throw new NullPointerException("NO complemenet");
  }

  public static int[] twoSumMap(int[] arr, int complement){

    Map<Integer, Integer> map = new HashMap<Integer,Integer>();

    for(int i=0;i<arr.length;i++){
      int sum = complement - arr[i];
      if(map.containsKey(sum)){
        System.out.println(map.get(sum) + " " + i);
        return new int[]{map.get(sum),i};
      }else{
        map.put(arr[i],i);
      }

    }
    throw new NullPointerException("NO complemenet");
  }

  public static void main(String[] args){

    int[] arr = new int[] {1,2,4,5};

    System.out.println(twoSumForLoop(arr,7));
    System.out.println(twoSumMap(arr,5));

  }

}
