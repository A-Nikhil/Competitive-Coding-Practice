package DataStructures.Arrays.OrderStatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class MaxOfEveryWindowK {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		String[] elems;
		int[] arr;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int x = 0; x < tc; x++) {
			int n, k, i;
			elems = in.readLine().split(" ");
			n = Integer.parseInt(elems[0]);
			k = Integer.parseInt(elems[1]);
			arr = new int[n];
			elems = in.readLine().split(" ");
			for (i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(elems[i]);
			}
			for (i = 0; i < k; i++) {
				while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
					dq.pollLast();
				}
				dq.add(i);
			}

			for (; i < n; i++) {
				System.out.print(arr[dq.peek()] + " ");
				while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
					dq.removeFirst();
				}
				while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
					dq.pollLast();
				}
				dq.add(i);
			}
			System.out.println(arr[dq.peek()]);
			dq.clear();
		}
	}
}
