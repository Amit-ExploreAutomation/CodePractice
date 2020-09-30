package com.ea.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

  public static boolean wordPattern(String pattern, String s) {

    String[] s_words = s.split(" ");
    char[] p_chars = pattern.toCharArray();

    Map<String,Integer> map = new HashMap<>();

    for(int i = 0 ; i < p_chars.length; i++){

      if(!map.containsKey(Character.toString(p_chars[i])))
        map.put(Character.toString(p_chars[i]),i);

      System.out.println(map);

      if(!map.containsKey(s_words[i]))
        map.put(s_words[i],i);
      System.out.println(map);

      System.out.println(map.get(Character.toString(p_chars[i])));
      System.out.println(map.get(s_words[i]));
      if(map.get(Character.toString(p_chars[i])) != map.get(s_words[i]))
        return false;

    }

    return true;
  }

  public static void main(String[] args){
    System.out.println(wordPattern("abba", "dog cat cat dog"));
  }
}
