package com.exploreAutomation;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatedChar {

   public static void main(String[] args){
     String str = "Siismple";

     for(int i = 0; i < str.length();i++){
       boolean unique = true;
       for(int j = i+1; j < str.length();j++){
         if (i != j && str.charAt(i) == str.charAt(j)) {
           unique = false;
           break;
         }
       }
       if(unique){
         System.out.println(str.charAt(i));
         break;
       }
     }

     /*Map<Character,Integer> map = new LinkedHashMap<>();

     for(int i = 0; i < str.length(); i++){
       if(map.containsKey(str.charAt(i))){
         map.put(str.charAt(i),map.get(str.charAt(i))+1);
       }else{
         map.put(str.charAt(i),1);
       }
     }

     *//*for(Map.Entry<Character,Integer> m : map.entrySet()){
       if(m.getValue() == 1){
         System.out.println(m.getKey());
         break;
       }
     }*//*

     for(int i = 0; i < str.length();i++){
       if(map.get(str.charAt(i)) == 1){
         System.out.println(str.charAt(i));
         break;
       }
     }*/
   }

}
