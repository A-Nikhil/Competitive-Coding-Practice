package DataStructures.Strings;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
//		String str = "abcdab";
		String str = "cbadabc";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().getSubstring(str));
	}

	public String getSubstring(String str) {
		int start = 0, end = 0;
		int maxStart = 0, maxEnd = 0;
		HashSet<Character> set = new HashSet<>();
		int result = -1;
		for (int i = 0; i < str.length(); i++) {
			while (set.contains(str.charAt(i))) {
				set.remove(str.charAt(start));
				start++;
			}
			end++;
//			System.out.println(set);
			if (result < (end - start)) {
				maxStart = start;
				maxEnd = end;
				result = end - start;
			}
			set.add(str.charAt(i));
		}
//		System.out.println(maxStart + " " + maxEnd);
		return str.substring(maxStart, maxEnd);
	}
}
