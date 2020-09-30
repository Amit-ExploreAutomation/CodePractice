package com.exploreAutomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToRight {

  public static List<Integer> getNSRStack(int[] arr){

    List<Integer> list = new ArrayList<Integer>();
    Stack<Integer> stack = new Stack<>();

    for(int i=arr.length-1;i >= 0;i--){
      if(stack.size()==0){
        list.add(-1);
      }else if(stack.size()>0 && stack.peek()<arr[i]){
        list.add(stack.peek());
      }else if(stack.size()>0 && stack.peek()>=arr[i]){
        while(stack.size()>0 && stack.peek()>=arr[i]){
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
     Collections.reverse(list);
    return list;
  }

  public static List<Integer> getNSRBF(int[] arr){

    List<Integer> list = new ArrayList<Integer>();

    for(int i=0;i < arr.length;i++){
      int greater = -1;
      for(int j=i+1;j < arr.length;j++){
        if(arr[j] < arr[i]){
          greater=arr[j];
          break;
        }
      }
      list.add(greater);
    }
  return list;
  }

  public static void main(String[] args){
    int[] input = {4,5,2,10,8}; // O/P : 2,2,-1,8,-1
    System.out.println(getNSRBF(input).toString());
    System.out.println(getNSRStack(input).toString());
  }

}
