// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

package Algorithms.BitMagic;

public class MinimumFlipsTOMake_A_OR_B_to_C {
	public static void main(String[] args) {
		// int x = 2, y = 6, z = 5;
		int x = 1, y = 2, z = 3;
		// int x = 8, y = 3, z = 5;
		int ans = new MinimumFlipsTOMake_A_OR_B_to_C().minFlips(x, y, z);
		System.out.println(ans);
	}

	public int minFlips(int x, int y, int z) {
		int flips = 0;
		String a = getBinary(x);
		String b = getBinary(y);
		String c = getBinary(z);
		// System.out.printf("a = %s, b = %s, c = %s", a, b, c);
		// System.exit(248);
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int cIndex = c.length() - 1;
		int b1, b2, b3;
		int maxLength = Math.max(a.length(), Math.max(b.length(), c.length())) - 1;
		for (int i = maxLength; i >= 0; i--) {
			b1 = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
			b2 = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;
			b3 = cIndex >= 0 ? c.charAt(cIndex) - '0' : 0;
			// System.out.printf("At index %d, b1 = %d and b2 = %d\n", i, b1, b2);
			if ((b3) != (b1 | b2)) {
				if (b3 == 0) {
					if (b1 == 1) {
						flips++;
					}
					if (b2 == 1) {
						flips++;
					}
				} else {
					if (b1 == 0) {
						flips++;
					} else if (b2 == 0) {
						flips++;
					}
				}
			}
			aIndex--;
			bIndex--;
			cIndex--;
		}
		return flips;
	}

	public String getBinary(int n) {
		String bin = "";
		while (n > 0) {
			bin = (n % 2) + bin;
			n = n / 2;
		}
		return bin;
	}
}