package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ChainProblem {
	public static void main(String[] args) {
		int[][] arr = {
				{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}
		};
		System.out.println(chains(arr, arr.length));
	}

	private static int chains(int[][] arr, int n) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int[] i : arr) {
			map.put(i[0], i[1]);
		}
		Pair[] vals = new Pair[n];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			vals[index++] = new Pair(entry.getKey(), entry.getValue());
		}
		int max = 0;
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (vals[j].b < vals[i].a && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
			max = Math.max(lis[i], max);
		}
		return max;
	}

	static class Pair {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
