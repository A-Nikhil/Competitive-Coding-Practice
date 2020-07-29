package DataStructures.LinkedList.CicularLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class InsertIntoSortedCircularList {
	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(2);
		list.convertCircular();
		list.printCircularList();
		list.head = insert(list.head, 3);
		list.printCircularList();
		list.head = insert(list.head, 7);
		list.printCircularList();
		list.head = insert(list.head, 1);
		list.printCircularList();
	}

	private static ListNode insert(ListNode head, int element) {
		ListNode end, node = head, prev = null;
		while (node.next != head) {
			node = node.next;
		}
		end = node;

		ListNode elementNode = new ListNode(element);

		if (element < head.val) { // element is smaller than head
			elementNode.next = head;
			end.next = head = elementNode;
		} else if (element > end.val) { // element is greater than the last node
			end.next = elementNode;
			elementNode.next = head;
		} else {
			node = head;
			while (node.next != head) {
				if (element <= node.val) {
					elementNode.next = node;
					prev.next = elementNode;
					break;
				}
				prev = node;
				node = node.next;
			}
		}

		return head;
	}
}
