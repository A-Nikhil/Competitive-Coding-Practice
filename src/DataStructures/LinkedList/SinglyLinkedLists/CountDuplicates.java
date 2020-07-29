package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

public class CountDuplicates {
	public static void main(String[] args) {
		ListNode llist = new ListNode();
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.printList();
		System.out.println();
		System.out.println(countDuplicates(llist.head, 1));
	}

	private static int countDuplicates(ListNode head, int key) {
		int count = 0;
		while (head != null) {
			if (head.val == key) {
				count++;
			}
			head = head.next;
		}
		return count;
	}
}
