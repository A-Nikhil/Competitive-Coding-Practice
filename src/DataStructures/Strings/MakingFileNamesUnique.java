package DataStructures.Strings;

import Commons.ArrayPrinter;

import java.util.HashMap;

public class MakingFileNamesUnique {
	public static void main(String[] args) {
//		String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
		String[] names = {"wano", "wano", "wano", "wano"};
//		String[] names = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
		new ArrayPrinter().printArray(getFolderNames(names));
	}

	private static String[] getFolderNames(String[] names) {
		if (names.length == 0) {
			return new String[0];
		}
		HashMap<String, Integer> map = new HashMap<>();
		String tempName;
		int suffix;
		String[] result = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			if (!map.containsKey(names[i])) {
				map.put(names[i], 1);
				result[i] = names[i];
			} else {
				suffix = map.get(names[i]);
				tempName = names[i] + "(" + suffix + ")";
				while (map.containsKey(tempName)) {
					suffix++;
					tempName = names[i] + "(" + suffix + ")";
				}
				map.put(names[i], suffix);
				map.put(tempName, 1);
				result[i] = tempName;
			}
		}
		return result;
	}
}
