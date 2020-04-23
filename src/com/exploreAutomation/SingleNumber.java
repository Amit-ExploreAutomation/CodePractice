package com.exploreAutomation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {



  public static void main(String[] args){

    int[] input = new int[]{4,1,2,1,2,4,6};

    System.out.println(singleNumberList(input));
    System.out.println(singleNumberHashSet(input));

  }

  public static int singleNumberList(int[] nums) {
    List<Integer> no_duplicate_list = new ArrayList<>();

    for (int i : nums) {
      if (!no_duplicate_list.contains(i)) {
        no_duplicate_list.add(i);
      } else {
        no_duplicate_list.remove(new Integer(i));
      }
    }
    return no_duplicate_list.get(0);
  }

  public static int singleNumberHashSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int num =0;
    for (int i : nums) {
      if (!set.contains(i)) {
        set.add(i);
      } else {
        set.remove(i);
      }
    }
    /*for(int stock : set){
        num= stock;
    }
    return num;*/
    return set.iterator().next();
  }

}
