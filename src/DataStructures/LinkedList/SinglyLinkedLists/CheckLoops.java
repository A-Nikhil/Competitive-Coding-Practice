package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class CheckLoops {
	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.head.next.next.next.next.next = list.head.next.next;
		System.out.println(checkWithNodes(list.head));
		System.out.println(floydCycleFinding(list.head));

	}

	private static boolean checkWithNodes(ListNode head) {
		ArrayList<ListNode> list = new ArrayList<>();
		list.add(head);
		head = head.next;
		while (head != null) {
			if (list.contains(head)) {
				return true;
			} else {
				list.add(head);
			}
			head = head.next;
		}
		return false;
	}

	private static boolean floydCycleFinding(ListNode head) {
		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
