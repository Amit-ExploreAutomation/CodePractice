
/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:
1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

Follow up:
Can you solve it in O(N) time and O(1) space?

*/

package com.ea.leetcode;

import java.util.Stack;

public class BackspaceStringCompareLC {


  public static boolean backspaceCompare(String S, String T) {

    Stack<Character> stackS = new Stack<>();
    Stack<Character> stackT = new Stack<>();


    for(int i=0; i<S.length();i++){
      if(S.charAt(i) != '#'){
        stackS.push(S.charAt(i));
      }else if(!stackS.empty())
        stackS.pop();
    }

    System.out.println(stackS);

    for(int i=0; i<T.length();i++){
      if(T.charAt(i) != '#'){
        stackT.push(T.charAt(i));
      }else if (!stackT.empty())
        stackT.pop();
    }

    System.out.println(stackT);
    return stackS.equals(stackT);
  }


  public static boolean backspaceCompareBF(String S, String T) {
    int S_Pointer = S.length()-1;
    int T_Pointer = T.length()-1;
    int S_Skips =0;
    int T_Skips =0;


    while(S_Pointer >=0 || T_Pointer >=0){

      while(S_Pointer >= 0){
        if(S.charAt(S_Pointer) == '#'){
          S_Skips +=1;
          S_Pointer -=1;
        }else if(S_Skips > 0){
          S_Pointer -=1;
          S_Skips -=1;
        }else{
          break;
        }
      }

      while(T_Pointer >= 0){
        if(T.charAt(T_Pointer) == '#'){
          T_Skips +=1;
          T_Pointer -=1;
        }else if(T_Skips > 0){
          T_Pointer -=1;
          T_Skips -=1;
        }else{
          break;
        }
      }

      if(S_Pointer >= 0 && T_Pointer >= 0 && S.charAt(S_Pointer) != T.charAt(T_Pointer)){
        return false;
      }

      if((S_Pointer >= 0) != (T_Pointer >=0)){
        return false;
      }

      S_Pointer -=1;
      T_Pointer -=1;

    }
    return true;
  }


    public static void main(String[] args){
    String s1 = "ab#c";
    String s2 = "ad#c";

    //System.out.println(backspaceCompare(s1,s2));
    System.out.println(backspaceCompareBF(s1,s2));


    }

}
