package com.exploreAutomation;

import java.util.Arrays;

public class ReverseString {

  public static void main(String[] args){
    String s = "abcd";
    System.out.println(revString(s));
    System.out.println(revStringOne(s));
  }

  public static String revString(String s){

    char[] cArr = s.toCharArray();

    int start = 0;
    int end = cArr.length-1;

    while(start <= end){
      char temp = cArr[start];
      cArr[start] = cArr[end];
      cArr[end] = temp;
      start++;
      end--;
    }
    return new String(cArr);
    //return Arrays.toString(cArr);
  }



public static String revStringOne(String s){

String revStr = "";

for (int i=s.length()-1;i>=0;i--){
  revStr = revStr + s.charAt(i);
}


return revStr;
  }

}
