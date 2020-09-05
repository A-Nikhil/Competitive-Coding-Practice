// https://leetcode.com/problems/repeated-substring-pattern/

package DataStructures.Strings;

public class RepeatingSubstring {
	public static void main(String[] args) {
		String s = "abcabcabc";
		System.out.println(new RepeatingSubstring().repeatedSubstringPattern(s));
	}

	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		for (int l = n / 2; l > 0; l--) {
			if (n % l == 0) {
				int i = 0;
				while (i + l < n && s.charAt(i) == s.charAt(i + l))
					i++;
				if (i + l == n)
					return true;
			}
		}
		return false;
	}
}
