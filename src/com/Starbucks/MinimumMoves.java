package com.Starbucks;

/* Andrea and Maria each have an array of integers. Andrea wants to change her array to match Maria's. For each element of her array, she can
   increament or decreament one digit in one time in move. How many moves will it take Andrea to match Maria's array. No reordering of the digit
   is allowed.

   For example, consider two arrays: Andrea's = [123, 543] and Maria's = [321, 279]

   For the first integer, Andrea can increment the 1 twice to achieve 3. The 2's are equal already. Finally, she decrement her 3 twice to equal 1.
   It took 4 moves to reach her goal.

   For the second integer, she decrement 5 three times, increment 4 three times and 3 six times. It took 12 moves to convert the second array element.

  In total, it took 16 moves to convert both values comprising the complete array.

*/

import java.util.Arrays;
import java.util.List;

public class MinimumMoves {

  public static int moves(List<Integer> a, List<Integer> m){
    int moves =0;
    for(int i = 0; i < a.size(); i++){
      int ai = a.get(i);
      int mi = m.get(i);

      while(ai != 0 && mi != 0){
        int ad = ai % 10;
        ai = ai/10;

        int md = mi % 10;
        mi = mi/10;

        moves = moves + Math.abs(ad-md);
      }
    }
    return moves;
  }

  public static void main(String[] args){


    System.out.println(moves(Arrays.asList(123,543), Arrays.asList(321, 279)));

  }

}
