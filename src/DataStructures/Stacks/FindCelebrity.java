package DataStructures.Stacks;

import java.util.Stack;

public class FindCelebrity {
	public static void main(String[] args) {
		int[][] mat = {
				{0, 0, 1, 0},
				{0, 0, 1, 0},
				{0, 0, 0, 0},
				{0, 0, 1, 0}
		};
		System.out.println(findCeleb(mat, mat.length));
	}

	private static int findCeleb(int[][] mat, int n) {
		Stack<Integer> stack = new Stack<>();
		int a, b, i;
		for (i = 0; i < n; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			a = stack.pop();
			b = stack.pop();
			if (mat[a][b] == 1) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}

		int c = stack.pop();

		for (i = 0; i < n; i++) {
			if (i != c && (mat[c][i] == 1 || mat[i][c] != 1)) {
				return -1;
			}
		}

		return c + 1;
	}
}
