package LinkedList.SinglyLinkedLists;

import Commons.ListNode;

public class IntersectionOfLists {
	public static void main(String[] args) {
		ListNode<Integer> list1 = new ListNode<>();
		list1.push(6);
		list1.push(5);
		list1.push(4);
		list1.push(3);
		list1.push(2);
		list1.push(1);

		ListNode<Integer> list2 = new ListNode<>();
		list2.push(8);
		list2.push(6);
		list2.push(4);
		list2.push(2);

		new ListNode<Integer>().printList(intersect(list1.head, list2.head));
	}

	private static ListNode<Integer> intersect(ListNode<Integer> a, ListNode<Integer> b) {
		ListNode<Integer> start = null, end = null, temp;
		while (a != null && b != null) {
			if (a.data == b.data) {
				// First result node
				temp = new ListNode<>(a.data);
				if (start == null) {
					start = temp;
				} else {
					end.next = temp;
				}
				end = temp;
				a = a.next;
				b = b.next;
			} else if (a.data < b.data) {
				a = a.next;
			} else {
				b = b.next;
			}
		}
		return start;
	}
}
