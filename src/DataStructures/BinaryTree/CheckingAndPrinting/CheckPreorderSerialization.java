// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

package DataStructures.BinaryTree.CheckingAndPrinting;

import java.util.LinkedList;

public class CheckPreorderSerialization {
	public static void main(String[] args) {
//		String x = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String x = "1,#";
		System.out.println(isValidSerialization(x));
	}

	private static boolean isValidSerialization(String preorder) {
		if (preorder.length() == 0) {
			return false;
		}
		String[] nodes = preorder.split(",");
		LinkedList<String> list = new LinkedList<>();
		for (String node : nodes) {
			list.add(node);
			while ((list.size() >= 3)
					&& list.get(list.size() - 1).equals("#")
					&& list.get(list.size() - 2).equals("#")
					&& !list.get(list.size() - 3).equals("#")) {
				list.remove(list.size() - 1);
				list.remove(list.size() - 1);
				list.remove(list.size() - 1);
				list.add("#");
			}
		}

		return list.size() == 1 && list.get(0).equals("#");
	}
}
