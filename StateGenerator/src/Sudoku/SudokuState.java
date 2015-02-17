package Sudoku;

import Main.Operator;
import Main.State;
import Main.Utils;

public class SudokuState extends State {
	private int[][] board = {
		      { 0, 8, 0, 4, 0, 2, 0, 6, 0 },
		      { 0, 3, 4, 0, 0, 0, 9, 1, 0 },
		      { 9, 6, 0, 0, 0, 0, 0, 8, 4 },
		      { 0, 0, 0, 2, 1, 6, 0, 0, 0 },
		      { 2, 0, 0, 0, 0, 9, 6, 0, 0 },
		      { 0, 1, 0, 3, 5, 7, 0, 0, 8 },
		      { 8, 4, 0, 0, 0, 0, 0, 7, 5 },
		      { 0, 2, 6, 0, 0, 0, 1, 3, 0 },
		      { 0, 9, 0, 7, 0, 1, 0, 4, 0 }
		    };
	
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
		boolean valid = (new Validator()).isValid(x, y, n);
		if (valid)	
			board[x][y] = n;
		
		return valid;
	}
	
	private class Validator {
		private int row;
		private int col;
		private int n;
		
		public boolean isValid(int x, int y, int n) {
			return checkRow() && checkCol() && checkSquare() && checkNum();
		}
		
		private boolean checkRow() {
			for (int i = 0; i < 9; i++)
				if (board[row][i] == n)
					return false;
		
			return true;
		}
		
		private boolean checkCol() {
			for (int i = 0; i < 9; i++)
				if (board[i][col] == n)
					return false;
		
			return true;
		}
		
		private boolean checkSquare() {
			int drow = (row/3) * 3;
			int dcol = (col/3) * 3;
			
			for (int i = drow; i < (drow + 3); i++)
				for (int j = dcol; j < (dcol + 3); j++) 
					if(board[i][j] == n) 
						return false;
			
			return true;
		}
		
		private boolean checkNum() {
			return board[row][col] == 0 && n > 0 && n <= 9;
		}
	}	
		

	@Override
	public State apply(Operator op) {
		if (!(op instanceof SudokuOperator)) return null;
		
		Integer[] args = (Integer[]) op.args;
		SudokuState state = new SudokuState(this);
		
		return state.update(args[0], args[1], args[2])? state: null;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				s += board[i][j] + " ";			
			s += "\n";
		}
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SudokuState))
			return false;
		
		SudokuState state = (SudokuState)obj;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (this.board[i][j] != state.board[i][j])
					return false;
		
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SudokuState newState = new SudokuState(this);
		return newState;
	}
	

}
