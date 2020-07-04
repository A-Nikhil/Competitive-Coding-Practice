package Algorithms.Backtracking;

public class PermutationsOfAString {
	private static String swap(String x, int a, int b) {
		char temp;
		char[] ch = x.toCharArray();
		temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
		return String.valueOf(ch);
	}

	private static void permute(String s, int l, int r) {
		if (l == r) {
			System.out.println(s);
		} else {
			for (int i = l; i <= r; i++) {
				s = swap(s, l, i);
				permute(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	public static void main(String[] args) {
		permute("ABCD", 0, 4 - 1);
	}
}
