package com.exploreAutomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeft {


  public static List<Integer> getNSLStack(int[] arr){

    List<Integer> list = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for(int i=0; i<arr.length;i++){
      if(stack.size() == 0){
        list.add(-1);
      }else if(stack.size() > 0 && stack.peek() < arr[i]){
        list.add(stack.peek());
      }else if(stack.size() > 0 && stack.peek() >= arr[i]){
        while(stack.size() > 0 && stack.peek() >= arr[i]){
          stack.pop();
        }
        if(stack.size() == 0){
          list.add(-1);
        }else{
          list.add(stack.peek());
        }
      }
      stack.push(arr[i]);
    }
    return list;
  }

  public static List<Integer> getNSLBF(int[] arr){

    List<Integer> list = new ArrayList<>();

    for(int i=0; i<arr.length;i++){
      int leftSmaller=-1;
      for(int j=i-1;j>=0;j--){
        if(arr[j]<arr[i]){
          leftSmaller=arr[j];
          break;
        }
      }
      list.add(leftSmaller);
    }
return list;
  }

  public static void main(String[] args){
    int[] input = {4,5,2,10,8}; //  o/p - [-1,4,-1,2,2]
    System.out.println(getNSLBF(input).toString());
    System.out.println(getNSLStack(input).toString());

  }

}
