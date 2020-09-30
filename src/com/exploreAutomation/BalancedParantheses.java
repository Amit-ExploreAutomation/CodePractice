package com.exploreAutomation;

import java.util.Stack;

public class BalancedParantheses {

  public static boolean isBalanced(String s){

    Stack<Character> stack = new Stack<>();

    for(char c : s.toCharArray()){
      if(c == '(' || c == '{' || c == '['){
        stack.push(c);
      }else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
        stack.pop();
      }else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
        stack.pop();
      }else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
        stack.pop();
      }else{
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args){
    String s1 = "()[]{}";
    String s2 = "([)]";
    System.out.println(isBalanced(s1));
    System.out.println(isBalanced(s2));
  }

}
