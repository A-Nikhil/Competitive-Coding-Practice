package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
	public static void main(String[] args) {
//		char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		System.out.println(getTime(tasks, n));
	}

	private static int getTime(char[] tasks, int n) {
		if (n == 0) {
			return tasks.length;
		}
		Queue<Character> queue = new LinkedList<>();
		for (char c : tasks) {
			queue.add(c);
		}
		int count = 0, cool = 0;
		char curr;
		while (!queue.isEmpty()) {
			curr = queue.poll();
			count++;
			while (cool != n && !queue.isEmpty()) {
				cool++;
				if (curr == queue.peek()) {
					queue.add(queue.poll());
				} else {
					break;
				}
			}
		}
		return count;
	}
}
