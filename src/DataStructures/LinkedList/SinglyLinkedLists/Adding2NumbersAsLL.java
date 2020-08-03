// https://leetcode.com/problems/add-two-numbers-ii/

package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

import java.util.Stack;

public class Adding2NumbersAsLL {
	private ListNode newHead;

	public static void main(String[] args) {
		int[] num1 = {7, 2, 4, 3};
		int[] num2 = {5, 6, 4};
		ListNode root = new ListNode();
		root.printList(new Adding2NumbersAsLL().addTwoNumbers(
				new LeetCodeListMaker().makeList(num1),
				new LeetCodeListMaker().makeList(num2)
		));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		newHead = null;
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		int carry = 0, sum;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			sum = stack1.pop() + stack2.pop() + carry;
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			insert(sum);
		}

		while (!stack1.isEmpty()) {
			sum = stack1.pop() + carry;
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			insert(sum);
		}

		while (!stack2.isEmpty()) {
			sum = stack2.pop() + carry;
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			insert(sum);
		}

		if (carry > 0) {
			insert(carry);
		}
		return newHead;
	}

	private void insert(int n) {
		ListNode temp = new ListNode(n);
		if (newHead == null) {
			newHead = temp;
		} else {
			temp.next = newHead;
		}
		newHead = temp;
	}
}
