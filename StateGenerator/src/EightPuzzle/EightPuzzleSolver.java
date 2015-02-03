package EightPuzzle;

import java.util.ArrayList;

import Main.Generator;
import Main.Solver;

public class EightPuzzleSolver {
	
	public EightPuzzleSolver() {
		super();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver(3);
		char[] operators = { 'L', 'R', 'U', 'D' };
		solver.setOperators(operators);
		
		int currentX = 1;
		int currentY = 2;
		int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
		
		EightPuzzleState initial = new EightPuzzleState();
		
		EightPuzzleState goal = new EightPuzzleState();
		goal = (EightPuzzleState) goal.apply('D');
		goal = (EightPuzzleState) goal.apply('R');
		goal = (EightPuzzleState) goal.apply('D');
		goal = (EightPuzzleState) goal.apply('R');
		goal = (EightPuzzleState) goal.apply('U');
		goal = (EightPuzzleState) goal.apply('L');
		
		ArrayList<Character> mySolution = new ArrayList<Character>();
		
		long startTime, finalTime;

		// mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.DFS);

		mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.BFS);
	}
}
