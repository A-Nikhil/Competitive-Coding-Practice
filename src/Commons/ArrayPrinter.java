package Commons;

public class ArrayPrinter {
	public void printArray(int[] arr) {
		printArray(arr, arr.length);
	}

	public void printArray(int[] arr, int end) {
		for (int i = 0; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void printArray(double[] arr) {
		for (double v : arr) {
			System.out.print(v + " ");
		}
	}

	public void printArray(int[] arr, int start, int end) {
		for (int i = start; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void printArray(String[] arr) {
		for (String s : arr) {
			System.out.print(s + " ");
		}
	}

	public void printArray(boolean[] arr, int end) {
		for (int i = 0; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
