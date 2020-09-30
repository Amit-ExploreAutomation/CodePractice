package com.exploreAutomation;

// input : This is sample text
// output : sihT si elpmas txet

public class ReverseWordsSentence {

  public static String doReverse(String str){

    String[] strWords = str.split(" ");
    String newString="";

    for ( String s:strWords){
      StringBuilder sb = new StringBuilder(s);
      sb.reverse();
      newString=newString+sb.toString()+" ";
    }
    return newString;
  }

/*  public static String doReverse(String str){

    String[] strWords = str.split(" ");
    String newString="";

    for ( String s:strWords){
      newString = newString + getReverse(s) + " ";
    }
    return newString;
  }*/

  /*public static String getReverse(String s){
    String revString ="";
    for(int i=s.length()-1;i>=0;i--){
      revString=revString+s.charAt(i);
    }
    return revString;
  }*/


  public static void main(String[] args){
    String str = "This is a sample text";
    System.out.println(doReverse(str));
  }

}
