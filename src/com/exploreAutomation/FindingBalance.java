package com.exploreAutomation;

public class FindingBalance {

  public static void main(String[] args){
    int[] input = {1,7,3,6,5,6};
    System.out.println(findingBalance(input));

  }

  public static int findingBalance(int[] arr){

    int sumLeft = 0;
    int sumRight = 0;

    for(int i=0;i < arr.length;i++){

      for(int j=0;j<=i;j++) {
        sumLeft += arr[j];
      }

      for(int k=i+1;k<arr.length;k++){
        sumRight += arr[k];
        if(sumLeft == sumRight){
          return i+1;
        }
      }
      sumLeft = 0;
      sumRight = 0;
    }
  return -1;
  }

}
