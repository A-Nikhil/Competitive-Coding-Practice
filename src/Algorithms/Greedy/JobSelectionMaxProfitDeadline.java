package Algorithms.Greedy;

import java.util.Arrays;

public class JobSelectionMaxProfitDeadline {
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 100}, {2, 1, 19}, {3, 2, 27},
				{4, 1, 25}, {5, 3, 15}};
		doJobs(arr, arr.length);
	}

	private static void doJobs(int[][] jobList, int n) {
		int i;
		Job[] jobs = new Job[n];
		for (i = 0; i < n; i++) {
			jobs[i] = new Job(jobList[i][0], jobList[i][1], jobList[i][2]);
		}
		int[] result = new int[n];
		boolean[] slot = new boolean[n];
		Arrays.sort(jobs);

		for (i = 0; i < n; i++) { // for all jobs
			for (int j = Math.min(n, jobs[i].dead) - 1;
				 j >= 0; j--) { // assign the farthest slot
				if (!slot[j]) {
					slot[j] = true;
					result[j] = i; // farthest slot is assigned.. now check for another
					break;
				}
			}
		}

		int maxProfit = 0;
		System.out.print("Job Sequence => ");
		for (i = 0; i < n; i++) {
			if (slot[i]) {
				System.out.print(jobs[result[i]].id + " ");
				maxProfit += jobs[result[i]].profit;
			}
		}
		System.out.print("\nMaximum Profit = " + maxProfit);
	}

	static class Job implements Comparable<Job> {
		int id, dead, profit;

		public Job(int id, int dead, int profit) {
			this.id = id;
			this.dead = dead;
			this.profit = profit;
		}

		@Override
		public int compareTo(Job o) {
			return o.profit - this.profit;
		}
	}
}
