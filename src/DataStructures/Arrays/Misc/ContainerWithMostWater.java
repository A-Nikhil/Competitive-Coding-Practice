// https://leetcode.com/problems/container-with-most-water/

package DataStructures.Arrays.Misc;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] arr = {1, 8, 4, 5, 6, 7, 4};
		System.out.println(maxArea(arr));
	}

	private static int maxArea(int[] arr) {
		int max = 0, curr, left = 0, right = arr.length - 1;
		while (left <= right) {
			curr = Math.min(arr[left], arr[right]) * (left - right);
			max = Math.max(curr, max);
			if (arr[left] < arr[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
