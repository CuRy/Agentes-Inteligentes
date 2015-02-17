package EightPuzzle;

import java.util.ArrayList;

import Main.Operator;
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
		
		EightPuzzleState initial = new EightPuzzleState();
		
		EightPuzzleState goal = new EightPuzzleState();
		goal = (EightPuzzleState) goal.apply(operators[3]);
		goal = (EightPuzzleState) goal.apply(operators[1]);
		goal = (EightPuzzleState) goal.apply(operators[3]);
		goal = (EightPuzzleState) goal.apply(operators[1]);
		goal = (EightPuzzleState) goal.apply(operators[2]);
		goal = (EightPuzzleState) goal.apply(operators[0]);
		
		ArrayList<Operator> mySolution = new ArrayList<Operator>();
		
		long startTime, finalTime;
		
		startTime = System.currentTimeMillis();
		// mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.DFS);
		mySolution = solver.Solve(initial, goal, Solver.SolveStrategy.BFS);
		finalTime = System.currentTimeMillis();
		
		System.out.println(finalTime - startTime);
	}
}
