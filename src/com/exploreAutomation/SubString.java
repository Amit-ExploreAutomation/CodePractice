package com.exploreAutomation;

public class SubString {

  public static boolean isSubString(String str1, String str2){

    if(str1.indexOf(str2) != -1){
      return true;
    }
    return false;
  }

  public static boolean isSubStringSecond(String str1, String str2){

    int count =0;
    for(int i = 0; i < str1.length(); i++){

      if(str1.charAt(i) == str2.charAt(count)){
        count ++;
      }else{
        count = 0;
      }

      if (count == str2.length()){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args){

    String str1="mynameisamit";
    String str2 ="name";

    //System.out.println(isSubString(str1, str2));
    System.out.println(isSubStringSecond(str1, str2));
  }

}
