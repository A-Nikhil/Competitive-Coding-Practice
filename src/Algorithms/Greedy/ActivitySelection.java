package Algorithms.Greedy;

import java.util.Arrays;

public class ActivitySelection {
	public static void main(String[] args) {
		int[] s = {1, 3, 0, 5, 8, 5};
		int[] f = {2, 4, 6, 7, 9, 9};
		int[][] arr = new int[s.length][s.length];
		for (int i = 0; i < s.length; i++) {
			arr[i][0] = s[i];
			arr[i][1] = f[i];
		}
		printJobs(arr, s.length);
	}

	private static void printJobs(int[][] arr, int n) {
		Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(arr[i][0], arr[i][1], i + 1);
		}
		Arrays.sort(jobs);
		int[] result = new int[n];
		result[0] = jobs[0].id;
		int i = 0, index = 1;
		for (int j = 1; j < n; j++) {
			if (jobs[j].start >= jobs[i].finish) {
				i = j;
				result[index++] = jobs[j].id;
			}
		}

		System.out.println("Total Number of Jobs done = " + index);
		System.out.print("Jobs Done => ");
		for (i = 0; i < index; i++) {
			System.out.print(result[i] + " ");
		}
	}

	static class Job implements Comparable<Job> {
		int start, finish, id;

		public Job(int start, int finish, int id) {
			this.start = start;
			this.finish = finish;
			this.id = id;
		}

		@Override
		public int compareTo(Job j) {
			return this.finish - j.finish; // this - o => Ascending
		}
	}
}
