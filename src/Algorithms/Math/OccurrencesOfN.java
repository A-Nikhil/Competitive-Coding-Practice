/*
Given a number N, find it's occurrences in the range [l, r]
Eg. 3 in [1, 30] => 3, 13, 23, 30 = 4
 */

package Algorithms.Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OccurrencesOfN {
	public static void main(String[] args) {
		int l = 1, r = 40, n = 3;
		System.out.println(new OccurrencesOfN().occurrences(n, l, r));
	}

	public int occurrences(int n, int l, int r) {
		String number = String.valueOf(n), current;
		int count = 0;
		Pattern pattern = Pattern.compile(number);
		Matcher matcher;
		for (int i = l; i <= r; i++) {
			current = String.valueOf(i);
			matcher = pattern.matcher(current);
			while (matcher.find()) {
				count++;
			}
		}
		return count;
	}
}
