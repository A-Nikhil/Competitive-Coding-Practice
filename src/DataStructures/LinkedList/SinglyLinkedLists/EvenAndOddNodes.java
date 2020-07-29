package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

public class EvenAndOddNodes {
	public static void main(String[] args) {
		ListNode llist = new ListNode();
		llist.push(11);
		llist.push(10);
		llist.push(9);
		llist.push(6);
		llist.push(4);
		llist.push(1);
		llist.push(0);
		System.out.println("Original Linked List");
		llist.printList();
		System.out.println();
		System.out.println("Modified Linked List");
		llist.printList(segregate(llist.head));
	}

	private static ListNode segregate(ListNode head) {
		ListNode oddStart = null, oddEnd = null;
		ListNode evenStart = null, evenEnd = null, temp;
		while (head != null) {
			temp = new ListNode(head.val);
			if (head.val % 2 == 0) {
				if (evenStart == null) {
					evenStart = temp;
				} else {
					evenEnd.next = temp;
				}
				evenEnd = temp;
			} else {
				if (oddStart == null) {
					oddStart = temp;
				} else {
					oddEnd.next = temp;
				}
				oddEnd = temp;
			}
			head = head.next;
		}
		if (evenStart == null) {
			return oddStart;
		} else {
			evenEnd.next = oddStart;
			return evenStart;
		}
	}
}
