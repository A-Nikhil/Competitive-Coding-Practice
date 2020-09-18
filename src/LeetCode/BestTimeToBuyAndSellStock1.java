package LeetCode;

public class BestTimeToBuyAndSellStock1 {
	public static void main(String[] args) {
		int[] prices = {7, 1, 3, 4, 5, 6};
//		int[] prices = {6,4,3,2,1};
		System.out.println(new BestTimeToBuyAndSellStock1().maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0, minPrice = Integer.MAX_VALUE;
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		return maxProfit;
	}
}
