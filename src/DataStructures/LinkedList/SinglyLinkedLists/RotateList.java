package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

public class RotateList {
	public static void main(String[] args) {
//		Set 1
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		int k = 1;

//		Set 2
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int k = 2;
		head.printList(rotateRight(head, k));
	}

	private static ListNode rotateRight(ListNode head, int k) {
		if (k == 0) {
			return head;
		}

		if (head == null) {
			return null;
		}

		ListNode temp = head, tempPrev = null;
		int count = 0, length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		temp = head;
		k = k % length;
		if (k == 0) {
			return head;
		}
		ListNode sepHead = null, sepEnd = null, newNode;
		while (temp != null) {
			if (count <= length - k - 1) {
				tempPrev = temp;
			} else {
				newNode = new ListNode(temp.val);
				if (sepHead == null) {
					sepHead = newNode;
				} else {
					sepEnd.next = newNode;
				}
				sepEnd = newNode;
			}
			temp = temp.next;
			count++;
		}

		assert sepEnd != null;
		sepEnd.next = head;
		assert tempPrev != null;
		tempPrev.next = null;
		head = sepHead;
		return head;
	}
}
