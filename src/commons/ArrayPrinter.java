package commons;

public class ArrayPrinter {
	public void printArray(int[] arr, int end) {
		for (int i=0; i<end; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void printArray(String[] arr, int end) {
		for (int i=0; i<end; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void printArray(boolean[] arr, int end) {
		for (int i=0; i<end; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
