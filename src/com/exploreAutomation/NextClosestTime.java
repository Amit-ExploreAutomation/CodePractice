package com.exploreAutomation;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

  public static String nextClosestTime(String str){
    int minutes = Integer.parseInt(str.substring(0,2)) * 60;
    minutes = minutes + Integer.parseInt(str.substring(3));

    Set<Integer> digits = new HashSet<>();
    for(char c : str.toCharArray()){
      if(Character.isDigit(c)){
        //Character.getNumericValue(c);
        digits.add(c - '0');
      }
    }

    while(true){
      minutes = minutes + 1;

      int[] nextTime = {minutes / 60 /10, minutes / 60 % 10, minutes % 60 / 10 , minutes % 60 % 10};

      boolean isValid = true;
      for(int digit : nextTime){
        if(!digits.contains(digit)){
          isValid = false;
        }
      }

      if(isValid){
        return String.format("%02d:%02d",minutes / 60, minutes % 60 );
      }
    }
  }

  public static void main(String[] args){
    String s = "19:34";
    System.out.println(nextClosestTime(s));

  }

}
