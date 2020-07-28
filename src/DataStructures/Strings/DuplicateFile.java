package DataStructures.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class DuplicateFile {
	private static List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		int i;
		String path, fr, name, content;
		for (String x : paths) {
			i = x.indexOf(' ') + 1;
			path = x.substring(i - 1);
			fr = "";
			for (; i < x.length(); i++) {
				if (x.charAt(i) == ' ') {
					content = x.substring(x.indexOf('(') + 1, x.indexOf(')'));
					name = x.substring(0, x.indexOf('('));
					if (!map.containsKey(content)) {
						map.put(content, new ArrayList<>());
					}
					map.get(content).add(path + name);
				} else {
					fr = fr + x.charAt(i);
				}
			}
		}
		int count = 0;
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			result.add(new ArrayList<>());
			for (String x : entry.getValue()) {
				result.get(count).add(x);
			}
			count++;
		}
		return result;
	}
}
