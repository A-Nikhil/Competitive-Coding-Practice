package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueueWithoutExtraSpace {

	public static void main(String[] args) {
		Queue<Integer> list = new LinkedList<>();
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);

		//Sort Queue
		sortQueue(list);

		//print sorted Queue
		while (!list.isEmpty()) {
			System.out.print(list.poll() + " ");
		}
	}

	private static void sortQueue(Queue<Integer> queue) {
		for (int i = 1; i <= queue.size(); i++) {
			int minIndex = getMinIndex(queue, (queue.size() - i));
			insertElementToRear(queue, minIndex);
		}
	}

	private static int getMinIndex(Queue<Integer> queue, int sortIndex) {
		int minIndex = -1, minValue = Integer.MAX_VALUE, temp;
		for (int i = 0; i < queue.size(); i++) {
			temp = queue.poll();
			if (temp <= minValue && i <= sortIndex) {
				minValue = temp;
				minIndex = i;
			}
			queue.add(temp);
		}
		return minIndex;
	}

	private static void insertElementToRear(Queue<Integer> queue, int minIndex) {
		int minValue = 0, current;
		for (int i = 0; i < queue.size(); i++) {
			current = queue.poll();
			if (i != minIndex) {
				queue.add(current);
			} else {
				minValue = current;
			}
		}
		queue.add(minValue);
	}
}
