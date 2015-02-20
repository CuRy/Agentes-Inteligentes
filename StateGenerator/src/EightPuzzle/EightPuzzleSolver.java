package EightPuzzle;

import Main.Solver;
import Main.Generator.HeuristicStrategy;
import Main.Solver.SolveStrategy;

public class EightPuzzleSolver {
	
	public EightPuzzleSolver() { super(); }
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver(3);
		EightPuzzleOperator[] operators = 
			{ new EightPuzzleOperator(1, 0, "LEFT"), // LEFT
				new EightPuzzleOperator(-1, 0, "RIGHT"), // RIGHT
				new EightPuzzleOperator(0, 1, "UP"), // UP
				new EightPuzzleOperator(0, -1, "DOWN") }; // DOWN
		solver.setOperators(operators);
		
		EightPuzzleState initial = new EightPuzzleState(new int[][] {{6, 1, 8}, {7, 5, 3}, {2, 0, 4}}, 1, 2);
		
		solver.Solve(initial, SolveStrategy.BFS, HeuristicStrategy.NONE);
	}
}
