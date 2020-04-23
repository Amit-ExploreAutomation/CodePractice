/*

Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/


package com.ea.leetcode;

import java.util.HashSet;
import java.util.Set;


/*

n%10 means modulus of 10, that is the remainder you get when you divide with 10. Here it is used to get each of the last digit.
Let's say your number is 12345 -- 12345 % 10 means remainder when 12345 is divided by 10, which gives you 5.
Thereafter when you perform (n/10) you get 1234 (all the numbers except the least significant digit that you got in previous step).

Example:

Say your number is n = 752.

n%10 = 2, n/10 = 75

Now, n%10 = 75%10 = 5. This is the digit to be added and so on, till your n >= 10.
When it is < 10, you have a single digit that you just need to return as it is, as that is only the sum of digits in that single-digit number n.

// Find the first digit
  public static int firstDigit(int n)
    {
        // Remove last digit from number
        // till only one digit is left
        while (n >= 10)
            n /= 10;

        // return the first digit
        return n;
    }
*/

public class HappyNumberLC {

  public static boolean isHappy(int n){

    Set<Integer> set = new HashSet<>();

    while(n != 1){
      if(set.contains(n)){
        return false;
      }
      set.add(n);
      n = sum(n);
    }
    return true;
  }

  public static int sum(int n){

    int sum = 0;
    while(n > 0){
      sum = sum + (n%10)*(n%10);
      n=n/10;
    }
    return sum;
  }


  public static void main(String[] args){

    int n1 = 2;

    System.out.println(isHappy(n1));

  }

}
