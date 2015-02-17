package Sudoku;

import Main.Solver;

public class SudokuSolver {

	public SudokuSolver() { super(); }
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver(3);
		SudokuOperator[] operators = {};
		solver.setOperators(operators);				
		SudokuState initial = new SudokuState();
		
		SudokuState goal = new SudokuState();
//		goal = (SudokuState) goal.apply(operators[3]);
//		goal = (SudokuState) goal.apply(operators[1]);
//		goal = (SudokuState) goal.apply(operators[3]);
//		goal = (SudokuState) goal.apply(operators[1]);
//		goal = (SudokuState) goal.apply(operators[2]);
//		goal = (SudokuState) goal.apply(operators[0]);
			
		// solver.Solve(initial, goal, Solver.SolveStrategy.DFS);
		solver.Solve(initial, goal, Solver.SolveStrategy.BFS);
	}
}
