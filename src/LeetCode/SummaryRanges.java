package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6};
		System.out.println(new SummaryRanges().summaryRanges(nums));
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		int start = -1, end = -1, i, prev = -1;
		for (i = 0; i < nums.length; i++) {
			if (i == 0) {
				start = nums[i];
				prev = nums[i];
			} else if (i == nums.length - 1) {
				if (nums[i] - prev == 1) {
					result.add(start + "->" + nums[i]);
				} else {
					result.add(start + "->" + end);
					result.add(String.valueOf(nums[i]));
				}
			} else {
				if (nums[i] - prev == 1) {
					end = nums[i];
				} else {
					if (end == -1) {
						result.add(String.valueOf(start));
					} else {
						result.add(start + "->" + prev);
					}
					end = -1;
					start = nums[i];
				}
				prev = nums[i];
			}
		}
		return result;
	}

	public List<String> summaryRanges1(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		int start, prev;

		return result;
	}
}
