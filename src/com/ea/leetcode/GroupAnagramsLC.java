
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.
*/


package com.ea.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLC {

  public static List<List<String>> groupAnagrams(String[] input){

    Map<String,List<String>> map = new HashMap<>();

    for(String s: input){
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray);
      //String str = String.valueOf(charArray);
      //String str = new String(charArray);
        String str = Arrays.toString(charArray);
      System.out.println(str);
      if(!map.containsKey(str)){
        map.put(str, new ArrayList());
      }
      map.get(str).add(s);
    }
    return new ArrayList(map.values());
  }

  public static void main(String[] args){

    String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

    System.out.println(groupAnagrams(input));

  }

}
