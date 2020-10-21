package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
	Map<String, Boolean> map = new HashMap();

	public static void main(String[] args) {
		String s = "catsandog";
		String[] words = {"cats", "dog", "sand", "and", "cat"};
		List<String> wordDict = new ArrayList<>(Arrays.asList(words));
		System.out.println(new WordBreak().wordBreak(s, wordDict));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.contains(s))
			return true;
		if (map.containsKey(s))
			return map.get(s);
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
				map.put(s, true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}
}
