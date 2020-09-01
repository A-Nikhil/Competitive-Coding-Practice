package Algorithms.Math;

import Commons.ArrayPrinter;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifference {
	public List<Integer> numbers;

	public static void main(String[] args) {
		int N = 3, K = 7;
		new ArrayPrinter().printArray(new NumbersWithSameConsecutiveDifference().numsSameConsecDiff(N, K));
	}

	public int[] numsSameConsecDiff(int N, int K) {
		if (N == 0) {
			return new int[0];
		}
		numbers = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			constructNumbers(i, N - 1, K, i);
		}
		int[] res_ = new int[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			res_[i] = numbers.get(i);
		}
		return res_;
	}

	private void constructNumbers(int digit, int n, int K, int number) {
		if (n == 0) {
			if (!numbers.contains(number)) {
				numbers.add(number);
			}
			return;
		}

		int increment = digit + K;
		if (increment < 10) {
			constructNumbers(increment, n - 1, K, number * 10 + increment);
		}
		int decrement = digit - K;
		if (decrement >= 0) {
			constructNumbers(decrement, n - 1, K, number * 10 + decrement);
		}
	}
}
