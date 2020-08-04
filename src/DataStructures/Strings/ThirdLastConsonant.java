package DataStructures.Strings;

public class ThirdLastConsonant {
	public static void main(String[] args) {
		String x = "alphabetic";
		char ch = new ThirdLastConsonant().thirdLastConsonant(x);
		System.out.println(ch == 0 ? "null" : ch);
	}

	public char thirdLastConsonant(String x) {
		char[] cons = new char[3];
		char ch;
		for (int i = 0; i < x.length(); i++) {
			ch = x.charAt(i);
			if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
				cons[0] = cons[1];
				cons[1] = cons[2];
				cons[2] = ch;
			}
		}
		return cons[0];
	}
}
