package com.exploreAutomation;

public class Test {

  public static void main(String[] args){
    int a = 5 , b = 10;
    String str = "abc";

    for (char c : str.toCharArray()){
      System.out.println(str.indexOf(c));
    }

    /*if (a==b) {
      System.out.println("Pass");}
    else{
      System.out.println("Fail");
    }*/
  }
}
