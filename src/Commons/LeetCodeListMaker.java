// Constructing a LinkedList from a LeetCode input

package Commons;

public class LeetCodeListMaker {
	ListNode head;

	public LeetCodeListMaker() {
		this.head = null;
	}

	public ListNode makeList(String x) {
		ListNode temp = null, newNode;
		String[] elems = x.split("->");
		for (int i = 0; i < elems.length - 1; i++) {
			newNode = new ListNode(Integer.parseInt(elems[i]));
			if (this.head == null) {
				head = newNode;
			} else {
				assert temp != null;
				temp.next = newNode;
			}
			temp = newNode;
		}
		return this.head;
	}

	public ListNode makeList(int[] arr) {
		ListNode temp = null, newNode;
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode(arr[i]);
			if (this.head == null) {
				head = newNode;
			} else {
				assert temp != null;
				temp.next = newNode;
			}
			temp = newNode;
		}
		return this.head;
	}
}
