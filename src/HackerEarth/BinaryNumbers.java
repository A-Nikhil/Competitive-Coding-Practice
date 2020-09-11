package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BinaryNumbers {

	private final ArrayList<String> sequence;

	BinaryNumbers() {
		sequence = new ArrayList<>();
	}

	public static void main(String[] args) throws IOException {
		BinaryNumbers obj = new BinaryNumbers();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		String[] queries = new String[tc];
		for (int x = 0; x < tc; x++) {
			int k = Integer.parseInt(in.readLine());
			if (k > obj.sequence.size()) {
				obj.generateSequence(k);
			}
			queries[x] = obj.sequence.get(k - 1);
		}
		System.out.println(obj.sequence);
//		for (String query : queries) {
//			System.out.println(query);
//		}
	}

	private void generateSequence(int k) {
		sequence.clear();
		sequence.add("1");
		int start = 0, index = 1;
		String current;
		while (index < k) {
			current = sequence.get(start++);
			if (current.charAt(current.length() - 1) - '0' == 0) {
				sequence.add(index++, current + "0");
				sequence.add(index++, current + "1");
			} else {
				sequence.add(index++, current + "0");
			}
		}
	}
}
