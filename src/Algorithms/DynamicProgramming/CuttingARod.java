package Algorithms.DynamicProgramming;

public class CuttingARod {
	public static void main(String[] args) {
		int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxProfit(arr, arr.length));
	}

	private static int maxProfit(int[] price, int length) {
		int[] val = new int[length + 1];
		val[0] = 0;
		for (int i = 1; i <= length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Math.max(price[j] + val[i - j - 1], max);
			}
			val[i] = max;
		}
		return val[length];
	}
}
