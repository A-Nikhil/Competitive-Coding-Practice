package DataStructures.Arrays.OrderStatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MajorityElement {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		String[] arr;
// 		HashMap<Integer, Integer> map = new HasMap<>();
		int count, n;
		boolean found;
		for (int x = 0; x < tc; x++) {
			count = 1;
			found = false;
			n = Integer.parseInt(in.readLine());
			arr = in.readLine().split(" ");
			Arrays.sort(arr);
			for (int i = 0; i < n - 1; i++) {
				if (arr[i].equals(arr[i + 1])) {
					count++;
				} else {
					count = 1;
				}
				if (count > n / 2) {
					System.out.println(arr[i]);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println(-1);
			}
		}
	}
}