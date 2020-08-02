// https://leetcode.com/problems/palindrome-partitioning/

package DataStructures.Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
	public List<List<String>> result;

	public static void main(String[] args) {
		String x = "aab";
		System.out.println(new PalindromePartioning().partition(x));
	}

	public List<List<String>> partition(String x) {
		result = new ArrayList<>();
		if (x == null || x.length() == 0) {
			return result;
		}
		List<String> partition = new ArrayList<>();
		addPalindrome(x, 0, partition);
		return result;
	}

	public void addPalindrome(String x, int start, List<String> partition) {
		if (start == x.length()) {
			result.add(new ArrayList<>(partition));
		}

		for (int i = start + 1; i <= x.length(); i++) {
			String str = x.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(x, i, partition);
				partition.remove(partition.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String x) {
		int left = 0, right = x.length() - 1;
		while (left < right) {
			if (x.charAt(left) != x.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}