package EightPuzzle;

import java.util.ArrayList;

import Main.Generator;
import Main.Solver;

public class EightPuzzleSolver {
	private Generator generator = new Generator();
	
	public EightPuzzleSolver() {
		char[] operators = { 'L', 'R', 'U', 'D' };
		generator.setOperators(operators);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver();
		
		int currentX = 1;
		int currentY = 2;
		int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
		
		EightPuzzleState initial = new EightPuzzleState();
		
		EightPuzzleState goal = new EightPuzzleState(board, currentX, currentY);
		
		ArrayList<Character> mySolution = new ArrayList<Character>();
		
		mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.DFS);
		
		System.out.println(mySolution);
	}
}
