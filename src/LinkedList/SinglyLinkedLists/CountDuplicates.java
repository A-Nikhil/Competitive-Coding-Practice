package LinkedList.SinglyLinkedLists;

import Commons.ListNode;

public class CountDuplicates {
	private static int countDuplicates(ListNode<Integer> head, int key) {
		int count = 0;
		while (head != null) {
			if (head.data == key) {
				count++;
			}
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode<Integer> llist = new ListNode<>();
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.printList();
		System.out.println();
		System.out.println(countDuplicates(llist.head, 1));
	}
}
