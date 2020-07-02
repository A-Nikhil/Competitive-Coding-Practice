package DataStructures.Stacks;

import java.util.Stack;

public class ReverseStackUsingRecursion {
	private static Stack<Integer> stack;

	public static void main(String[] args) {
		stack = new Stack<>();
		for (int i = 4; i > 0; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		recursion(stack.peek());
		System.out.println(stack);
	}

	private static void recursion(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
		} else {
			int a = stack.pop();
			recursion(a);
			stack.push(a);
		}
	}
}
