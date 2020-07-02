package Algorithms.DynamicProgramming;

public class MaxProfitByBuyingAndSellingShares {
	public static void main(String[] args) {
//		int[] price = {2, 30, 15, 10, 8, 25, 80};
		int[] price = {100, 30, 15, 10, 8, 25, 80};
		System.out.println(maxProfit(price, price.length));
	}

	private static int maxProfit(int[] price, int n) {
		int[] profit = new int[n];
		int max, min, i;
		max = price[n - 1];
		for (i = n - 2; i >= 0; i--) {
			if (price[i] > max) {
				max = price[i];
			}
			profit[i] = Math.max(profit[i + 1], max - price[i]);
		}
		min = price[0];
		for (i = 1; i < n; i++) {
			if (price[i] < min) {
				min = price[i];
			}
			profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - min));
		}
		return profit[n - 1];
	}
}
