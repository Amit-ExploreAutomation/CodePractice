package com.Starbucks;

/*
  As an example, consider the arrays a = [1,2,3] and b=[2,5,5]. Merge the arrays to create array c as follows:
  c = [1,2,2,3,5,5]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoArrays {

  public static List<Integer> mergeList(List<Integer> a , List<Integer> b){

    List<Integer> c = new ArrayList<>();

    int lenA = a.size();
    int lenB = a.size();

    int i = 0;
    int j = 0;

    while(i < lenA && j < lenB){
      if(a.get(i) < b.get(j)){
        c.add(a.get(i));
        i++;
      }else if(a.get(i) > b.get(j) ){
        c.add(b.get(j));
        j++;
      }else{
        c.add(a.get(i));
        c.add(b.get(j));
        i++;
        j++;
      }
    }

    while (i < lenA) {
      c.add(a.get(i));
      i++;
    }

    while (j < lenB){
      c.add(b.get(j));
      j++;
    }

    return c;
  }

  public static void main(String[] args){



    System.out.println(mergeList(Arrays.asList(123), Arrays.asList(255)));

  }
}
