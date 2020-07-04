package DataStructures.Stacks;

import java.util.Stack;

public class StockSpan {
	public static void main(String[] args) {
		int[] price = {10, 4, 5, 90, 120, 80};
		int[] span = getSpan(price, price.length);
		System.out.println(span[3 - 1]);
		System.out.println(span[4 - 1]);
		System.out.println(span[5 - 1]);
	}

	private static int[] getSpan(int[] price, int n) {
		int[] span = new int[n];
		span[0] = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
				stack.pop();
			}

			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

			stack.push(i);
		}
		return span;
	}
}
