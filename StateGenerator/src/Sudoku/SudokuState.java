package Sudoku;

import EightPuzzle.EightPuzzleState;
import Main.State;
import Main.Utils;

public class SudokuState extends State {
	private static int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
	
	public SudokuState() {super();}
	
	public SudokuState(SudokuState state) {
		super();
		this.board = Utils.copyMatrix(state.board);
	}
	
	public SudokuState(int[][] board) {
		super();
		this.board = board;
	}
	
	public boolean update(int x, int y, int n) {
		if (Validator.isValid(x, y, n)) {
			board[x][y] = n;
			return true;
		}
		return false;
	}
	
	private static class Validator {
		static int row;
		static int col;
		static int n;
		
		public static boolean isValid(int x, int y, int n) {
			return checkRow() && checkCol() && checkSquare() && checkNum();
		}
		
		private static boolean checkRow() {
			for (int i = 0; i < 9; i++)
				if (board[row][i] == n)
					return false;
		
			return true;
		}
		
		private static boolean checkCol() {
			for (int i = 0; i < 9; i++)
				if (board[i][col] == n)
					return false;
		
			return true;
		}
		
		private static boolean checkSquare() {
			int drow = (row/3) * 3;
			int dcol = (col/3) * 3;
			
			for (int i = drow; i < (drow + 3); i++) {
				for (int j = dcol; j < (dcol + 3); j++) {
					if(board[i][j] == n) 
						return false;
				}
			}
			return true;
		}
		
		private static boolean checkNum() {
			return board[row][col] == 0 && n > 0 && n <= 9;
		}
	}
	
		

	@Override
	public State apply(char op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
