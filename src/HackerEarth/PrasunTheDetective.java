package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PrasunTheDetective {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String code = in.readLine().toLowerCase();
		String guess = in.readLine().toLowerCase();
		System.out.println(new PrasunTheDetective().isPossible(code, guess));
	}

	public String isPossible(String code, String guess) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) != ' ') {
				map.put(guess.charAt(i), map.getOrDefault(guess.charAt(i), 0) + 1);
			}
		}
		for (int i = 0; i < code.length(); i++) {
			if (map.containsKey(code.charAt(i))) {
				int occ = map.get(code.charAt(i)) - 1;
				if (occ == 0) {
					map.remove(code.charAt(i));
				} else {
					map.put(code.charAt(i), occ);
				}
			}
		}
		return map.size() == 0 ? "YES" : "NO";
	}
}
