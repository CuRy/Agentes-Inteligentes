package Sudoku;

import Main.Operator;
import Main.State;
import Main.Utils;

public class SudokuState extends State {
	private int[][] board = {
		      { 0, 7, 8,	1, 4, 5,	6, 2, 9 },
		      { 1, 4, 9,	8, 6, 2,	7, 5, 3 },
		      { 5, 2, 6,	3, 9, 7,	1, 4, 8 },
		      
		      { 8, 3, 5,	9, 2, 1,	4, 7, 6 },
		      { 2, 6, 1,	4, 7, 3,	8, 9, 5 },
		      { 7, 9, 4,	6, 5, 8,	3, 1, 2 },
		      
		      { 9, 8, 3,	5, 1, 4,	2, 6, 7 },
		      { 6, 1, 7,	2, 8, 9,	5, 3, 4 },
		      { 4, 5, 2,	7, 3, 6,	9, 8, 1 }
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
			this.row = y;
			this.col = x;
			this.n = n;
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
		
		Object[] args = op.Arguments;
		SudokuState state = new SudokuState(this);
		return state.update((int)args[0], (int)args[1], (int)args[2])? state: null;
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

	@Override
	protected boolean isFinal() {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) 
				if (board[i][j] == 0)
					return false;
			
		return true;
	}
	

}
