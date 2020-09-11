package Algorithms.BitMagic;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
	public static void main(String[] args) {
		int n = 30;
		new GenerateBinaryNumbers().generatePrintBinary(n);
	}

	public void generatePrintBinary(int n) {
		Queue<String> q = new LinkedList<>();
		q.add("1");
		while (n-- > 0) {
			String s1 = q.poll();
			System.out.print(s1 + " ");
			q.add(s1 + "0");
			q.add(s1 + "1");
		}
	}
}
