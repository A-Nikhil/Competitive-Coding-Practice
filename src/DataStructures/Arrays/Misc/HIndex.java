package DataStructures.Arrays.Misc;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(new HIndex().hIndex(citations));
	}

	public int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int max = 0;
		for (int i = 0; i < citations.length && citations[i] < citations.length; i++) {
			if (i >= citations.length - citations[i] &&
					i <= citations[i]) {
				max = Math.max(i, max);
			}
		}
		return max + 1;
	}
}
