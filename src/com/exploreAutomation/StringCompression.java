package com.exploreAutomation;

/*  String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
    For example, the string aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than original string
    your methid should return the original string. You can assume the strings has only uppercase and losercase letter (a-z).
 */
public class StringCompression {

  public static String compress(String s){

  String compressedString = "";
  int continuosCount = 0;

  for (int i = 0; i < s.length();i++){
    continuosCount++;
    if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
      compressedString += "" + s.charAt(i) + continuosCount;
      continuosCount = 0;
    }
  }

  if(compressedString.length() < s.length()){
    return compressedString;
  }else{
    return s;
  }

  }

  public static String stringBuffercompress(String s){

    StringBuffer sb = new StringBuffer();
    int continuosCount = 0;

    for (int i = 0; i < s.length();i++){
      continuosCount++;
      if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
        sb.append(s.charAt(i));
        sb.append(continuosCount);
        continuosCount = 0;
      }
    }

    if(sb.length() < s.length()){
      return sb.toString();
    }else{
      return s;
    }

  }

  public static void main(String[] args){
    String s = "aabcccccaaa";
    System.out.println(compress(s));
  }

}
