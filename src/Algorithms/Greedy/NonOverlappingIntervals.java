package Algorithms.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(input));
	}

	public int eraseOverlapIntervals(int[][] input) {
		if (input.length == 0) {
			return 0;
		}
		List<Intervals> intervals = new ArrayList<>();
		for (int[] ints : input) {
			intervals.add(new Intervals(ints[0], ints[1]));
		}
		int counter = 0;
		Collections.sort(intervals);
		for (int i = 0; i < intervals.size(); i++) {
			for (int j = i + 1; j < intervals.size(); j++) {
				if (intervals.get(j).start < intervals.get(i).end) {
					intervals.remove(j);
					counter++;
				}
			}
		}
		return counter;
	}

	private static class Intervals implements Comparable<Intervals> {
		int start, end;

		Intervals(int x, int y) {
			start = x;
			end = y;
		}

		@Override
		public int compareTo(Intervals i) {
			return Integer.compare(this.end, i.end);
		}
	}
}
