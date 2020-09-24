package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3, 3, 3};
		System.out.println(new MajorityElement2().majorityElement(nums));
	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int temp1 = 0, temp2 = 0, counter1 = 0, counter2 = 0;
		for (int num : nums) {
			if (num == temp1) {
				counter1++;
			} else if (num == temp2) {
				counter2++;
			} else if (counter1 == 0) {
				temp1 = num;
				counter1 = 1;
			} else if (counter2 == 0) {
				temp2 = num;
				counter2 = 1;
			} else {
				counter1--;
				counter2--;
			}
		}
		counter1 = counter2 = 0;
		for (int num : nums) {
			if (num == temp1) {
				counter1++;
			} else if (num == temp2) {
				counter2++;
			}
		}

		if (counter1 > nums.length / 3) {
			result.add(temp1);
		}
		if (counter2 > nums.length / 3) {
			result.add(temp2);
		}
		return result;
	}
}
