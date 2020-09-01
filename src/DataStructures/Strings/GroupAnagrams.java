//https://leetcode.com/problems/group-anagrams/

package DataStructures.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(new GroupAnagrams().groupAnagrams(strs));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if (strs.length == 0) {
			return result;
		}
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String temp = getSortedSequence(str);
			if (!map.containsKey(temp)) {
				map.put(temp, new ArrayList<>());
			}
			map.get(temp).add(str);
		}
		result.addAll(map.values());
		return result;
	}

	public String getSortedSequence(String x) {
		char[] seq = x.toCharArray();
		Arrays.sort(seq);
		return String.valueOf(seq);
	}
}
