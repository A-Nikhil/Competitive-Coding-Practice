package DataStructures.Arrays.Matrices;

import java.util.HashSet;

public class ValidSudoku {
	HashSet<Character> set;

	public static void main(String[] args) {
		char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

		System.out.println(new ValidSudoku().isValidSudoku(board));
	}

	public boolean isValidSudoku(char[][] board) {
		if (board.length == 0) {
			return false;
		}
		set = new HashSet<>();
		int[][] startPoints = {{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3},
				{6, 6}};
		for (int[] arr : startPoints) {
			if (!checkGrids(board, arr[0], arr[1])) {
				return false;
			}
		}
		boolean rows = checkRows(board);
		boolean cols = checkColumns(board);
		return rows && cols;
	}

	public boolean checkGrids(char[][] board, int startRow, int startCol) {
		set.clear();
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
		}
		return true;
	}

	public boolean checkRows(char[][] board) {
		for (int i = 0; i < 9; i++) {
			set.clear();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
		}
		return true;
	}

	public boolean checkColumns(char[][] board) {
		for (int i = 0; i < 9; i++) {
			set.clear();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (set.contains(board[j][i])) {
						return false;
					} else {
						set.add(board[j][i]);
					}
				}
			}
		}
		return true;
	}
}