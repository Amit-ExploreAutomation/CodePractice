package com.exploreAutomation;

/* Given a collection of intervals, merge all overlaping intervals
*  Example:
*  Input : [[1,3],[2,6],[8,10],[15,18]]
*  Output : [[1,6],[8,10],[15,18]]
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public static void main(String[] args){
    int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
    System.out.println(merge(arr));
  }

  public static int[][] merge(int[][] intervals){
    if(intervals.length <=1){
      return intervals;
    }

    // we take intervals as that what we are sorting and we will be passing current arr1 in next arr2 than compare
    // Integer of arr 1 1st element and arr2 1st element.

    Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0],arr2[0]));

    // as we do not know what will be the size of output, to deal with that situation we can use list
    List<int[]> output_array = new ArrayList<>();

    int[] current_interval = intervals[0];
    output_array.add(current_interval);

    for(int[] interval : intervals){
      int current_begin = current_interval[0];
      int current_end = current_interval[1];
      int next_begin  = interval[0];
      int next_end = interval[1];

      if(current_end >= next_begin){
        current_interval[1] = Math.max(current_end,next_end);
      }else {
        current_interval = interval;
        output_array.add(current_interval);
      }
    }
    return output_array.toArray(new int[output_array.size()][]);
  }
}
