package DataStructures.Graphs.Traversals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
	private final ArrayList<Integer> jumpers = new ArrayList<>();

	public static void main(String[] args) {
		new JumpingNumbers().printJumping(40);
	}

	private void printJumping(int limit) {
		jumpers.add(0);
		for (int i = 1; i <= 9 && i <= limit; i++) {
			BFS(limit, i);
		}
		Collections.sort(jumpers);
		for (int i : jumpers) {
			System.out.print(i + " ");
		}
	}

	private void BFS(int limit, int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		int last;
		while (!queue.isEmpty()) {
			num = queue.poll();
			if (num <= limit) {
				jumpers.add(num);
				last = num % 10;
				if (last == 0) {
					queue.add(num * 10 + (last + 1));
				} else if (last == 9) {
					queue.add(num * 10 + (last - 1));
				} else {
					queue.add(num * 10 + (last + 1));
					queue.add(num * 10 + (last - 1));
				}
			}
		}
	}
}
