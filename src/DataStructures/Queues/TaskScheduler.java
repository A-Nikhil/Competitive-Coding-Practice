package DataStructures.Queues;

import java.util.Arrays;

public class TaskScheduler {
	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
//		char[] tasks = {'A', 'A', 'B', 'B', 'B', 'A'};
		int n = 2;
		System.out.println(getTime(tasks, n));
	}

	private static int getTime(char[] tasks, int n) {
		if (n == 0) {
			return tasks.length;
		}
		int[] count = new int[26];
		for (char c : tasks) {
			count[c - 'A']++;
		}
		int intervals = 0, i, index;
		Arrays.sort(count);
		while (count[25] > 0) {
			for (i = 0; i <= n; i++) {
				intervals++;
				if (i > 25) {
					continue;
				}
				index = 25 - i;
				if (count[index] > 0) {
					count[index]--;
				}
				if (count[index] == 0 && count[25] == 0) {
					break;
				}
			}
			Arrays.sort(count);
		}
		return intervals;
	}
}
