package LeetCode;

import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceInString {
	public static void main(String[] args) {
		String S = "abcd";
		int[] indexes = {0, 2};
		String[] sources = {"a", "cd"}, targets = {"eee", "ffff"};
		System.out.println(new FindAndReplaceInString().findReplaceString(S, indexes, sources, targets));
	}

	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		Map<Integer, String[]> map = new TreeMap<>();
		for (int i = 0; i < indexes.length; i++) {
			map.put(indexes[i], new String[]{sources[i], targets[i]});
		}
		String source, target;
		StringBuilder answer = new StringBuilder();
		int index, i = 0;
		while (i < S.length()) {
			if (map.containsKey(i)) {
				index = i;
				source = map.get(i)[0];
				target = map.get(i)[1];
				if (S.indexOf(source, index) == index) {
					answer.append(target);
					i += source.length();
				} else {
					answer.append(S.charAt(i));
					i++;
				}
			} else {
				answer.append(S.charAt(i));
				i++;
			}
		}
		return answer.toString();
	}
}
