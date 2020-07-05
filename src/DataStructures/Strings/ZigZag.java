// https://leetcode.com/problems/zigzag-conversion/

package DataStructures.Strings;

public class ZigZag {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 2;
		System.out.println(convert(s, numRows));
	}

	private static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		if (numRows == 2) {
			String odd = "", even = "";
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					even += s.charAt(i);
				} else {
					odd += s.charAt(i);
				}
			}
			return even.concat(odd);
		}
		int[][] rows = new int[numRows][s.length()];
		int i = 0, j = 0;
		boolean goDown = true;
		for (int x = 0; x < s.length(); x++) {
			rows[i][j] = s.charAt(x);
			if (goDown) {
				i++;
			} else {
				i--;
				j++;
			}
			if (i == 0) {
				goDown = true;
			}
			if (i == numRows) {
				goDown = false;
				i -= 2;
				j++;
			}
		}
		int col = j;
		String str = "";
		for (i = 0; i < numRows; i++) {
			for (j = 0; j <= col; j++) {
				if (rows[i][j] != 0) {
					str += ((char) rows[i][j]);
				}
			}
		}
		return str;
	}
}
