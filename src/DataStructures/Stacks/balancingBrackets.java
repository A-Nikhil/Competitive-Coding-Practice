package DataStructures.Stacks;

import java.util.Stack;

public class balancingBrackets {
	public static void main(String[] args) {
		System.out.println(isBalanced("{[()]}"));
	}

	private static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		char ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			if ((ch == ')' && stack.peek() == '(') ||
					(ch == '}' && stack.peek() == '{') ||
					(ch == ']' && stack.peek() == '[')) {
				stack.pop();
			} else {
				return "NO";
			}
		}
		if (stack.size() != 0) {
			return "NO";
		} else {
			return "YES";
		}
	}
}
