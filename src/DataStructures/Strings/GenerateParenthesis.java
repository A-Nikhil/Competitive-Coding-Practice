// https://leetcode.com/problems/generate-parentheses/

package DataStructures.Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	private static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0) {
			return result;
		}
		dfs(result, "", n, n);
		return result;
	}

	private static void dfs(List<String> result, String s, int left, int right) {
		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateParenthesis(n));
	}
}
