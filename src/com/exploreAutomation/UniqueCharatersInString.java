package com.exploreAutomation;

public class UniqueCharatersInString {

  public static boolean isUnique(String str){

    boolean[] charSet = new boolean[128];
    for (int i = 0; i< str.length(); i++){

      if(charSet[str.charAt(i)]){
        return false;
      }
      charSet[str.charAt(i)] = true;
    }
    return true;
  }

  public static void main(String[] args){
    String s = "ABCD";
    System.out.println(isUnique(s));
  }

}
