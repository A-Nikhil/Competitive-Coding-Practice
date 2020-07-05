package DataStructures.Arrays;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(arr));
	}

	private static int maxArea(int[] arr) {
		int l = 0, h = arr.length - 1;
		int area, maxArea = 0;
		while (l < h) {
			area = Math.min(arr[l], arr[h]) * (h - l);
			maxArea = Math.max(area, maxArea);
			if (l + 1 < h && arr[l + 1] > arr[l]) {
				l++;
			}
			if (h - 1 > l && arr[h - 1] > arr[h]) {
				h--;
			}
			if (l == h - 1) {
				break;
			}
		}
		return maxArea;
	}
}
