package com.exploreAutomation;

import java.util.Scanner;

public class ArrayUserInput {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Array size: ");
    int size = sc.nextInt();

    int[] arr = new int[size];
    for(int i=0;i<arr.length;i++){
      arr[i]=sc.nextInt();
    }
    for(int i=0;i<arr.length;i++){
      System.out.println(arr[i]);
    }

  }

}
