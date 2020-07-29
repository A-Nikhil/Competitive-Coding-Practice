package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class ReverseList2 {
	public static void main(String[] args) {
		ListNode head;
		ListNode list = new ListNode();

		// Making List from LeetCode Input
		String x = "1->2->3->4->5->NULL";
//		String x = "3->5->NULL";
		LeetCodeListMaker maker = new LeetCodeListMaker();
		head = maker.makeList(x);
		list.printList(head);
		System.out.println();

		int m = 2, n = 4;
//		int m = 1, n = 2;
		list.printList(reverse(head, m, n));
	}

	private static ListNode reverse(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}

		if (m == n) {
			return head;
		}
		int index = 1;
		ListNode temp = head;
		ListNode auxillary = null, auxEnd = null;
		ListNode start = null;
		ListNode newNode;
		while (temp != null) {
			if (index < m) {
				start = temp;
			} else if (index >= m && index <= n) {
				newNode = new ListNode(temp.val);
				if (auxillary == null) {
					auxEnd = newNode;
				}
				newNode.next = auxillary;
				auxillary = newNode;
			} else {

				break;
			}
			temp = temp.next;
			index++;
		}
		if (start == null) {
			head = auxillary;
		} else {
			start.next = auxillary;
		}
		assert auxEnd != null;
		auxEnd.next = temp;
		return head;
	}
}
