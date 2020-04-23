package com.exploreAutomation;

public class PrimeNumber {

  static void getPrimes(int y){

    int counter = 1;
    int inputNo = 2;
    while(counter < y){
      if(isPrime(inputNo)){
        System.out.println(inputNo);
        counter++;
        inputNo++;
      }else {
        inputNo++;
      }
    }
  }

 static boolean  isPrime(int x){

   if(x<2)
   return false;

   for(int i=2;i<x;i++){
     if(x%i==0)
       return false;
   }
    return true;
  }

  public static void main(String[] args){

   // System.out.println(isPrime(5));
    getPrimes(10);

  }

}
