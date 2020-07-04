/*
1) Create an empty queue of strings
2) Enqueue the first binary number “1” to queue.
3) Now run a loop for generating and printing n binary numbers.
……a) Dequeue and Print the front of queue.
……b) Append “0” at the end of front item and enqueue it.
……c) Append “1” at the end of front item and enqueue it.
 */

package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryTillN {
	public static void main(String[] args) {
		printBinary(5);
		System.out.println();
		printBinary(9);
	}

	private static void printBinary(int n) {
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		for (int i = 1; i <= n; i++) {
			String top = queue.poll();
			System.out.print(top + " ");
			queue.add(top + "0");
			queue.add(top + "1");
		}
	}
}
