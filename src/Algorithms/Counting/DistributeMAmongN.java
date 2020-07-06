package Algorithms.Counting;

public class DistributeMAmongN {
	public static void main(String[] args) {
		int n = 2, m = 3;
		distribute(n, m);
	}

	private static void distribute(int n, int m) {
		// (n+m-1)C(n-1)
		System.out.println("m identical mangoes amongst n identical people => "
				+ binomialCoefficient(n + m - 1, n - 1));
	}

	private static int binomialCoefficient(int n, int m) {
		int res = 1;
		if (m > n - m) {
			m = n - m;
		}
		for (int i = 0; i < m; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}
}
