package DataStructures.Arrays.Misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangleAtK {
	public static void main(String[] args) {
		int k = 0;
		System.out.println(new PascalTriangleAtK().getRow(k));
	}

	public List<Integer> getRow(int k) {
		List<Integer> result;
		int[] arr = new int[k + 1];
		int[] prev = new int[k + 1];
		arr[0] = 1;
		for (int i = 1; i <= k; i++) {
			System.arraycopy(arr, 0, prev, 0, i);
			for (int j = 0; j < i + 1; j++) {
				arr[j] = j - 1 < 0 ? 0 : prev[j - 1];
				arr[j] += prev[j];
			}
		}
		result = Arrays.stream(arr).boxed().collect(Collectors.toList());
		return result;
	}
}
