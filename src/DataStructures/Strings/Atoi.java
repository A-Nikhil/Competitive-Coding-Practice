package DataStructures.Strings;

public class Atoi {
	public static void main(String[] args) {
		String x = "42";
		System.out.println(atoi(x));
	}

	private static int atoi(String s) {
		char ch;
		boolean positive = true;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			// blank space
			if (ch == ' ') {
				continue;
			}

			// plus|minus
			if (ch == '+') {
				positive = true;
				continue;
			} else if (ch == '-') {
				positive = false;
				continue;
			}

			// if reached here.. we will have only numbers and words
			if (ch >= '0' && ch <= '9') {
				res = res + ch;
			} else {
				break;
			}
		}

		if (res.length() == 0) {
			return 0;
		}
		try {
			if (!positive) {
				res = "-" + res;
			}
			return Integer.parseInt(res);
		} catch (NumberFormatException e) {
			return Integer.MIN_VALUE;
		}
	}
}
