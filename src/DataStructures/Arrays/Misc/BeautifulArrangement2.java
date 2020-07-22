// https://leetcode.com/problems/beautiful-arrangement-ii/

/*
Explanation =>
if you have n number, the maximum k can be n - 1;
if n is 9, max k is 8.
This can be done by picking numbers interleaving-ly from head and tail,

// start from i = 1, j = n;
// i++, j--, i++, j--, i++, j--

i: 1   2   3   4   5
j:   9   8   7   6
out: 1 9 2 8 3 7 4 6 5
dif:  8 7 6 5 4 3 2 1
Above is a case where k is exactly n - 1
When k is less than that, simply lay out the rest (i, j) in incremental
order(all diff is 1). Say if k is 5:

     i++ j-- i++ j--  i++ i++ i++ ...
out: 1   9   2   8    3   4   5   6   7
dif:   8   7   6   5    1   1   1   1
 */

package DataStructures.Arrays.Misc;

import Commons.ArrayPrinter;

public class BeautifulArrangement2 {
	public static void main(String[] args) {
		int n = 3, k = 2;
		new ArrayPrinter().printArray(getArrangement(n, k));
	}

	private static int[] getArrangement(int n, int k) {
		int l = 1, r = n, index = 0;
		int[] res = new int[n];
		while (l <= r) {
			if (k > 1) {
				res[index++] = k % 2 == 0 ? r-- : l++;
				k--;
			} else {
				res[index++] = l++;
			}
		}
		return res;
	}
}
