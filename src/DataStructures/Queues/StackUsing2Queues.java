package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
	public static void main(String[] args) {
		// MyStack obj = new MyStack();
	}

	static class MyStack {
		Queue<Integer> stacker;
		Queue<Integer> aux;

		public MyStack() {
			stacker = new LinkedList<>();
			aux = new LinkedList<>();
		}

		/**
		 * Push element x onto stack.
		 */
		public void push(int x) {
			stacker.add(x);
			while (!aux.isEmpty()) {
				stacker.add(aux.poll());
			}
			while (!stacker.isEmpty()) {
				aux.add(stacker.poll());
			}
		}

		/**
		 * Removes the element on top of the stack and returns that element.
		 */
		public int pop() {
			return aux.isEmpty() ? -1 : aux.poll();
		}

		/**
		 * Get the top element.
		 */
		public int top() {
			return aux.isEmpty() ? -1 : aux.peek();
		}

		/**
		 * Returns whether the stack is empty.
		 */
		public boolean empty() {
			return aux.isEmpty();
		}
	}
}
