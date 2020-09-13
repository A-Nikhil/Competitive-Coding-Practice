package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
		int[] newInterval = {4, 8};
		System.out.print("[");
		for (int[] interval : new InsertInterval().insert(intervals, newInterval)) {
			System.out.printf("[%d, %d], ", interval[0], interval[1]);
		}
		System.out.println("]");
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();

		int i = 0;
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i++]);
		}

		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			i++;
		}

		result.add(newInterval);

		while (i < intervals.length) {
			result.add(intervals[i++]);
		}

		return result.toArray(new int[result.size()][]);
	}
}
