package DataStructures.Stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] hist = {6, 2, 5, 4, 5, 1, 6};
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}

	private static int getMaxArea(int[] hist, int n) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0, currArea, top, i = 0;
		while (i < n) {
			if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				top = stack.pop();
				currArea = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = Math.max(maxArea, currArea);
			}
		}

		while (!stack.isEmpty()) {
			top = stack.pop();
			currArea = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}
}
