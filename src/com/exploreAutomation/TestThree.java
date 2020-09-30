package com.exploreAutomation;

public class TestThree {

  public static int calculate(int n){
    if(n==1){
      return 0;
    }else{
      return (1+calculate(n/2));
    }
  }

  public static void main(String[] args){
    int x = calculate(16);
    System.out.println("x is: " + x);
  }

}
