package LinkedList.SinglyLinkedLists;

import Commons.ListNode;

public class RemoveDuplicatesSorted {
	public static void main(String[] args) {
		ListNode<Integer> llist = new ListNode<>();
		llist.push(20);
		llist.push(13);
		llist.push(13);
		llist.push(11);
		llist.push(11);
		llist.push(11);

		System.out.println("List before removal of duplicates");
		llist.printList();

		removeDuplicates(llist.head);

		System.out.println("List after removal of elements");
		llist.printList();
	}

	private static void removeDuplicates(ListNode<Integer> head) {
		while (head != null && head.next != null) {
			if (head.data == head.next.data) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
	}
}
