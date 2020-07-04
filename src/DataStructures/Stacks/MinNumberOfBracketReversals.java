package DataStructures.Stacks;

import java.util.Stack;

public class MinNumberOfBracketReversals {
	public static void main(String[] args) {
		String[] arr = {"}{", "{{{", "{{{{", "{{{{}}", "}{{}}{{{"};
		for (String x : arr) {
			System.out.println(numberReversals(x));
		}
	}

	private static int numberReversals(String x) {
		if (x.length() % 2 == 1) {
			return -1;
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '}' && !stack.isEmpty()) {
				if (stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(x.charAt(i));
				}
			} else {
				stack.push(x.charAt(i));
			}
		}

		int len = stack.size(), n = 0;
		while (!stack.isEmpty()) {
			if (stack.peek() == '{') {
				n++;
			}
			stack.pop();
		}
		return len / 2 + n % 2;
	}
}
