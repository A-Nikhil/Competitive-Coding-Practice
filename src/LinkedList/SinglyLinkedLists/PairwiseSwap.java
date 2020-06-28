package LinkedList.SinglyLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class PairwiseSwap {
	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<>();
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		System.out.println("List before swapping");
		list.printList();
		System.out.println();

		pairwiseSwap(list.head);

		System.out.println("\nList after swapping");
		list.printList();
	}

	private static void pairwiseSwap(ListNode<Integer> head) {
		int k;
		while (head != null && head.next != null) {
			k = head.next.data;
			head.next.data = head.data;
			head.data = k;
			head = head.next.next;
		}
	}
}
