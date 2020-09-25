package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class MergeKSortedLists {
	public static void main(String[] args) {
		String[] listStrings = {
				"1->4->5->NULL",
				"1->3->4->NULL",
				"2->6->NULL"
		};
		ListNode[] lists = new ListNode[listStrings.length];
		for (int i = 0; i < listStrings.length; i++) {
			lists[i] = new LeetCodeListMaker().makeList(listStrings[i]);
		}
		new ListNode().printList(new MergeKSortedLists().mergeKLists(lists));
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null, end = null, temp;
		if (lists.length == 0) {
			return null;
		}
		int emptyCount, small, pos, i;
		while (true) {
			emptyCount = 0;
			small = Integer.MAX_VALUE;
			pos = -1;

			// finding the smallest element
			for (i = 0; i < lists.length; i++) {
				if (lists[i] == null) {
					emptyCount++;
					continue;
				}
				if (lists[i].val < small) {
					small = lists[i].val;
					pos = i;
				}
			}

			if (emptyCount == lists.length) {
				break;
			}

			temp = new ListNode(small);
			if (end == null) {
				head = temp;
			} else {
				end.next = temp;
			}
			end = temp;

			lists[pos] = lists[pos].next;
		}
		return head;
	}
}
