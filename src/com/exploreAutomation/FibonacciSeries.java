package com.exploreAutomation;

public class FibonacciSeries {

  public static void FibonacciForLoop(int maxNumber, int previousNumber, int nextNumber)
  {

    System.out.println("Fibonacci Series of "+maxNumber+" numbers using Forloop:");

    for (int i = 1; i <= maxNumber; ++i)
    {
      System.out.print(previousNumber+" ");
      int sum = previousNumber + nextNumber;
      previousNumber = nextNumber;
      nextNumber = sum;
    }
    System.out.println();
  }

  public static void FibonacciWhileLoop(int maxNumber, int previousNumber, int nextNumber)
  {

    System.out.println("Fibonacci Series of "+maxNumber+" numbers using Whileloop:");

    int i=1;
    while(i <= maxNumber)
    {
      System.out.print(previousNumber+" ");
      int sum = previousNumber + nextNumber;
      previousNumber = nextNumber;
      nextNumber = sum;
      i++;
    }
  }

  public static void main(String[] args)
  {
    int maxNumber = 10;
    int previousNumber = 0;
    int nextNumber = 1;

    FibonacciForLoop(maxNumber, previousNumber, nextNumber);
    FibonacciWhileLoop(maxNumber, previousNumber, nextNumber);
  }

}
