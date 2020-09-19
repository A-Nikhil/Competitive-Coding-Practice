package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
	public static void main(String[] args) {
//		int low = 100, high = 300;
		int low = 1000, high = 13000;
		System.out.println(new SequentialDigits().sequentialDigits(low, high));
	}

	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new ArrayList<>();
		StringBuilder temp;
		int lowLength = String.valueOf(low).length(),
				highLength = String.valueOf(high).length(),
				start, number;
		for (int i = lowLength; i <= highLength; i++) {
			for (int j = 1; j <= 9 - i + 1; j++) {
				start = j;
				temp = new StringBuilder();
				for (int k = 0; k < i; k++) {
					temp.append(start++);
				}
				number = Integer.parseInt(temp.toString());
				if (number >= low && number <= high) {
					result.add(number);
				}
			}
		}
		return result;
	}
}
