package com.Starbucks;

/*  Given a string, return the character that appears the maximum number of times in the string. The string will contain only ASCII characters,
    from the ranges ('a'-'z','A'-'Z','0'-'9'), and case matters. If there is a tie in the maximum number of times a character appears in string,
    return the character that appears first in the string.

    For example, given the string text = abbbaacc, both a and b occurs 3 times in the text. Since a occurs earlier , a is the answer.

    Functional Description - maximumOccuringCharacter

mnn*/

public class MaximumOccuringCharacter {

  public static char maximumOccuringCharacter(String str){

    char[] charArray = str.toCharArray();
    int[] charMap = new int[256];

    for(char c : charArray){
      charMap[c]++;
    }

    int maxValue=0;
    char maxChar='.';

    for(char c : charArray){
      if(charMap[c] > maxValue){
        maxValue = charMap[c];
        maxChar = c;
      }
    }
    return maxChar;
  }

  public static void main(String[] args){
    String str = "abbbaacc";
    System.out.println(maximumOccuringCharacter(str));
  }

}
