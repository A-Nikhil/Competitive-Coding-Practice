package DataStructures.LinkedList.CicularLinkedLists;

import Commons.ListNode;

public class Josephus {
	public static void main(String[] args) {
		josephus(5, 3);
		josephus(4, 2);
		josephus(10, 4);
		josephus(14, 2);
	}

	private static void josephus(int n, int m) {
		ListNode head = new ListNode(1), node, lastPtr = head;
		for (int i = 2; i <= n; i++) {
			ListNode element = new ListNode(i);
			lastPtr.next = element;
			lastPtr = element;
		}
		lastPtr.next = head;

		int count = 0, countM = 0;
		node = head;
		while (count < n) {
			countM++;
			if (countM == m) {
				node.next = node.next.next;
				countM = 0;
				count++;
			}
			node = node.next;
		}

		System.out.println("Person Alive => " + node.val);
	}
}
