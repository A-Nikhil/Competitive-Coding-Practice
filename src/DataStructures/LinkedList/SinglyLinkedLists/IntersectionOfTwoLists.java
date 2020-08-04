package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class IntersectionOfTwoLists {
	public static void main(String[] args) {
		int[] listA = {1, 9, 1}, listB = {3}, listC = {2, 4};
		ListNode headA = new LeetCodeListMaker().makeList(listA);
		ListNode headB = new LeetCodeListMaker().makeList(listB);
		ListNode headC = new LeetCodeListMaker().makeList(listC);
		headA.next.next.next = headC;
		headB.next = headC;
		ListNode result = new IntersectionOfTwoLists().getIntersectionNode(headA, headB);
		if (result == null) {
			System.out.println("No Intersection");
		} else {
			System.out.println(result.val);
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode cur = headA;
		ListNode cur1 = headB;
		int l1 = 0, l2 = 0;
		while (cur != null) {
			cur = cur.next;
			l1++;
		}
		while (cur1 != null) {
			cur1 = cur1.next;
			l2++;
		}
		cur = headA;
		cur1 = headB;
		if (l1 < l2) {
			while (l2 != l1 && cur1 != null) {
				cur1 = cur1.next;
				l2--;
			}
			while (cur1 != null) {
				if (cur1 == cur) {
					return cur1;
				}
				cur1 = cur1.next;
				cur = cur.next;
			}

		} else {
			while (l1 != l2 && cur != null) {
				cur = cur.next;
				l1--;
			}
			while (cur != null) {
				if (cur == cur1) {
					return cur;
				}
				cur = cur.next;
				cur1 = cur1.next;
			}
		}
		return null;
	}
}
