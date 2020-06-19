/*
Check whether a given binary tree is perfect or not

A Binary tree is Perfect Binary Tree in which all internal nodes have two children and
all leaves are at same level.

			   10
           /       \
         20         30
        /  \        /  \
      40    50    60   70

Below is an idea to check whether a given Binary Tree is perfect or not.

Find depth of any node (in below tree we find depth of leftmost node). Let this depth be d.
Now recursively traverse the tree and check for following two conditions.
	Every internal node should have both children non-empty
	All leaves are at depth ‘d’

https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
 */

package binaryTree.checkingAndPrinting;

public class PerfectBinaryTree {

}
