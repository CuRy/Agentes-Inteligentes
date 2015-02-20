package Sudoku;

import Main.Solver;

public class SudokuSolver {

	public SudokuSolver() { super(); }
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver(3);
		solver.setOperators(new SudokuOperator(1,1,1).generateArgs());				
		SudokuState initial = new SudokuState();
			
		//solver.Solve(initial, Solver.SolveStrategy.DFS);
		solver.Solve(initial, Solver.SolveStrategy.BFS);
	}
}
