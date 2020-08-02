package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ArrayPrinter;
import Commons.LeetCodeListMaker;
import Commons.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNode {
	public static void main(String[] args) {
//        int[] arr = {2, 7, 4, 3, 5};
		int[] arr = {1, 7, 5, 1, 9, 2, 5, 1};
		ListNode head = new LeetCodeListMaker().makeList(arr);
		new ArrayPrinter().printArray(nextLargerNodes(head));
	}

	private static int[] nextLargerNodes(ListNode head) {
		ArrayList<Integer> A = new ArrayList<>();
		for (ListNode node = head; node != null; node = node.next)
			A.add(node.val);
		int[] res = new int[A.size()];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.size(); ++i) {
			while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
				res[stack.pop()] = A.get(i);
			stack.push(i);
		}
		return res;
	}
}
