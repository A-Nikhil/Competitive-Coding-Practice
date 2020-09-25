package LeetCode;

import java.util.Arrays;

public class LargestNumber {
	public static void main(String[] args) {
		int[] nums = {10, 2};
		System.out.println(new LargestNumber().largestNumber(nums));
	}

	public String largestNumber(int[] nums) {
		String[] combos = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			combos[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(combos, (o1, o2) -> {
			String s1 = o1 + o2;
			String s2 = o2 + o1;
			return s2.compareTo(s1);
		});
		if ("0".equals(combos[0])) {
			return combos[0];
		}
		StringBuilder sb = new StringBuilder();
		for (String str : combos) {
			sb.append(str);
		}
		return sb.toString();
	}
}
