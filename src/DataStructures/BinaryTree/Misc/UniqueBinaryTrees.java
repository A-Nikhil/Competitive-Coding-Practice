// Question => https://leetcode.com/problems/unique-binary-search-trees/
/*
Analysis

i=0, count[0]=1 //empty tree

i=1, count[1]=1 //one tree

i=2, count[2]=count[0]*count[1] // 0 is root
            + count[1]*count[0] // 1 is root

i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root

i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root
..
..
..

i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1

 */

package DataStructures.BinaryTree.Misc;

public class UniqueBinaryTrees {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(uniqueBSTs(n));
	}

	private static int uniqueBSTs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i] = dp[i] + (dp[j] * dp[i - 1 - j]);
			}
		}
		return dp[n];
	}
}
