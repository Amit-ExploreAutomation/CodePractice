package com.exploreAutomation;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsInString {

  public static void main(String[] args){
    String str = "w3resource"; // O/P - w3resouc
    String targetString = "";
    Set<Character> set = new HashSet<>();
   StringBuilder sb = new StringBuilder();

    for(int i = 0; i < str.length();i++){
        if(set.add(str.charAt(i))){
          sb.append(str.charAt(i));
        }
    }
    System.out.println(sb.toString());
  }

}
