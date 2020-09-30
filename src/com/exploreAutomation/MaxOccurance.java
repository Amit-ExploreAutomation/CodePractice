package com.exploreAutomation;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurance {

  public static void main(String[] args){
    String s = "abcdababb";
    System.out.println(maxOccur(s));
  }

  public static char maxOccur(String s){

    Map<Character,Integer> map = new HashMap<>();

    char[] charArray = s.toCharArray();

    for(char c: charArray){
      if(map.containsKey(c)){
        map.put(c,map.get(c)+1);
      }else{
        map.put(c,1);
      }
    }

    char maxChar = ' ';
    int maxValue =0;

    for(Map.Entry<Character,Integer> entry : map.entrySet()){
      if(entry.getValue() > maxValue){
        maxValue=entry.getValue();
        maxChar=entry.getKey();
      }
    }
    return maxChar;
  }

}
