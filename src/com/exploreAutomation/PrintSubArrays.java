package com.exploreAutomation;

import java.util.Arrays;

public class PrintSubArrays {


  public static void main(String[] args){

    int[] input = new int[]{4, -1, 2, 1};

      System.out.println(Arrays.toString(input));

    for (int startpoint = 0; startpoint < input.length; startpoint++){
      for (int grps = startpoint; grps <= input.length; grps++) {
        for (int j = startpoint; j < grps;j++) {
          System.out.print(input[j] + " ");
        }
        System.out.println();
      }
    }

  }

}
