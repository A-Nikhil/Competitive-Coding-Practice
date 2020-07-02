package DataStructures.LinkedList.CicularLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class DeletionFromACLL {
	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<>();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.convertCircular();
		list.printCircularList();
		delete(list.head, 3);
		list.printCircularList();
		delete(list.head, 1);
		list.printCircularList();
		delete(list.head, 6);
		list.printCircularList();

	}

	private static void delete(ListNode<Integer> head, int element) {
		ListNode<Integer> node = head, end, prev = head;
		while (node != null && node.next != head) {
			prev = node;
			node = node.next;
		}
		end = node;

		// Last Node
		if (end.data == element) {
			prev.next = head;
		}

		// First node
		else if (head.data == element) {
			end.next = head.next;
			head = head.next;
		}

		// Node in between
		else {
			node = prev = head;
			while (node.next != head) {
				if (node.data == element) {
					prev.next = node.next;
					break;
				}
				prev = node;
				node = node.next;
			}
		}
	}
}
