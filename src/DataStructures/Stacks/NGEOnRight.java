package DataStructures.Stacks;

import java.util.Stack;

public class NGEOnRight {
	public static void main(String[] args) {
		int[] values = {3, 4, 2, 7, 5, 8, 10, 6};
		int[] queries = {3, 6, 1};
		findNGE(values, queries, values.length);
	}

	private static void findNGE(int[] values, int[] queries, int n) {
		int[] dp = new int[n];
		dp[n - 1] = 0;
		int[] next = fillNext(values, n);
		for (int i = n - 2; i >= 0; i--) {
			if (next[i] == -1) {
				dp[i] = 0;
			} else {
				dp[i] = dp[next[i]] + 1;
			}
		}

		for (int j : queries) {
			System.out.println(dp[j]);
		}
	}

	private static int[] fillNext(int[] values, int n) {
		int[] next = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int cur;
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty()) {
				cur = stack.peek();
				if (values[cur] < values[i]) {
					next[cur] = i;
					stack.pop();
				} else {
					break;
				}
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			cur = stack.peek();
			next[cur] = -1;
			stack.pop();
		}

		return next;
	}
}
