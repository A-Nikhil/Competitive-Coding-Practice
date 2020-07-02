package DataStructures.Stacks;

import java.util.Stack;

public class RedundantBrackets {
	public static void main(String[] args) {
		String x = "((a+b)+c+d)";
		System.out.println(redundantBrackets(x));
	}

	private static boolean redundantBrackets(String x) {
		Stack<Character> stack = new Stack<>();
		int counter;
		char ch, top;
		for (int i = 0; i < x.length(); i++) {
			ch = x.charAt(i);
			if (ch == ')') {
				top = stack.pop();
				counter = 0;
				while (top != '(') {
					counter++;
					top = stack.pop();
				}
				if (counter < 1) {
					return true;
				}
			} else {
				stack.push(ch);
			}
		}
		return false;
	}
}
