package com.exploreAutomation;

public class FindMissingNumberInArray {


  public static void main(String[] args)
  {
    int n = 8;
    int[] a = {1, 4, 5, 3, 7, 8, 6};
    int sumOfNumbers = sumOfNumbers(n);
    int sumOfElements = sumOfElements(a);
    int missingNumber = sumOfNumbers - sumOfElements;
    System.out.println("Missing Number is = "+missingNumber);
  }

  private static int sumOfElements(int[] a) {
    int sum=0;
    for(int i =0; i < a.length; i++){
      sum = sum + a[i];
    }
    return sum;
  }

  private static int sumOfNumbers(int n) {
    return (n*(n+1))/2;
  }
}
