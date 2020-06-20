/*
Calculating the diameter of the tree

The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
The diagram below shows two trees each with diameter nine, the leaves that form the
ends of the longest path are colored (note that there may be more than one path in the
tree of the same diameter).

Input :     1
          /   \
        2      3
      /  \
    4     5

Output : 4

Input :     1
          /   \
        2      3
      /  \ .    \
    4     5 .    6

Output : 5

Approach =>
In this post a new simple O(n) method is discussed. Diameter of a tree can be calculated
by only using the height function, because the diameter of a tree is nothing but
maximum value of (left_height + right_height + 1) for each node.
So we need to calculate this value (left_height + right_height + 1) for each node and update the result.
Time complexity – O(n)
*/

package binaryTree.traversals;

public class DiameterOfATree {
}
