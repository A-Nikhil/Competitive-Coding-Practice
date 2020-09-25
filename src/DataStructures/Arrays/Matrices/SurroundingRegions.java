package DataStructures.Arrays.Matrices;

public class SurroundingRegions {
	public int[] dx = {1, -1, 0, 0};
	public int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) {

	}

	public void solve(char[][] board) {
		int m = board.length;
		if (m == 0) {
			return;
		}
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				_merge(board, i, 0);
			}
			if (board[i][n - 1] == 'O') {
				_merge(board, i, n - 1);
			}
		}

		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				_merge(board, 0, j);
			}
			if (board[m - 1][j] == 'O') {
				_merge(board, m - 1, j);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void _merge(char[][] board, int i, int j) {
		board[i][j] = '#';
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (isValid(x, y, board.length, board[0].length) && board[x][y] == 'O') {
				_merge(board, x, y);
			}
		}
	}

	public boolean isValid(int x, int y, int m, int n) {
		return ((x >= 0) && (y >= 0) && (x < m) && (y < n));
	}
}
