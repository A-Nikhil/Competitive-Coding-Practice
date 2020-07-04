package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MinCostToReachDestination {
	private static final int INF = 99999;

	public static void main(String[] args) {
		int[][] cost = {
				{0, 15, 80, 90},
				{INF, 0, 40, 50},
				{INF, INF, 0, 70},
				{INF, INF, INF, 0}
		};
		System.out.println(getMinCost(cost, cost.length));
	}

	private static int getMinCost(int[][] cost, int n) {
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (dist[j] > dist[i] + cost[i][j])
					dist[j] = dist[i] + cost[i][j];
			}
		}
		return dist[n - 1];
	}
}
