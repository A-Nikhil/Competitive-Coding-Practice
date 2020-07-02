package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

import java.util.ArrayList;

public class RemoveDuplicatesUnsorted {
	public static void main(String[] args) {
		int[] arr = {10, 12, 11, 11, 12, 11, 10};
		ListNode<Integer> llist = new ListNode<>();
		for (int i : arr) {
			llist.push(i);
		}
		System.out.println("List before removal of duplicates");
		llist.printList();
		removeDuplicates(llist.head);
	}

	private static void removeDuplicates(ListNode<Integer> head) {
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			if (!list.contains(head.data)) {
				list.add(head.data);
			}
			head = head.next;
		}

		System.out.println("\nList after removing duplicates");
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
}
