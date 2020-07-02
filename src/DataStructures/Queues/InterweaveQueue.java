/*
Following are the steps to solve the problem:
1.Push the first half elements of queue to stack.
2.Enqueue back the stack elements.
3.Dequeue the first half elements of the queue and enqueue them back.
4.Again push the first half elements into the stack.
5.Interleave the elements of queue and stack.
 */

package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class InterweaveQueue {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
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
		interweave(q, q.size());
	}

	private static void interweave(Queue<Integer> queue, int n) {
		if (n % 2 == 1) {
			return;
		}
		int half = n / 2, i;
		Stack<Integer> stack = new Stack<>();
		for (i = 0; i < half; i++) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		for (i = 0; i < half; i++) {
			queue.add(queue.poll());
		}
		for (i = 0; i < half; i++) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
			queue.add(queue.poll());
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
}
