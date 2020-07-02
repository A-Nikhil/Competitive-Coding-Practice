package DataStructures.Stacks;

@SuppressWarnings("Duplicates")
public class GameOfTwoStacks {
	public static void main(String[] args) {
		int[] a = {4, 2, 4, 6, 1};
		int[] b = {2, 1, 8, 5};
		int x = 10;
		System.out.println(twoStacks(x, a, b));
	}

	static int twoStacks(int x, int[] a, int[] b) {
		int ai = 0, bi = 0;
		int sum = 0, count = 0;
		while (sum <= x) {
			if (a[ai] <= (x - sum) && b[bi] <= (x - sum)) {
				if (a[ai] < b[bi]) {
					if (a[ai] <= (x - sum)) {
						sum += a[ai];
						ai++;
						count++;
					} else if (b[bi] <= (x - sum)) {
						sum += b[bi];
						bi++;
						count++;
					} else {
						break;
					}
				} else {
					if (b[bi] <= (x - sum)) {
						sum += b[bi];
						bi++;
						count++;
					} else if (a[ai] <= (x - sum)) {
						sum += a[ai];
						ai++;
						count++;
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		return count;
	}
}
