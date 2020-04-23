package com.arrays;
/*
(Amazon) Find the biggest profit in stocks.
For example,
Input: [7, 1, 5, 3, 6, 4]
Output: 5

Variant: identify buying stock date and selling stock date
*/

public class MaxProfitSellingStocks {

	//Find max profit, DP, Time O(n), Space O(1), n is length of array
	public static int maxProfit(int[] a) {
		if (a.length < 1)
			return 0;
	    int min = a[0], profit = 0;
	    for (int i = 1; i < a.length; i++) {
	    	profit = Math.max(profit, a[i] - min);
	   		min = Math.min(min, a[i]);
	    }
	    return profit;
	 }

	//Find max profit and buying/selling dates, DP, Time O(n), Space O(1)
	public static int maxPorfitAndDates(int[] a) {
		if (a.length < 1)
			return 0;
		int min = a[0], profit = 0;
		int start = 0, end = 0, tmp = 0;
	    for (int i = 1; i < a.length; i++) {
	    	if (a[i] < min) {
	    		min = a[i];
	    		tmp = i;
	    	} else if (a[i] - min > profit) {
	    		profit = a[i] - min;
	            if (profit > 0) {
	            	start = tmp;
	            	end = i;
	            }
	    	}
	    }
	    if (profit > 0)
	    	System.out.println("Start day: " + start + ", end day: " + end);
	    else
		   	System.out.println("There is no profit.");
	    return profit;
	}

	public static void main(String[] args) {
		//Test case 1, There is profit
		int[] stocks = {7, 1, 5, 3, 6, 4};
        System.out.print("Stocks: ");
	    Array.print(stocks);
		System.out.println("The max profit: " + maxProfit(stocks));
		maxPorfitAndDates(stocks);
		System.out.println();

		//Test case 2, There is no profit
		int[] stocks1 = {7, 6, 4, 3, 1};
        System.out.print("Stocks: ");
	    Array.print(stocks1);
		System.out.println("The max profit: " + maxProfit(stocks1));
		maxPorfitAndDates(stocks1);
	}
}
