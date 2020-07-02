package DataStructures.Stacks;

import java.util.Stack;

public class PermutationsGEToN {
	public static void main(String[] args) {
		System.out.println(getPerms(15));
		System.out.println(getPerms(100));
		System.out.println(getPerms(5));
	}

	private static int getPerms(int n) {
		if (n <= 9) {
			return n;
		}
		int result = 0, top, x;
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= 9; i++) {
			if (i <= n) {
				stack.push(i);
				result++;
			}

			while (!stack.isEmpty()) {
				top = stack.pop();
				for (int j = top % 10; j <= 9; j++) {
					x = top * 10 + j;
					if (x <= n) {
						stack.push(x);
						result++;
					}
				}
			}
		}
		return result;
	}
}
