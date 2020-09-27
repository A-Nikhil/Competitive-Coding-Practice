package DataStructures.Stacks;

import java.util.Stack;

public class GetMinInO1 {
	private static Stack<Integer> stack;
	private static int minElement;

	public static void main(String[] args) {
		stack = new Stack<>();
		minElement = Integer.MAX_VALUE;
		push(3);
		push(5);
		getMin();
		push(2);
		push(1);
		getMin();
		pop();
		getMin();
	}

	private static void push(int element) {
		if (element < minElement) {
			stack.push(2 * element - minElement);
			minElement = element;
		} else {
			stack.push(element);
		}
	}

	private static int getMin() {
		return minElement;
	}

	private static int pop() {
		int y = stack.pop();
		if (y < minElement) {
			minElement = 2 * minElement - y;
		}
		return y;
	}
}
