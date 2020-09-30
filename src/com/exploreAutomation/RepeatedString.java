package com.exploreAutomation;


/*For example, if the string  and , the substring we consider is , the first  characters of her infinite string.
There are  occurrences of a in the substring.
 */
public class RepeatedString {

  public static void main(String [] args){
    String s = "abc";
    long n = 10;
    String newString = "";

    if(s.length() < n){
      while (newString.length() < n){
        for(char c : s.toCharArray()) {
          if (newString.length() < n) {
            newString = newString + Character.toString(c);
          }
        }
      }
    }

    System.out.println(newString);
  }

}
