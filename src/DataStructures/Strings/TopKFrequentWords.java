package DataStructures.Strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 3;
		System.out.println(topKFrequent(words, k));
	}

	private static List<String> topKFrequent(String[] words, int k) {
		if (words.length == 0 || words.length < k) {
			return new ArrayList<>();
		}
		List<String> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String i : words) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(new MyComparator());
		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i).getKey());
			if (result.size() == k) {
				break;
			}
		}
		return result;
	}

	private static class MyComparator implements Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Map.Entry<String, Integer> o1,
						   Map.Entry<String, Integer> o2) {
			if (o1.getValue().equals(o2.getValue())) {
				return o2.getKey().compareTo(o1.getKey());
			} else {
				return o1.getValue().compareTo(o2.getValue());
			}
		}
	}
}
