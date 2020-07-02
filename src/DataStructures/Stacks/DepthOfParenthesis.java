package DataStructures.Stacks;

public class DepthOfParenthesis {
	public static void main(String[] args) {
		String x = "(((X))(((Y))))";
		System.out.println(getDepth(x));
	}

	private static int getDepth(String x) {
		int curr = 0, max = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '(') {
				curr++;
			}

			max = Math.max(curr, max);

			if (x.charAt(i) == ')') {
				if (curr > 0)
					curr--;
				else
					return -1;
			}
		}
		if (curr != 0) {
			return -1;
		}

		return max;
	}
}
