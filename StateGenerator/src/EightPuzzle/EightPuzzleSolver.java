package EightPuzzle;

import java.util.ArrayList;

import Main.Generator;
import Main.Solver;

public class EightPuzzleSolver {
	
	public EightPuzzleSolver() {
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Solver solver = new Solver();
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

		System.out.println("DFS Solving started...");
		startTime = System.nanoTime();
		mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.DFS);
		finalTime = System.nanoTime();
		if(mySolution != null) {
			System.out.println("Solution found in " + (finalTime - startTime)/1000000 + " miliseconds.");
			System.out.println(mySolution.size() + " operations:");
			System.out.println(mySolution);
		} else
		{
			System.out.println("No solution found. Spent " + (finalTime - startTime)/1000000 + " miliseconds.");
		}

		System.out.println("BFS Solving started...");
		startTime = System.nanoTime();
		mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.BFS);
		finalTime = System.nanoTime();
		if(mySolution != null) {
			System.out.println("Solution found in " + (finalTime - startTime)/1000000 + " miliseconds.");
			System.out.println(mySolution.size() + " operations:");
			System.out.println(mySolution);
		} else
		{
			System.out.println("No solution found. Spent " + (finalTime - startTime)/1000000 + " miliseconds.");
		}
	}
}
