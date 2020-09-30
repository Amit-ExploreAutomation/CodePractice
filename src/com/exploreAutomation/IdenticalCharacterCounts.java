package com.exploreAutomation;

public class IdenticalCharacterCounts {

  public static boolean permutation(String s, String t){

    int[] letters = new int[128];

    for (int i = 0; i< s.length();i++){
      letters[s.charAt(i)]++;
    }

    for(int i =0; i<t.length();i++){
      letters[t.charAt(i)]--;
      if(letters[t.charAt(i)] != 0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    String s1 = "abc";
    String s2 = "cab";
    System.out.println(permutation(s1,s2));
  }

}
