package DataStructures.Graphs.Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestChain {
	public static void main(String[] args) {
//		String[] words = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
//		ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(words));
//		String start = "TOON";
//		String find = "POIN";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(words));
		String start = "hit";
		String find = "cog";
//		String[] words = {"a", "b", "c"};
//		ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(words));
//		String start = "a";
//		String find = "c";
		System.out.println(new ShortestChain().findChainLength(dictionary, start, find));
	}

	private int findChainLength(ArrayList<String> dictionary, String start, String target) {
		Queue<Entry> queue = new LinkedList<>();
		boolean[] visited = new boolean[dictionary.size()];
		if (dictionary.contains(start)) {
			visited[dictionary.indexOf(start)] = true;
		}
		queue.add(new Entry(start, 1));
		Entry word;
		while (!queue.isEmpty()) {
			word = queue.poll();
			start = word.s;
			if (start.equals(target)) {
				return word.length;
			}
			for (int i = 0; i < dictionary.size(); i++) {
				if (isAdjacent(start, dictionary.get(i)) && !visited[i]) {
					queue.add(new Entry(dictionary.get(i), word.length + 1));
					visited[i] = true;
				}
			}
		}
		return -1;
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

	static class Entry {
		String s;
		int length;

		Entry(String s, int length) {
			this.s = s;
			this.length = length;
		}
	}
}
