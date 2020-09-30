package com.exploreAutomation;

public class FibonacciSeriesRecursion {

  public static int fibonacciRecursion(int n){
    if(n <= 1)
      return n;
    return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
  }

  public static void main(String[] args) {
    int maxNumber = 10;
    System.out.print("Fibonacci Series of "+maxNumber+" numbers using Recursion: ");
    for(int i = 0; i < maxNumber; i++){
      System.out.print(fibonacciRecursion(i) +" ");
    }
  }

}
