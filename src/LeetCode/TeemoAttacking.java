package LeetCode;

public class TeemoAttacking {
	public static void main(String[] args) {
//		int[] timeSeries = {1, 2};
		int[] timeSeries = {1, 4, 5};
		int duration = 2;
		System.out.println(new TeemoAttacking().findPoisonedDuration(timeSeries, duration));
	}

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (duration == 0 || timeSeries.length == 0) {
			return 0;
		}
		int poisoned = 0;
		for (int i = 0; i < timeSeries.length - 1; i++) {
			if (timeSeries[i] + duration <= timeSeries[i + 1]) {
				poisoned += duration;
			} else {
				poisoned += timeSeries[i + 1] - timeSeries[i];
			}
		}
		return poisoned + duration;
	}
}
