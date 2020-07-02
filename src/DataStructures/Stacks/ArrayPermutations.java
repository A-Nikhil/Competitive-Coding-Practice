package DataStructures.Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayPermutations {
	public static void main(String[] args) {
		int[] in = {1, 2, 3},
				out = {2, 1, 3};
		System.out.println(isPermuted(in, out, in.length));
	}

	private static boolean isPermuted(int[] in, int[] out, int n) {
		Queue<Integer> input = new LinkedList<>(), output = new LinkedList<>();
		for (int i : in) {
			input.add(i);
		}
		for (int i : out) {
			output.add(i);
		}

		Stack<Integer> stack = new Stack<>();
		int element;
		while (!input.isEmpty()) {
			element = input.poll();
			if (element == output.peek()) {
				output.poll();
				while (!stack.isEmpty()) {
					if (stack.peek() == output.peek()) {
						stack.pop();
						output.poll();
					} else {
						break;
					}
				}
			} else {
				stack.push(element);
			}
		}
		return stack.isEmpty() && input.isEmpty();
	}
}
