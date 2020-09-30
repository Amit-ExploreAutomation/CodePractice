package com.Java8;

import com.arrays.Array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

  public static void main(String[] args){

    List<String> productList = Arrays.asList("MacBook","iPhone","Shoes","Bat");

    System.out.println(productList);

    productList.forEach(ele -> System.out.println(ele));

    List<String> result = productList.stream().filter(ele -> !ele.equals("Bat")).collect(Collectors.toList());

    result.forEach(ele -> System.out.println(ele));

  }

}
