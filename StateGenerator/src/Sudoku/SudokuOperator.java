package Sudoku;

import Main.Operator;

public class SudokuOperator extends Operator {
	public Object[] args = {0, 0, 0};
	
	public SudokuOperator(int x, int y, int n) {
		args[0] = x;
		args [1] = y;
		args[2] = n;
	}
}
