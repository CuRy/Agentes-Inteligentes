package EightPuzzle;

import Main.Solver;

public class EightPuzzleSolver {
	
	public EightPuzzleSolver() { super(); }
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver(3);
		EightPuzzleOperator[] operators = 
			{ new EightPuzzleOperator(1, 0), // LEFT
				new EightPuzzleOperator(-1, 0), // RIGHT
				new EightPuzzleOperator(0, 1), // UP
				new EightPuzzleOperator(0, -1) }; // DOWN
		solver.setOperators(operators);		
		
		//EightPuzzleState initial = new EightPuzzleState(new int[][] {{6, 1, 8}, {7, 5, 3}, {2, 0, 4}}, 1, 2);
		EightPuzzleState initial = new EightPuzzleState(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}}, 1, 2);
		
		solver.Solve(initial, Solver.SolveStrategy.DFS);

	}
}
