/*
Given n and k, Construct a palindrome of size n using a binary number of size k repeating itself
to wrap into the palindrome.
The palindrome must always begin with 1 and contains maximum number of zeros.
https://www.geeksforgeeks.org/construct-binary-palindrome-by-repeated-appending-and-trimming/
 */

package DataStructures.Graphs.Traversals;

import java.util.ArrayList;

public class BinaryPalindrome {
	private static void DFS(int parent, int[] ans, ArrayList<ArrayList<Integer>> connectChars) {
		ans[parent] = 1; // Node marked
		for (int i = 0; i < connectChars.get(parent).size(); i++) {
			if (ans[connectChars.get(parent).get(i)] != 1) {
				DFS(connectChars.get(parent).get(i), ans, connectChars);
			}
		}
	}

	private static void generatePalindrome(int n, int k) {
		int[] ans = new int[n];
		int[] arr = new int[n];
		ArrayList<ArrayList<Integer>> connectChars = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			connectChars.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			arr[i] = i % k;
		}
		for (int i = 0; i < n / 2; i++) {
			connectChars.get(arr[i]).add(arr[n - i - 1]);
			connectChars.get(arr[n - i - 1]).add(arr[i]);
		}
		DFS(0, ans, connectChars);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[arr[i]]);
		}
	}

	public static void main(String[] args) {
		int n = 10, k = 4;
		generatePalindrome(n, k);
	}
}
