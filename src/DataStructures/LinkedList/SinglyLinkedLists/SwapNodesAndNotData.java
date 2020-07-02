package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class SwapNodesAndNotData {
	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<>();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);

		System.out.println("List before swapping");
		list.printList();

		int A = 4, B = 2;
		swapNodes(list.head, A, B);


		System.out.println("\nList after swapping");
		list.printList();

	}

	private static void swapNodes(ListNode<Integer> head, int A, int B) {
		if (A == B) {
			return;
		}
		ListNode<Integer> prevX, currX = head, prevY, currY = head;
		ListNode<Integer> temp;
		prevX = prevY = null;
		while (currX != null && currX.data != A) {
			prevX = currX;
			currX = currX.next;
		}

		while (currY != null && currY.data != B) {
			prevY = currY;
			currY = currY.next;
		}

		// Case 1 : if either X or Y is not present
		if (currX == null || currY == null) {
			return;
		}

		// Case 2 : X is not the head
		if (prevX != null) {
			prevX.next = currY;
		} else {
			head = currY;
		}

		// Case 2.2 => Y is not the head
		if (prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}

		temp = currY.next;
		currY.next = currX.next;
		currX.next = temp;
	}
}
