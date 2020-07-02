package DataStructures.Stacks;

import java.util.Stack;

public class FindClosingBracket {
	public static void main(String[] args) {
		String x = "[ABC[23]][89]";
		int index = 0;
		System.out.println(findClosingBracket(x, index));
	}

	private static int findClosingBracket(String x, int index) {
		if (x.charAt(index) != '[') {
			return -1;
		}

		Stack<Character> stack = new Stack<>();
		char ch;
		for (int i = index; i < x.length(); i++) {
			ch = x.charAt(i);
			if (ch == '[') {
				stack.push(ch);
			} else if (ch == ']') {
				stack.pop();
				if (stack.isEmpty()) {
					return i;
				}
			}
		}
		return -1;
	}
}
