package com.exploreAutomation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

  public static int getkth(int[] arr, int k){
    /*Arrays.sort(arr);
    return arr[k-1];*/

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for(int e : arr){
      pq.add(e);
      if(pq.size()>3){
        pq.poll();
      }
    }
    return pq.poll();
  }


  public static void main(String[] args){

    int[] arr = new int[]{7,10,4,3,20,15};
    int k = 3;
    System.out.println(getkth(arr, k));
  }

}
