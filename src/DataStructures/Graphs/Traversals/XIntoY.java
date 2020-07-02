/*
Minimum number of operation required to convert number x into y
Given a initial number x and two operations which are given below:

Multiply number by 2.
Subtract 1 from the number.
The task is to find out minimum number of operation required to convert number x into y using
only above two operations. We can apply these operations any number of times.

Constraints:
1 <= x, y <= 10000

https://www.geeksforgeeks.org/minimum-number-operation-required-convert-number-x-y/
*/

package DataStructures.Graphs.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class XIntoY {
	public static void main(String[] args) {
		int x = 2, y = 5;
		System.out.println(findNumber(x, y));
	}

	private static int findNumber(int x, int y) {
		ArrayList<Integer> visited = new ArrayList<>();
		Entry node = new Entry(x, 0);
		Queue<Entry> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.element == y) {
				return node.steps;
			}
			if (!visited.contains(node.element) && x > 0) {
				visited.add(x);
				queue.add(new Entry(node.element * 2, node.steps + 1));
				queue.add(new Entry(node.element - 1, node.steps + 1));
			}
		}
		return -1;
	}

	static class Entry {
		int element, steps;

		public Entry(int element, int steps) {
			this.element = element;
			this.steps = steps;
		}
	}
}
