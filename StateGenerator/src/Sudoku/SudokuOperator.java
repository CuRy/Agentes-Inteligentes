package Sudoku;

import java.util.Arrays;

import Main.Operator;

public class SudokuOperator extends Operator {
	
	public SudokuOperator(int x, int y, int n) {
		this.Arguments = new Object[3];
		this.Arguments[0] = x;
		this.Arguments[1] = y;
		this.Arguments[2] = n;
	}

	@Override
	public Operator[] generateArgs() {
		Operator[] os = new Operator[9*9*9];
		Operator o;
		int count = 0;
		for (int i = 0; i < 9; i++) {
			for (int j= 0;  j< 9; j++) {
				for (int k = 1; k <= 9; k++) {
					o = new SudokuOperator(i, j, k);
					os[count++] = o;
				}
			}
		}
		System.out.println(Arrays.toString(os));
		return os;
	}
	
}
