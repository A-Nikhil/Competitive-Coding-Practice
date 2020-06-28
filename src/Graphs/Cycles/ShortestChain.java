package Graphs.Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestChain {
	public static void main(String[] args) {
		String[] words = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
		ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(words));
		String start = "TOON";
		String find = "POIN";
		new ShortestChain().findChainLength(dictionary, start, find);
	}

	private void findChainLength(ArrayList<String> dictionary, String start, String target) {
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		int length = 1;
		while (!queue.isEmpty()) {
			start = queue.poll();
			for (String s : dictionary) {
				if (isAdjacent(start, s)) {
					queue.add(s);
					dictionary.remove(s);
					break;
				}
			}
			start = queue.peek();
			assert start != null;
			if (start.equalsIgnoreCase(target)) {
				break;
			}
			length++;
		}
		System.out.println("Length = " + (length + 1));
	}

	private boolean isAdjacent(String a, String b) {
		int count = 0;
		for (int pos = 0; pos < a.length(); pos++) {
			if (a.charAt(pos) != b.charAt(pos)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1;
	}
}
