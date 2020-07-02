/*
Sum of nodes at k-th level in a tree represented as string
Given an integer ‘K’ and a binary tree in string format.
Every node of a tree has value in range from 0 to 9. We need to find sum of elements
at K-th level from root. The root is at level 0.
Tree is given in the form: (node value(left subtree)(right subtree))

1. Input 'tree' in string format and level k
2. Initialize level = -1 and sum = 0
3. for each character 'ch' in 'tree'
   3.1  if ch == '(' then
        --> level++
   3.2  else if ch == ')' then
        --> level--
   3.3  else
        if level == k then
           sum = sum + (ch-'0')
4. Print sum

https://www.geeksforgeeks.org/sum-nodes-k-th-level-tree-represented-string/
 */

package DataStructures.BinaryTree.Summation;

public class SumOfRootsAtALevel {
	public static void main(String[] args) {
		String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
		int k = 2;
		System.out.println(getSum(tree, k));
	}

	private static int getSum(String tree, int k) {
		int sum = 0, level = -1;
		for (int i = 0; i < tree.length(); i++) {
			if (tree.charAt(i) == '(') {
				level++;
			} else if (tree.charAt(i) == ')') {
				level--;
			} else {
				if (level == k) {
					sum += tree.charAt(i) - '0';
				}
			}
		}
		return sum;
	}
}
