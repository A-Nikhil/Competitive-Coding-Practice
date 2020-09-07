// https://leetcode.com/problems/word-pattern/

package DataStructures.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class WordPattern {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pattern = in.readLine();
		String str = in.readLine();
		System.out.println(new WordPattern().wordPattern(pattern, str));
	}

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(words[i])) {
				map.put(pattern.charAt(i), words[i]);
			} else {
				String value = map.get(pattern.charAt(i));
				if (value == null || !value.equals(words[i])) {
					return false;
				}
			}
		}
		return true;
	}
}
