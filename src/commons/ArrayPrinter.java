package commons;

public class ArrayPrinter<T> {
	public void printArray(T[] arr, int end) {
		for (int i=0; i<end; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
