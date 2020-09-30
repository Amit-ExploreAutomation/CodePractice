package com.exploreAutomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {

  public static List<Integer> getNGLBF(int[] arr){

    List<Integer> list = new ArrayList<>();

    for(int i =0; i < arr.length;i++){
      int greater=-1;
      for(int j=i-1 ; j >= 0;j--){
        if(arr[j] > arr[i]){
          greater=arr[j];
          break;
        }
      }
        list.add(greater);
    }
    return list;
  }

  public static List<Integer> getNGLStack(int[] arr){

    List<Integer>  list = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for(int i=0;i<arr.length;i++){

      if(stack.size()==0){
        list.add(-1);
      }else if(stack.size()>0 && stack.peek()>arr[i]){
        list.add(stack.peek());
      }else if(stack.size()>0 && stack.peek()<=arr[i]){
        while(stack.size()>0 && stack.peek()<=arr[i]){
          stack.pop();
        }
        if(stack.size()==0){
          list.add(-1);
        }else{
          list.add(stack.peek());
        }
      }
      stack.push(arr[i]);
    }
    return list;
  }



  public static void main(String[] args){

    int[] input = {1,3,2,4}; //o/p - -1,-1,3,-1
    System.out.println(getNGLBF(input).toString());
    System.out.println(getNGLStack(input).toString());

  }

}
