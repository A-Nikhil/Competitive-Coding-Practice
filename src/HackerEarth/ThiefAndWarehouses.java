package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class ThiefAndWarehouses {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine()), n;
		String[] elems;
		long[] arr, results = new long[tc];
		for (int x = 0; x < tc; x++) {
			n = Integer.parseInt(in.readLine());
			arr = new long[n];
			elems = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(elems[i]);
			}
			results[x] = new ThiefAndWarehouses().maxAreaOfRectangle(arr);
		}
		for (long i : results) {
			System.out.println(i);
		}
	}

	public long maxAreaOfRectangle(long[] arr) {
		Stack<Integer> stack = new Stack<>();
		long maxArea = 0, currArea;
		int top, i = 0;
		while (i < arr.length) {
			if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				top = stack.pop();
				currArea = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = Math.max(maxArea, currArea);
			}
		}

		while (!stack.isEmpty()) {
			top = stack.pop();
			currArea = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}
}
