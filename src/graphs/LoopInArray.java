package graphs;

public class LoopInArray {
	public static void main(String[] args) {
		int[] arr = { 2, -1, 1, 2, 2 };
		int n = arr.length;
		System.out.println(checkForLoops(arr, n));
	}

	private static boolean checkForLoops(int[] arr, int n) {
		boolean[] visited = new boolean[n];
		boolean[] recursive = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (LoopRecursive(arr, n, i, visited, recursive)) {
				return true;
			}
		}
		return false;
	}

	private static boolean LoopRecursive(int[] arr, int n, int current,
										 boolean[] visited, boolean[] recursive) {
		visited[current] = true;
		recursive[current] = true;
		int next;
		if (arr[current] < 0) {
			next = ((current + arr[current]) % n);
		} else {
			next = ((current + arr[current] + n) % n);
		}
		if (next == 0 || recursive[next]) {
			return false;
		}
		if (!visited[next]) {
			if (LoopRecursive(arr, n, next, visited, recursive)) {
				return true;
			}
		} else if (visited[next] && recursive[next]) {
			return true;
		}
		recursive[current] = false;
		return false;
	}
}
