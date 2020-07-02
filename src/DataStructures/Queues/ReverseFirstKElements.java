package DataStructures.Queues;

import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class ReverseFirstKElements {
	public static void main(String[] args) {
		Queue<Integer> q = new java.util.LinkedList<>();
		q.add(11);
		q.add(12);
		q.add(13);
		q.add(14);
		q.add(15);
		q.add(16);
		q.add(17);
		q.add(18);
		q.add(19);
		q.add(20);
		int k = 3;
		reverseK(q, q.size(), k);
	}

	private static void reverseK(Queue<Integer> queue, int size, int k) {
		Stack<Integer> stack = new Stack<>();
		int i;
		for (i = 0; i < k; i++) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		for (i = 0; i < size - k; i++) {
			queue.add(queue.poll());
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
}
