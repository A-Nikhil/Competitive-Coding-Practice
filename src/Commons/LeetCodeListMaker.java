// Constructing a LinkedList from a LeetCode input

package Commons;

public class LeetCodeListMaker {
    ListNode<Integer> head;

    public LeetCodeListMaker() {
        this.head = null;
    }

    public ListNode<Integer> makeList(String x) {
        ListNode<Integer> temp = null, newNode;
        String[] elems = x.split("->");
        for (int i = 0; i < elems.length - 1; i++) {
            newNode = new ListNode<>(Integer.parseInt(elems[i]));
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

    public ListNode<Integer> makeList(int[] arr) {
        ListNode<Integer> temp = null, newNode;
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode<>(arr[i]);
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
