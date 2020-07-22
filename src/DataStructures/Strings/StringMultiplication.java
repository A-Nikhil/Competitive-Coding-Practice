// https://leetcode.com/problems/multiply-strings/

package DataStructures.Strings;

public class StringMultiplication {
	public static void main(String[] args) {
		String num1 = "123", num2 = "456";
		System.out.println(multiply(num1, num2));
	}

	private static String multiply(String num1, String num2) {
		int[] d = new int[num1.length() + num2.length()];
		num1 = new StringBuffer(num1).reverse().toString();
		num2 = new StringBuffer(num2).reverse().toString();
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				d[i + j] = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		StringBuilder sb = new StringBuilder();
		int carry, mod;
		for (int i = 0; i < d.length; i++) {
			mod = d[i] % 10;
			carry = d[i] / 10;
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			sb.insert(0, mod);
		}

		while (sb.charAt(0) == '0' && sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
}
