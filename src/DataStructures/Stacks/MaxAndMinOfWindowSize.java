package DataStructures.Stacks;

import Commons.ArrayPrinter;

import java.util.Arrays;
import java.util.Stack;

public class MaxAndMinOfWindowSize {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 50, 10, 70, 30};
		int[] ans = findMaxOfMin(arr, arr.length);
		new ArrayPrinter().printArray(ans, 1, arr.length + 1);
	}

	private static int[] findMaxOfMin(int[] arr, int n) {
		int[] left = new int[n + 1];
		int[] right = new int[n + 1];
		for (int i = 0; i < n; i++) {
			left[i] = -1;
			right[i] = n;
		}
		Stack<Integer> stack = new Stack<>();

		// Left
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				left[i] = stack.peek();
			}
			stack.push(i);
		}

		// Right
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				right[i] = stack.peek();
			}
			stack.push(i);
		}

		int[] ans = new int[n + 1];
		Arrays.fill(ans, 0);
		for (int i = 0; i < n; i++) {
			int len = right[i] - left[i] - 1;
			ans[len] = Math.max(ans[len], arr[i]);
		}
		for (int i = n - 1; i >= 1; i--) {
			ans[i] = Math.max(ans[i], ans[i + 1]);
		}

		return ans;
	}
}
