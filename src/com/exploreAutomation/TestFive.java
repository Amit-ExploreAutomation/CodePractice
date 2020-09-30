package com.exploreAutomation;

public class TestFive {

  static void method(){
      try{
        int values[] = {1,2,3,4,3,2,1};
        for (int i = values.length - 1; i >= 0; i++) { System.out.println(values[i] + " "); }
      }catch(Exception e){
        System.out.println("2" + " ");
      }finally{
        System.out.println("3" + " ");
      }
  }

  public static void main(String[] args){
    method();
  }

}
