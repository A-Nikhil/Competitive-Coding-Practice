package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class WeightedJobScheduling {
	public static void main(String[] args) {
		Job[] jobs = {
				new Job(1, 2, 50),
				new Job(3, 5, 20),
				new Job(6, 19, 100),
				new Job(2, 100, 200)
		};
		System.out.println(getMaxProfit(jobs, jobs.length));
	}

	private static int getMaxProfit(Job[] jobs, int n) {
		Arrays.sort(jobs);
		int[] table = new int[n];
		table[0] = jobs[0].profit;
		int inclProfit, l;
		for (int i = 1; i < n; i++) {
			inclProfit = jobs[i].profit;
			l = findNonConflict(jobs, i);
			if (l != -1) {
				inclProfit += table[l];
			}
			table[i] = Math.max(inclProfit, table[i - 1]);
		}
		return table[n - 1];
	}

	private static int findNonConflict(Job[] jobs, int i) {
		int l = 0, h = i - 1, mid;
		while (l <= h) {
			mid = (l + h) / 2;
			if (jobs[mid].finish <= jobs[i].start) {
				if (jobs[mid + 1].finish <= jobs[i].start) {
					l = mid + 1;
				} else {
					return mid;
				}
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

	static class Job implements Comparable<Job> {
		int start, finish, profit;

		public Job(int start, int finish, int profit) {
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}

		@Override
		public int compareTo(Job o) {
			return this.finish - o.finish;
		}
	}
}
